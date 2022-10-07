package com.reggie.controller;

import com.reggie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类描述：
 *
 * @ClassName UserController
 * @Description TODO
 * @Author Ming
 * @Date 2022/10/7 9:12
 * @Version 1.0
 */
public class UserController {

    @Autowired
    private UserService userService;
}
