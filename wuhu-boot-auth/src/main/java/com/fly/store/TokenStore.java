package com.fly.store;

import cn.hutool.core.collection.ListUtil;
import com.fly.common.utils.RedisUtils;
import com.fly.constant.RedisKeyConstant;
import com.fly.user.UserDetail;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Description Token存储类, 用于操作access_token
 * @Author zchengfeng
 * @Date 2023/6/9 14:31
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
public class TokenStore {

    @Value("${jwt.expires}")
    private long expires;

    public String getKey(String accessToken) {
        return RedisKeyConstant.ACCESS_TOKEN + accessToken;
    }

    public void saveUser(String accessToken, UserDetail user) {
        RedisUtils.set(getKey(accessToken), user, expires, TimeUnit.SECONDS);
    }

    public UserDetail getUser(String accessToken) {
        return (UserDetail) RedisUtils.get(getKey(accessToken));
    }

    public void delUser(String accessToken) {
        RedisUtils.del(getKey(accessToken));
    }

    public List<String> getUserKeyList() {
        Set<String> sets = RedisUtils.keys(RedisKeyConstant.ACCESS_TOKEN + "*");
        return ListUtil.toList(sets);
    }
}
