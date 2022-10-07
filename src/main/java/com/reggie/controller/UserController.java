package com.reggie.controller;

import com.reggie.comon.R;
import com.reggie.entity.User;
import com.reggie.service.UserService;
import com.reggie.utils.SMSUtils;
import com.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 类描述：
 *
 * @ClassName UserController
 * @Description TODO
 * @Author Ming
 * @Date 2022/10/7 9:12
 * @Version 1.0
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 发送手机验证码
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        //获取手机号
        String phone = user.getPhone();

        if (StringUtils.isNotEmpty(phone)){
            //生成随机四位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code={}",code);

            //调用阿里云提供的短信服务API完成发送短信
            //SMSUtils.sendMessage("外卖","",phone,code);

            //需要将验证码保存到Session
            session.setAttribute(phone,code);

            return R.success("手机验证码发送成功");
        }

        return R.error("短信发送失败");
    }
}
