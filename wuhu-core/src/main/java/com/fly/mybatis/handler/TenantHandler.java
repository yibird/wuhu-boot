//package com.fly.mybatis.handle;
//
//import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
//import net.sf.jsqlparser.expression.Expression;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @Description 多租户处理器
// * @Author zchengfeng
// * @Date 2023/11/11 11:31
// */
//@Component
//public class TenantHandler implements TenantLineHandler {
//    // 租户字段
//    private final static String TENANT_ID = "tenant_id";
//    // 忽略添加租户id表集合
//    private final static List<String> IGNORE_TABLES = List.of("sys_tenant");
//
//    @Override
//    public Expression getTenantId() {
//        return null;
//    }
//
//    @Override
//    public String getTenantIdColumn() {
//        return TENANT_ID;
//    }
//
//    @Override
//    public boolean ignoreTable(String tableName) {
//        return IGNORE_TABLES.contains(tableName);
//    }
//
//}
