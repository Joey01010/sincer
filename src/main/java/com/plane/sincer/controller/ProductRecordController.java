package com.plane.sincer.controller;

import com.github.pagehelper.PageInfo;
import com.plane.sincer.common.ResponseEntity;
import com.plane.sincer.entity.ProductList;
import com.plane.sincer.entity.ProductRecord;
import com.plane.sincer.service.ProductListService;
import com.plane.sincer.service.ProductRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weld")
public class ProductRecordController {
    @Autowired
    private ProductListService productListService;

    @Autowired
    private ProductRecordService productRecordService;

    /**
     * 录入日报信息
     *
     * @param record
     * @return
     */
    @PostMapping("/record/add")
    public ResponseEntity savRecord(@RequestBody ProductRecord record) {
        //计算用时
        Long useTime = (record.getEndTime().getTime() - record.getStartTime().getTime()) / (60 * 1000);
        record.setUseTime(useTime.intValue());
        //读取生产产线
        ProductList pd = productListService.getByPdId(record.getPdId());
        record.setClassName(pd.getPdLine());
        //计算计划用时
        Double planTime = pd.getCt() * record.getPlanOp() / 60 + record.getRestTime() + record.getBfClassMt() +
                record.getBfStart() + record.getQcTime() + record.getThreeS() + record.getDvTime() + record.getNewCmTime() +
                record.getCustmCm() + record.getPlanStop();
        record.setPlanTime(planTime.intValue() + 1);
        //存入数据库
        boolean save = productRecordService.save(record);
        ResponseEntity<Object> entity = new ResponseEntity<>();
        if (save) {
            entity.setCode("200");
            entity.setMessage("录入成功");
        } else {
            entity.setCode("400");
            entity.setMessage("录入失败");
        }
        return entity;
    }

    /**
     * 根据日报id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/record/{id}")
    public ResponseEntity<ProductRecord> getRecord(@PathVariable Integer id) {
        ProductRecord record = productRecordService.getById(id);
        ResponseEntity<ProductRecord> entity = new ResponseEntity<>();
        if (record != null) {
            entity.setCode("200");
            entity.setMessage("查询成功");
            entity.setBody(record);
        } else {
            entity.setCode("404");
            entity.setMessage("查询为空");
        }
        return entity;
    }

    /**
     * 查询所有日报
     *
     * @return
     */
    @GetMapping("/record/all")
    public ResponseEntity<List<ProductRecord>> getAllRecord() {
        List<ProductRecord> list = productRecordService.list();
        ResponseEntity<List<ProductRecord>> entity = new ResponseEntity<>();
        if (list != null) {
            entity.setCode("200");
            entity.setMessage("查询成功");
            entity.setBody(list);
        } else {
            entity.setCode("404");
            entity.setMessage("查询为空");
        }
        return entity;
    }

    @GetMapping("/record/allByPage")
    public ResponseEntity<PageInfo<ProductList>> getPdRecordByPage(@RequestParam(defaultValue = "1", value = "pageIndex") Integer pageIndex,
                                                                 @RequestParam(defaultValue = "20", value = "pageSize") Integer pageSize) {
        PageInfo<ProductRecord> pageInfo = productRecordService.getProductRecordByPage(pageIndex, pageSize);
        ResponseEntity entity = new ResponseEntity();
        if (pageInfo.getList() != null) {
            entity.setCode("200");
            entity.setMessage("查询成功");
            entity.setBody(pageInfo);
        } else {
            entity.setCode("404");
            entity.setMessage("查询为空");
        }
        return entity;
    }

    @GetMapping("/record/search")
    public ResponseEntity<PageInfo<ProductRecord>> getPdRecordBySearch(@RequestParam String column,
                                                                   @RequestParam String columnValue,
                                                                   @RequestParam(defaultValue = "1", value = "pageIndex") Integer pageIndex,
                                                                   @RequestParam(defaultValue = "20", value = "pageSize") Integer pageSize) {
        ResponseEntity entity = new ResponseEntity();
        PageInfo<ProductRecord> pageInfo = productRecordService.getProductRecordBySearch(column, columnValue, pageIndex, pageSize);
        if (pageInfo.getList() != null) {
            entity.setCode("200");
            entity.setMessage("查询成功");
            entity.setBody(pageInfo);
        } else {
            entity.setCode("404");
            entity.setMessage("查询为空");
        }
        return entity;
    }

    /**
     * 根据日报id更新
     *
     * @param record
     * @return
     */
    @PostMapping("/record/edit")
    public ResponseEntity updRecord(@RequestBody ProductRecord record) {
        boolean upd = productRecordService.updateById(record);
        ResponseEntity entity = new ResponseEntity();
        if (upd) {
            entity.setCode("200");
            entity.setMessage("更新成功");
        } else {
            entity.setCode("500");
            entity.setMessage("更新失败");
        }
        return entity;
    }

    /**
     * 根据日报id删除
     *
     * @param id
     * @return
     */
    @PostMapping("/record/del/{id}")
    public ResponseEntity updRecord(@PathVariable Integer id) {
        boolean del = productRecordService.removeById(id);
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
