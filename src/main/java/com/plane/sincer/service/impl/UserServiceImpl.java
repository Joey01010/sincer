package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plane.sincer.entity.User;
import com.plane.sincer.service.UserService;
import com.plane.sincer.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-12-15 16:17:22
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




