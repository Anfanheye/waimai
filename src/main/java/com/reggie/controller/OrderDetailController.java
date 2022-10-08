package com.reggie.controller;

import com.reggie.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述：
 *
 * @ClassName OrderDetailController
 * @Description TODO
 * @Author Ming
 * @Date 2022/10/8 16:13
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;
}
