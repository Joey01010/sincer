package com.plane.sincer.service;

import com.plane.sincer.entity.EquipMould;
import com.plane.sincer.entity.EquipMouldTool;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
* @author Admin
* @description 针对表【equip_mould_tool】的数据库操作Service
* @createDate 2022-12-07 17:12:17
*/
public interface EquipMouldToolService extends IService<EquipMouldTool> {

    EquipMouldTool getEquipMouldToolByTerminalId(String terminalId);

    Boolean importEquipMouldToolByExcel(MultipartFile file);
}
