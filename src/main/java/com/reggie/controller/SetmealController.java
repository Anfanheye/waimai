package com.reggie.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.reggie.comon.R;
import com.reggie.dto.SetmealDto;

import com.reggie.entity.Category;
import com.reggie.entity.Setmeal;
import com.reggie.service.CategoryService;
import com.reggie.service.SetmealDishService;
import com.reggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 类描述：
 *     套餐管理
 * @ClassName SetmealController
 * @Description TODO
 * @Author Ming
 * @Date 2022/8/17 21:56
 * @Version 1.0
 */

@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmealController {
    @Autowired
    private SetmealService setmealService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * 新增套餐
     * @param setmealDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto){
        log.info("套餐信息:{}",setmealDto);

        setmealService.saveWithDish(setmealDto);

        return R.success("新增套餐成功");
    }

    /**
     * 套餐分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        //分页器构造对象
        Page<Setmeal> pageInfo = new Page<>(page,pageSize);

        Page<SetmealDto> dtoPage = new Page<>();

        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();

        //添加查询条件
        queryWrapper.like(name != null,Setmeal::getName,name);

        //添加一个排序条件，根据更新时间来降序排序
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);

        setmealService.page(pageInfo,queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo,dtoPage,"records");
        List<Setmeal> records = pageInfo.getRecords();

        List<SetmealDto> list = records.stream().map((item)->{
            SetmealDto setmealDto = new SetmealDto();
            //对象拷贝
            BeanUtils.copyProperties(item,setmealDto);
            //分类ID
            Long categoryId = item.getCategoryId();
            //根据分类ID查询分类对象
            Category category = categoryService.getById(categoryId);
            if (category != null){
                //分类名称
                String categoryName = category.getName();
                setmealDto.setCategoryName(categoryName);
            }
            return setmealDto;
        }).collect(Collectors.toList());

        dtoPage.setRecords(list);
        return R.success(dtoPage);
    }

    /**
     * 删除套餐
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delete(@RequestParam List<Long> id){
        log.info("id:{}",id);
        setmealService.removeWithDish(id);
        return R.success("套餐数据删除成功");
    }
}
