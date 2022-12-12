package com.plane.sincer.controller;

import com.plane.sincer.common.ResponseEntity;
import com.plane.sincer.entity.User;
import com.plane.sincer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public ResponseEntity getUserList(){
        List<User> list = userService.list();
        ResponseEntity<List<User>> entity = new ResponseEntity<>();
        if(list != null){
            entity.setCode("200");
            entity.setMessage("查询成功");
            entity.setBody(list);
        } else {
            entity.setCode("404");
            entity.setMessage("查询失败");
        }
        return entity;
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        ResponseEntity<User> entity = new ResponseEntity<>();
        if(user != null){
            entity.setCode("200");
            entity.setMessage("查询成功");
            entity.setBody(user);
        } else {
            entity.setCode("404");
            entity.setMessage("查询失败");
        }
        return entity;
    }

    @PostMapping("/add")
    public ResponseEntity saveUser(User user){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        boolean save = userService.save(user);
        if(save){
            entity.setCode("200");
            entity.setMessage("添加成功");
        } else {
            entity.setCode("404");
            entity.setMessage("添加失败");
        }
        return entity;
    }

    @PostMapping("/edit")
    public ResponseEntity updUser(User user){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        boolean edit = userService.updateById(user);
        if(edit){
            entity.setCode("200");
            entity.setMessage("修改成功");
        } else {
            entity.setCode("404");
            entity.setMessage("修改失败");
        }
        return entity;
    }

    @PostMapping("/del/{id}")
    public ResponseEntity delUser(@PathVariable("id") Integer id){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        boolean remove = userService.removeById(id);
        if(remove){
            entity.setCode("200");
            entity.setMessage("删除成功");
        } else {
            entity.setCode("404");
            entity.setMessage("删除失败");
        }
        return entity;
    }
}
