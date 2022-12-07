package com.plane.sincer.service;

import com.github.pagehelper.PageInfo;
import com.plane.sincer.entity.ProductList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Admin
 * @description 针对表【pd_list】的数据库操作Service
 * @createDate 2022-11-23 10:25:44
 */
public interface ProductListService extends IService<ProductList> {

    ProductList getByPdId(String id);

    PageInfo<ProductList> getProductListByPage(Integer pageIndex, Integer pageSize);

    PageInfo<ProductList> getProductListBySearch(String column, String value, Integer pageIndex, Integer pageSize);

    Boolean importProductListByLocal(String fileName);

    Boolean importProductListByExcel(MultipartFile file);

}
