package com.plane.sincer.controller;

import com.plane.sincer.common.ResponseEntity;
import com.plane.sincer.entity.EquipMould;
import com.plane.sincer.service.EquipMouldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equip")
public class EquipMouldController {

    @Autowired
    private EquipMouldService equipMouldService;
    @GetMapping("/mould/list")
    public ResponseEntity getAllEquipMould(){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        List<EquipMould> list = equipMouldService.list();
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

    @GetMapping("/mould/{id}")
    public ResponseEntity getEquipMould(@PathVariable("id") Integer id){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        EquipMould mould = equipMouldService.getById(id);
        if(mould != null){
            entity.setCode("200");
            entity.setMessage("查询成功");
            entity.setBody(mould);
        } else {
            entity.setCode("404");
            entity.setMessage("查询失败");
        }
        return entity;
    }

    @PostMapping("/mould/add")
    public ResponseEntity addEquipMould(EquipMould equipMould){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        boolean save = equipMouldService.save(equipMould);
        if(save){
            entity.setCode("200");
            entity.setMessage("添加成功");
        } else {
            entity.setCode("404");
            entity.setMessage("添加失败");
        }
        return entity;
    }

    @PostMapping("/mould/edit")
    public ResponseEntity updEquipMould(EquipMould equipMould){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        boolean update = equipMouldService.updateById(equipMould);
        if(update){
            entity.setCode("200");
            entity.setMessage("修改成功");
        } else {
            entity.setCode("404");
            entity.setMessage("修改失败");
        }
        return entity;
    }

    @PostMapping("/mould/del/{id}")
    public ResponseEntity delEquipMould(@PathVariable Integer id) {
        boolean del = equipMouldService.removeById(id);
        ResponseEntity entity = new ResponseEntity();
        if (del) {
            entity.setCode("200");
            entity.setMessage("删除成功");
        } else {
            entity.setCode("500");
            entity.setMessage("删除失败");
        }
        return entity;
    }
}
