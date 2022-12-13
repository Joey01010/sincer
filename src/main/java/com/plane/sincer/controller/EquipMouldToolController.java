package com.plane.sincer.controller;

import com.plane.sincer.common.ResponseEntity;
import com.plane.sincer.entity.EquipMouldTool;
import com.plane.sincer.service.EquipMouldToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/equip")
public class EquipMouldToolController {

    @Autowired
    private EquipMouldToolService equipMouldToolService;

    @GetMapping("/tool/list")
    public ResponseEntity getAllEquipMould(){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        List<EquipMouldTool> list = equipMouldToolService.list();
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

    @GetMapping("/tool/{id}")
    public ResponseEntity getEquipMould(@PathVariable("id") Integer id){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        EquipMouldTool tool = equipMouldToolService.getById(id);
        if(tool != null){
            entity.setCode("200");
            entity.setMessage("查询成功");
            entity.setBody(tool);
        } else {
            entity.setCode("404");
            entity.setMessage("查询失败");
        }
        return entity;
    }

    @PostMapping("/tool/add")
    public ResponseEntity addEquipMould(EquipMouldTool equipMouldTool){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        boolean save = equipMouldToolService.save(equipMouldTool);
        if(save){
            entity.setCode("200");
            entity.setMessage("添加成功");
        } else {
            entity.setCode("404");
            entity.setMessage("添加失败");
        }
        return entity;
    }

    @PostMapping("/tool/edit")
    public ResponseEntity updEquipMould(EquipMouldTool equipMouldTool){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        boolean update = equipMouldToolService.updateById(equipMouldTool);
        if(update){
            entity.setCode("200");
            entity.setMessage("修改成功");
        } else {
            entity.setCode("404");
            entity.setMessage("修改失败");
        }
        return entity;
    }

    @PostMapping("/tool/del/{id}")
    public ResponseEntity delEquipMould(@PathVariable Integer id) {
        boolean del = equipMouldToolService.removeById(id);
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

    @PostMapping("/tool/upload")
    public ResponseEntity saveEquipMouldToolByExcel(MultipartFile file) {
        ResponseEntity entity = new ResponseEntity();
        Boolean save = equipMouldToolService.importEquipMouldToolByExcel(file);
        if (save) {
            entity.setCode("200");
            entity.setMessage("上传成功");
        } else {
            entity.setCode("400");
            entity.setMessage("上传失败");
        }
        return entity;
    }

    @PostMapping("/tool/reduce")
    public ResponseEntity takeOutEquipMouldTool(Integer id,Integer type,Integer number){
        ResponseEntity<Object> entity = new ResponseEntity<>();
        EquipMouldTool tool = equipMouldToolService.getById(id);
        switch (type) {
            case 0:
                tool.setLineUp((tool.getLineUp() - number) >= 0 ? (tool.getLineUp() - number) : tool.getLineUp());
                break;
            case 1:
                tool.setIsolateUp((tool.getIsolateUp() - number) >= 0 ? (tool.getIsolateUp() - number) : tool.getIsolateUp());
                break;
            case 2:
                tool.setLineDown((tool.getLineDown() - number) >= 0 ? (tool.getLineDown() - number) : tool.getLineDown());
                break;
            case 3:
                tool.setIsolateDown((tool.getIsolateDown() - number) >= 0 ? (tool.getIsolateDown() - number) : tool.getIsolateDown());
                break;
        }
        boolean upd = equipMouldToolService.updateById(tool);
        if(upd){
            entity.setCode("200");
            entity.setMessage("库存修改成功");
        } else {
            entity.setCode("400");
            entity.setMessage("库存修改失败");
        }
        return entity;
    }
}
