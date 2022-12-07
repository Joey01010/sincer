package com.plane.sincer.service;

import com.plane.sincer.entity.ProductRecord;
import com.plane.sincer.entity.ProductRecordResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Admin
 * @description 针对表【pd_rec_result】的数据库操作Service
 * @createDate 2022-11-24 09:16:03
 */
public interface ProductRecordResultService extends IService<ProductRecordResult> {

    boolean save(ProductRecord record);
}
