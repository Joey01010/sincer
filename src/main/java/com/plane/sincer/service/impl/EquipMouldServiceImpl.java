package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plane.sincer.entity.EquipMould;
import com.plane.sincer.service.EquipMouldService;
import com.plane.sincer.mapper.EquipMouldMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【equip_mould】的数据库操作Service实现
* @createDate 2022-12-07 17:11:56
*/
@Service
public class EquipMouldServiceImpl extends ServiceImpl<EquipMouldMapper, EquipMould>
    implements EquipMouldService{
    @Override
    public EquipMould getEquipMouldByTerminalId(String terminalId) {
        EquipMould mould = this.getOne(new QueryWrapper<EquipMould>().eq("terminal_new", terminalId));
        return mould;
    }
}




