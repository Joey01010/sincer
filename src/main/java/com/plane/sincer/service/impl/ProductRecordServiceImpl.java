package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.plane.sincer.entity.ProductList;
import com.plane.sincer.entity.ProductRecord;
import com.plane.sincer.entity.ProductRecordResult;
import com.plane.sincer.mapper.ProductRecordMapper;
import com.plane.sincer.service.ProductListService;
import com.plane.sincer.service.ProductRecordResultService;
import com.plane.sincer.service.ProductRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Admin
 * @description 针对表【pd_record】的数据库操作Service实现
 * @createDate 2022-11-22 10:20:17
 */
@Service
public class ProductRecordServiceImpl extends ServiceImpl<ProductRecordMapper, ProductRecord>
        implements ProductRecordService {

    @Autowired
    private ProductListService productListService;
    @Autowired
    private ProductRecordResultService recordResultService;

    @Override
    public boolean save(ProductRecord entity) {
        super.save(entity);
        return recordResultService.save(entity);
    }

    @Override
    public ProductRecord getById(Serializable id) {
        ProductRecord record = super.getById(id);
        List<ProductRecord> records = handleData(Arrays.asList(record));
        return records.get(0);
    }

    @Override
    public List<ProductRecord> list() {
        List<ProductRecord> list = super.list();
        list = handleData(list);
        return list;
    }

    @Override
    public PageInfo<ProductRecord> getProductRecordByPage(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<ProductRecord> list = this.list();
        PageInfo<ProductRecord> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ProductRecord> getProductRecordBySearch(String column, String value, Integer pageIndex, Integer pageSize) {
        List<ProductRecord> records = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        //条件分别查询
        if(column.equals("pd_code") || column.equals("pd_line")){
            List<ProductList> pds = productListService.list(new QueryWrapper<ProductList>().like(column, value));
            pds.forEach(pd -> ids.add(pd.getPdId()));
            //存在记录
            if(ids.size() > 0){
                PageHelper.startPage(pageIndex,pageSize);
                records = super.list(new QueryWrapper<ProductRecord>().in("pd_id", ids));
            }
        } else {
            PageHelper.startPage(pageIndex,pageSize);
            records = this.list(new QueryWrapper<ProductRecord>().like(column, value));
        }

        records = handleData(records);
        PageInfo<ProductRecord> pageInfo = new PageInfo<>(records);
        return pageInfo;
    }

    @Override
    public boolean removeById(Serializable id) {
        boolean remove = recordResultService.remove(new QueryWrapper<ProductRecordResult>().eq("rec_id", id));
        if(remove){
            return super.removeById(id);
        }
        return false;
    }

    /**
     * 日报记录封装产品信息和日报结果
     * @param records
     * @return
     */
    private List<ProductRecord> handleData(List<ProductRecord> records){
        if (records != null && records.size() > 0) {
            for (ProductRecord record : records) {
                ProductRecordResult result = recordResultService.getOne(new QueryWrapper<ProductRecordResult>().eq("rec_id", record.getId()));
                ProductList pd = productListService.getOne(new QueryWrapper<ProductList>().eq("pd_id", record.getPdId()));
                record.setResult(result);
                record.setProductList(pd);
            }
        }
        return records;
    }
}




