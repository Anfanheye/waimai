package com.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.entity.AddressBook;
import com.reggie.mapper.AddressBookMapper;
import com.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @ClassName AddressBookServiceImpl
 * @Description TODO
 * @Author Ming
 * @Date 2022/9/2 13:22
 * @Version 1.0
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
