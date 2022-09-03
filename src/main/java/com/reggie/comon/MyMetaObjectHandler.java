package com.reggie.comon;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 类描述：
 *       自定义源数据对象处理器
 * @ClassName MyMetaObjectHandler
 * @Description TODO
 * @Author Ming
 * @Date 2022/7/21 11:11
 * @Version 1.0
 */

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入操作，自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
      log.info("公共字段自动填充[insert]");
      log.info(metaObject.toString());

      metaObject.setValue("createTime", LocalDateTime.now());
      metaObject.setValue("updateTime",LocalDateTime.now());
      metaObject.setValue("createUser",BaseContext.getCurrentId());
      metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }

    /**
     * 更新操作，自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update]");
        log.info(metaObject.toString());

        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }
}
