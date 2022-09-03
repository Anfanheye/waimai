package com.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.entity.DishFlavor;
import com.reggie.mapper.DishFlavorMapper;
import com.reggie.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @ClassName DishFlavorServiceImpl
 * @Description TODO
 * @Author Ming
 * @Date 2022/7/26 11:22
 * @Version 1.0
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
