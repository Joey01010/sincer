package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plane.sincer.entity.ProductList;
import com.plane.sincer.entity.ProductRecord;
import com.plane.sincer.entity.ProductRecordResult;
import com.plane.sincer.mapper.ProductRecordResultMapper;
import com.plane.sincer.service.ProductListService;
import com.plane.sincer.service.ProductRecordResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Admin
 * @description 针对表【pd_rec_result】的数据库操作Service实现
 * @createDate 2022-11-24 09:16:03
 */
@Service
public class ProductRecordResultServiceImpl extends ServiceImpl<ProductRecordResultMapper, ProductRecordResult>
        implements ProductRecordResultService {

    @Autowired
    private ProductListService productListService;

    @Override
    public boolean save(ProductRecord record) {
        //获取产品信息
        ProductList product = productListService.getByPdId(record.getPdId());

        ProductRecordResult result = new ProductRecordResult();
        //设置对应recordId
        result.setRecId(record.getId());
        //计算操作时间
        result.setOpTime(record.getUseTime());
        //计算负荷时间
        Integer loadTime = result.getOpTime() - record.getBfClassMt() - record.getBfStart() - record.getQcTime() - record.getThreeS();
        result.setLoadTime(loadTime);
        //计算纯生产时间
        Integer processTime = result.getLoadTime() - record.getDvTime() - record.getNewCmTime() - record.getCustmCm() - record.getPlanStop() - record.getDvBroken() - record.getDlWait() - record.getAnQa();
        result.setProcessTime(processTime);
        //计算时间稼动率
        Double timeRate = result.getProcessTime().doubleValue() / result.getLoadTime().doubleValue();
        result.setTimeRate(timeRate);
        //计算性能稼动率
        Double performanceRate = (product.getCt() * record.getPlanOp().doubleValue() / 60) / result.getProcessTime();
        result.setPerformanceRate(performanceRate);
        //计算工序内良品
        Integer passPdCount = record.getSaveCount() - record.getRuinCount() - record.getHalfRuinCount() - record.getRefuseCount();
        result.setPassPdCount(passPdCount);
        //计算良品率
        Double passRate = result.getPassPdCount().doubleValue() / record.getSaveCount();
        result.setPassRate(passRate);
        //计算设备使用率
        Double dvUseRate = result.getProcessTime().doubleValue() / result.getOpTime();
        result.setDvUseRate(dvUseRate);
        //计算实际CT
        Double realCt = result.getProcessTime().doubleValue() * 60 / record.getSaveCount();
        result.setRealCt(realCt);
        //计算总打点数
        Integer sumPoint = record.getSaveCount() * product.getCount();
        result.setSumPoint(sumPoint);
        //计算理论对应时间
        Double theoryPerTime = product.getCt().doubleValue() * record.getPlanOp() / 60;
        result.setTheoryPerTime(theoryPerTime);
        //计算设备综合稼动率
        Double dvCompRate = result.getPerformanceRate() * result.getTimeRate() * result.getPassRate();
        result.setDvCompRate(dvCompRate);
        //计算理论稼动率
        Double theoryRate = result.getTheoryPerTime() / result.getLoadTime();
        result.setTheoryRate(theoryRate);
        //计算理论出来高

        //计算实际出来高

        //计算完结率
        double overRate = result.getTimeRate() * result.getPerformanceRate() * result.getPassRate();
        result.setOverRate(overRate);

        return this.save(result);
    }


}




