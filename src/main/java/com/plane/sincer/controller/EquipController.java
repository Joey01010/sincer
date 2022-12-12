package com.plane.sincer.controller;

import com.plane.sincer.common.ResponseEntity;
import com.plane.sincer.entity.Equip;
import com.plane.sincer.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equip")
public class EquipController {

    @Autowired
    private EquipService equipService;

    @RequestMapping("/list")
    public ResponseEntity getAllEquip(){
        List<Equip> list = equipService.list();
        ResponseEntity<Object> entity = new ResponseEntity<>();
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


    @RequestMapping("/{id}")
    public ResponseEntity getEquip(@PathVariable("id") Integer id){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        Equip equip = equipService.getById(id);
        if(equip != null){
            entity.setCode("200");
            entity.setMessage("查询成功");
            entity.setBody(equip);
        } else {
            entity.setCode("404");
            entity.setMessage("查询失败");
        }
        return entity;
    }

    @PostMapping("/add")
    public ResponseEntity addEquip(Equip equip){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        boolean save = equipService.save(equip);
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
    public ResponseEntity updEquip(Equip equip){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        boolean update = equipService.updateById(equip);
        if(update){
            entity.setCode("200");
            entity.setMessage("修改成功");
        } else {
            entity.setCode("500");
            entity.setMessage("修改失败");
        }
        return entity;
    }

    @PostMapping("/del/{id}")
    public ResponseEntity delEquip(@PathVariable Integer id){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        boolean remove = equipService.removeById(id);
        if(remove){
            entity.setCode("200");
            entity.setMessage("删除成功");
        } else {
            entity.setCode("500");
            entity.setMessage("删除失败");
        }
        return entity;
    }
}
