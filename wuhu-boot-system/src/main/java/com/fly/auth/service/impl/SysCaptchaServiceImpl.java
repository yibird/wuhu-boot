package com.fly.auth.service.impl;

import com.fly.auth.service.SysCaptchaService;
import com.fly.common.constant.RedisKeyConstant;
import com.fly.common.model.response.ApiResult;
import com.fly.common.utils.RedisUtils;
import com.google.code.kaptcha.Producer;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.util.FastByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description 验证码服务实现类
 * @Author zchengfeng
 * @Date 2023/7/03 14:30
 */
@Service
@AllArgsConstructor
public class SysCaptchaServiceImpl implements SysCaptchaService {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String BASE64_PREFIX = "data:image/jpg;base64,";
    private static final String IMAGE_FORMAT = "jpg";
    private static final Long EXPIRES = 60L;
    private final Producer producer;

    @Override
    public ApiResult<String> generate() {
        String code = producer.createText();
        BufferedImage bufferedImage = producer.createImage(code);
        try (FastByteArrayOutputStream fos = new FastByteArrayOutputStream()) {
            ImageIO.write(bufferedImage, IMAGE_FORMAT, fos);
            String base64 = BASE64_PREFIX + Base64.encodeBase64String(fos.toByteArray());
            RedisUtils.set(RedisKeyConstant.CAPTCHA + code, code, EXPIRES);
            return ApiResult.ok(base64);
        } catch (IOException e) {
            return ApiResult.error("Error generating verification code");
        }
    }

    @Override
    public boolean validate(String code) {
        return RedisUtils.hasKey(RedisKeyConstant.CAPTCHA + code);
    }
}
