package com.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.entity.Employee;
import com.reggie.mapper.EmployeeMapper;
import com.reggie.service.EmployeeServices;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @ClassName EmployeeServieImpl
 * @Description TODO
 * @Author Ming
 * @Date 2022/7/18 15:47
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeServices {
}
