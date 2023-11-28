//package com.fly.mybatis.handle;
//
//import cn.hutool.core.date.DateTime;
//import cn.hutool.core.date.DateUtil;
//import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
//import org.apache.ibatis.reflection.MetaObject;
//import org.springframework.stereotype.Component;
//
///**
// * @Description 字段数据填充处理器
// * @Author zchengfeng
// * @Date 2023/3/13 11:31
// */
//@Component
//public class FiledDataFillHandler implements MetaObjectHandler {
//
//    /**
//     * 执行insert语句时数据填充操作
//     * @param metaObject 元对象
//     */
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        this.strictInsertFill(metaObject, "createBy", String.class, getOperator());
//        this.strictInsertFill(metaObject, "createTime", String.class, getCurrentDateTime());
//    }
//
//    /**
//     * 执行update语句时数据填充操作
//     * @param metaObject 元对象
//     */
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        this.strictUpdateFill(metaObject, "updateBy", String.class, getOperator());
//        this.strictUpdateFill(metaObject, "updateTime", String.class, getCurrentDateTime());
//    }
//
//    /**
//     * 从redis获取操作人
//     *
//     * @return 操作人名称
//     */
//    private String getOperator() {
//        return "zxp";
//    }
//
//    /**
//     * 获取当前时间并格式化
//     *
//     * @return 返回格式化后的当前时间
//     */
//    private String getCurrentDateTime() {
//        return DateUtil.format(DateTime.now(), "YYYY-mm-DD HH:mm:ss");
//    }
//}
