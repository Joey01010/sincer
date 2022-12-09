package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plane.sincer.entity.Dept;
import com.plane.sincer.entity.Role;
import com.plane.sincer.entity.User;
import com.plane.sincer.service.DeptService;
import com.plane.sincer.service.RoleService;
import com.plane.sincer.service.UserService;
import com.plane.sincer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* @author Admin
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-12-07 17:10:24
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private RoleService roleService;

    @Autowired
    private DeptService deptService;

    @Override
    public User getUserByName(String name) {
        User user = super.getOne(new QueryWrapper<User>().eq("user_name", name));
        return dataHandler(user.getId());
    }

    @Override
    public User getById(Serializable id) {
        return dataHandler(id);
    }

    @Override
    public List<User> list() {
        List<User> result = new ArrayList<>();
        super.list().stream().forEach(user -> result.add(dataHandler(user.getId())));
        return result;
    }

    private User dataHandler(Serializable id){
        User user = super.getById(id);
        Dept dept = deptService.getById(user.getDeptId());
        user.setDept(dept);
        Role role = roleService.getById(user.getRoleId());
        user.setRole(role);
        return user;
    }
}




