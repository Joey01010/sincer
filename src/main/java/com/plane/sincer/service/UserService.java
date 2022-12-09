package com.plane.sincer.service;

import com.plane.sincer.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Admin
* @description 针对表【user】的数据库操作Service
* @createDate 2022-12-07 17:10:24
*/
public interface UserService extends IService<User> {

    User getUserByName(String name);
}
