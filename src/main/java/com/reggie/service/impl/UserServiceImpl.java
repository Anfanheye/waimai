package com.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.entity.User;
import com.reggie.mapper.UserMapper;
import com.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Ming
 * @Date 2022/10/7 9:11
 * @Version 1.0
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
