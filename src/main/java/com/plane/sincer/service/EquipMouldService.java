package com.plane.sincer.service;

import com.plane.sincer.entity.EquipMould;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Admin
* @description 针对表【equip_mould】的数据库操作Service
* @createDate 2022-12-07 17:11:56
*/
public interface EquipMouldService extends IService<EquipMould> {

    EquipMould getEquipMouldByTerminalId(String terminalId);
}
