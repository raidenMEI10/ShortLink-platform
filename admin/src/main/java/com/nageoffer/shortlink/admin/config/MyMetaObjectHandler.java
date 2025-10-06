package com.nageoffer.shortlink.admin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

//通过mybatisplus提供的接口实现自动填充
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // TODO 这里使用LocalDateTime会导致mybatisplus匹配字段类型的时候失效
        this.strictInsertFill(metaObject, "createTime", Date::new, Date.class); //参数分别为源对象，字段名，获取值的方法，字段类型
        this.strictInsertFill(metaObject, "updateTime", Date::new, Date.class); //参数分别为源对象，字段名，获取值的方法，字段类型
        this.strictInsertFill(metaObject, "delFlag", () ->0, Integer.class); //参数分别为源对象，字段名，获取值的方法，字段类型
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "UpdateTime", Date::new, Date.class); //参数分别为源对象，字段名，获取值的方法，字段类型
    }
}
