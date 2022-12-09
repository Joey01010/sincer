package com.plane.sincer.controller;

import com.plane.sincer.common.ResponseEntity;
import com.plane.sincer.entity.User;
import com.plane.sincer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity login(String username, String password){
        User user = userService.getUserByName(username);
        ResponseEntity<Object> entity = new ResponseEntity<>();
        if(user != null){
            if(user.getPassWord().equals(password)){
                entity.setCode("200");
                entity.setMessage("登录成功");
                entity.setBody(user);
            }
            entity.setCode("403");
            entity.setMessage("密码错误");
        } else {
            entity.setCode("401");
            entity.setMessage("用户名不存在");
        }
        return entity;
    }


}
