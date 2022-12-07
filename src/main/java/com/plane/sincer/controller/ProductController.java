package com.plane.sincer.controller;

import com.github.pagehelper.PageInfo;
import com.plane.sincer.common.ResponseEntity;
import com.plane.sincer.entity.ProductList;
import com.plane.sincer.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/weld")
public class ProductController {

    @Autowired
    private ProductListService productListService;

    /**
     * 表格输入逐个录入产品信息
     *
     * @param productList
     * @return
     */
    @PostMapping("/pd/add")
    public ResponseEntity saveProduct(@RequestBody ProductList productList) {
        ResponseEntity entity = new ResponseEntity();
        boolean save = productListService.save(productList);
        if (save) {
            entity.setCode("200");
            entity.setMessage("添加成功");
        } else {
            entity.setCode("400");
            entity.setMessage("添加失败");
        }
        return entity;
    }


    /**
     * 通过Excel表格批量导入产品信息
     *
     * @param file
     * @return
     */
    @PostMapping("/pd/upload")
    public ResponseEntity saveProductByExcel(MultipartFile file) {
        ResponseEntity entity = new ResponseEntity();
        Boolean save = productListService.importProductListByExcel(file);
        if (save) {
            entity.setCode("200");
            entity.setMessage("上传成功");
        } else {
            entity.setCode("400");
            entity.setMessage("上传失败");
        }
        return entity;
    }

    /**
     * 根据产品信息id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/pd/{id}")
    public ResponseEntity<ProductList> getProductList(@PathVariable String id) {
        ProductList pd = productListService.getByPdId(id);
        ResponseEntity<ProductList> entity = new ResponseEntity<>();

        if (entity != null) {
            entity.setCode("200");
            entity.setMessage("查询成功");
            entity.setBody(pd);
        } else {
            entity.setCode("400");
            entity.setMessage("查询失败");
        }
        return entity;
    }

    /**
     * 查询产品信息列表
     *
     * @return
     */
    @GetMapping("/pd/all")
    public ResponseEntity<List<ProductList>> getPdList() {
        List<ProductList> list = productListService.list();
        ResponseEntity entity = new ResponseEntity();
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

    @GetMapping("/pd/allByPage")
    public ResponseEntity<PageInfo<ProductList>> getPdListByPage(@RequestParam(defaultValue = "1", value = "pageIndex") Integer pageIndex,
                                                                 @RequestParam(defaultValue = "20", value = "pageSize") Integer pageSize) {
        PageInfo<ProductList> pageInfo = productListService.getProductListByPage(pageIndex, pageSize);
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

    @GetMapping("/pd/search")
    public ResponseEntity<PageInfo<ProductList>> getPdListBySearch(@RequestParam String column,
                                                                   @RequestParam String columnValue,
                                                                   @RequestParam(defaultValue = "1", value = "pageIndex") Integer pageIndex,
                                                                   @RequestParam(defaultValue = "20", value = "pageSize") Integer pageSize) {
        ResponseEntity entity = new ResponseEntity();
        PageInfo<ProductList> pageInfo = productListService.getProductListBySearch(column, columnValue, pageIndex, pageSize);
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
     * 根据产品信息id更新
     *
     * @param pd
     * @return
     */
    @PutMapping("/pd/edit")
    public ResponseEntity updPdList(@RequestBody ProductList pd) {
        boolean upd = productListService.updateById(pd);
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
     * 根据产品id删除
     *
     * @param id
     * @return
     */
    @PostMapping("/pd/del/{id}")
    public ResponseEntity delPdList(@PathVariable Integer id) {
        boolean del = productListService.removeById(id);
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

    /**
     * 根据产品id批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/pd/delBatch")
    public ResponseEntity delPdLists(List<Integer> ids) {
        boolean del = productListService.removeBatchByIds(ids);
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
