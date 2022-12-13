package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plane.sincer.entity.EquipBackup;
import com.plane.sincer.service.EquipBackupService;
import com.plane.sincer.mapper.EquipBackupMapper;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
* @author Admin
* @description 针对表【equip_backup】的数据库操作Service实现
* @createDate 2022-12-07 17:11:52
*/
@Service
public class EquipBackupServiceImpl extends ServiceImpl<EquipBackupMapper, EquipBackup>
    implements EquipBackupService{

    @Override
    public Boolean importEquipBackupByExcel(MultipartFile file) {
        Boolean save = false;
        try {
            List<EquipBackup> backups = getEquipBackups(file.getInputStream());
            save = this.saveBatch(backups);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return save;
    }

    private List<EquipBackup> getEquipBackups(InputStream stream) {
        Workbook wb = null;

        List<EquipBackup> backups = new ArrayList<>();
        try {
            wb = WorkbookFactory.create(stream);
            //读取表格数据
            Sheet sheet = wb.getSheet("备件清单");
            for (int i = 3; i <= sheet.getLastRowNum(); i++){
                Row row = sheet.getRow(i);

                //循环结束判断
                if(row.getCell(2).getStringCellValue().equals("") || row.getCell(2) == null){
                    break;
                }

                //封装模具信息
                EquipBackup backup = new EquipBackup();
                for (int j = 0; j < 11; j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    switch (j) {
                        case 1:
                            backup.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            backup.setCode(cell.getStringCellValue());
                            break;
                        case 3:
                            backup.setSpec(cell.getStringCellValue());
                            break;
                        case 4:
                            backup.setAddress(cell.getStringCellValue());
                            break;
                        case 5:
                            backup.setMinQuantity(Integer.parseInt(cell.getStringCellValue()));
                            break;
                        case 6:
                            backup.setMaxQuantity(Integer.parseInt(cell.getStringCellValue()));
                            break;
                        case 7:
                            backup.setCurrQuantity(Integer.parseInt(cell.getStringCellValue()));
                            break;
                        case 8:
                            backup.setUnit(cell.getStringCellValue());
                            break;
                        case 9:
                            backup.setType(cell.getStringCellValue());
                            break;
                        case 10:
                            backup.setRemark(cell.getStringCellValue());
                            break;
                    }
                }
                backups.add(backup);
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

        return backups;
    }
}




