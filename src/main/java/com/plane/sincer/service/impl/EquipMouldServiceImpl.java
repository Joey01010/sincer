package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plane.sincer.entity.EquipMould;
import com.plane.sincer.mapper.EquipMouldMapper;
import com.plane.sincer.service.EquipMouldService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Boolean importEquipMouldByExcel(MultipartFile file) {
        Boolean save = false;
        try {
            List<EquipMould> ems = getEquipMoulds(file.getInputStream());
            save = this.saveBatch(ems);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return save;
    }

    private List<EquipMould> getEquipMoulds(InputStream stream) {
        Workbook wb = null;

        List<EquipMould> ems = new ArrayList<>();
        try {
            wb = WorkbookFactory.create(stream);
            //读取表格数据
            Sheet sheet = wb.getSheet("模具盘点表");
            for (int i = 4; i <= sheet.getLastRowNum(); i++){
                Row row = sheet.getRow(i);

                //循环结束判断
                if(row.getCell(2).getStringCellValue().equals("") || row.getCell(2) == null){
                    break;
                }

                //封装模具信息
                EquipMould mould = new EquipMould();
                for (int j = 0; j < 13; j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    switch (j) {
                        case 2:
                            mould.setName(cell.getStringCellValue());
                            break;
                        case 3:
                            mould.setCode(cell.getStringCellValue());
                            break;
                        case 4:
                            mould.setTeminalOld(cell.getStringCellValue());
                            break;
                        case 5:
                            mould.setTeminalNew(cell.getStringCellValue());
                            break;
                        case 6:
                            mould.setCurrQuanlity(Integer.parseInt(cell.getStringCellValue()));
                            break;
                        case 8:
                            String exist = cell.getStringCellValue();
                            mould.setIsExist(exist.equals("√") ? 1 : 0);
                            break;
                        case 9:
                            mould.setAddress(cell.getStringCellValue());
                            break;
                        case 10:
                            String status = cell.getStringCellValue();
                            mould.setStatus(status.equals("可使用") ? 1 : 0);
                            break;
                        case 12:
                            mould.setRemark(cell.getStringCellValue());
                            break;
                    }
                }
                ems.add(mould);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //资源释放
            try {
                if (wb != null) {
                    wb.close();
                }
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return ems;
    }
}




