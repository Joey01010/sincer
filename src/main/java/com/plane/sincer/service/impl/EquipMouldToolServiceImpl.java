package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plane.sincer.entity.EquipMould;
import com.plane.sincer.entity.EquipMouldTool;
import com.plane.sincer.service.EquipMouldToolService;
import com.plane.sincer.mapper.EquipMouldToolMapper;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
* @author Admin
* @description 针对表【equip_mould_tool】的数据库操作Service实现
* @createDate 2022-12-07 17:12:17
*/
@Service
public class EquipMouldToolServiceImpl extends ServiceImpl<EquipMouldToolMapper, EquipMouldTool>
    implements EquipMouldToolService{
    @Override
    public EquipMouldTool getEquipMouldToolByTerminalId(String terminalId) {
        EquipMouldTool tool = this.getOne(new QueryWrapper<EquipMouldTool>().eq("terminal_new", terminalId));
        return tool;
    }

    @Override
    public Boolean importEquipMouldToolByExcel(MultipartFile file) {
        Boolean save = false;
        try {
            List<EquipMouldTool> tools = getEquipMouldTools(file.getInputStream());
            save = this.saveBatch(tools);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return save;
    }

    private List<EquipMouldTool> getEquipMouldTools(InputStream stream) {
        Workbook wb = null;

        List<EquipMouldTool> tools = new ArrayList<>();
        try {
            wb = WorkbookFactory.create(stream);
            //读取表格数据
            Sheet sheet = wb.getSheet("端子刀具盘点表");
            for (int i = 3; i <= sheet.getLastRowNum(); i++){
                Row row = sheet.getRow(i);

                //循环结束判断
                if(row.getCell(2).getStringCellValue().equals("") || row.getCell(2) == null){
                    break;
                }

                //封装模具信息
                EquipMouldTool tool = new EquipMouldTool();
                for (int j = 0; j < 9; j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    switch (j) {
                        case 1:
                            tool.setTeminalNew(cell.getStringCellValue());
                            break;
                        case 2:
                            tool.setTeminalOld(cell.getStringCellValue());
                            break;
                        case 3:
                            tool.setAddress(cell.getStringCellValue());
                            break;
                        case 4:
                            tool.setLineUp(Integer.parseInt(cell.getStringCellValue()));
                            break;
                        case 5:
                            tool.setIsolateUp(Integer.parseInt(cell.getStringCellValue()));
                            break;
                        case 6:
                            tool.setLineDown(Integer.parseInt(cell.getStringCellValue()));
                            break;
                        case 7:
                            tool.setIsolateDown(Integer.parseInt(cell.getStringCellValue()));
                            break;
                        case 8:
                            tool.setRemark(cell.getStringCellValue());
                            break;
                    }
                }
                tools.add(tool);
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

        return tools;
    }
}




