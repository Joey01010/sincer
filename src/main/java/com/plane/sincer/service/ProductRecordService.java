package com.plane.sincer.service;

import com.github.pagehelper.PageInfo;
import com.plane.sincer.entity.ProductList;
import com.plane.sincer.entity.ProductRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Admin
 * @description 针对表【pd_record】的数据库操作Service
 * @createDate 2022-11-22 10:20:17
 */
public interface ProductRecordService extends IService<ProductRecord> {

    PageInfo<ProductRecord> getProductRecordByPage(Integer pageIndex, Integer pageSize);

    PageInfo<ProductRecord> getProductRecordBySearch(String column, String value, Integer pageIndex, Integer pageSize);
}
