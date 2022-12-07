package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.plane.sincer.entity.ProductList;
import com.plane.sincer.mapper.ProductListMapper;
import com.plane.sincer.service.ProductListService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 * @description 针对表【pd_list】的数据库操作Service实现
 * @createDate 2022-11-23 10:25:44
 */
@Service
public class ProductListServiceImpl extends ServiceImpl<ProductListMapper, ProductList>
        implements ProductListService {

    @Override
    public PageInfo<ProductList> getProductListBySearch(String column, String value, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<ProductList> list = this.list(new QueryWrapper<ProductList>().like(column, value));
        PageInfo<ProductList> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ProductList> getProductListByPage(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<ProductList> pdList = this.list();
        PageInfo<ProductList> pageInfo = new PageInfo<>(pdList);
        return pageInfo;
    }

    @Override
    public ProductList getByPdId(String id) {
        return super.getOne(new QueryWrapper<ProductList>().eq("pd_id", id));
    }

    @Override
    public Boolean importProductListByExcel(MultipartFile file) {
        Boolean save = false;
        try {
            List<ProductList> pds = getProductLists(file.getInputStream());
            save = this.saveBatch(pds);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return save;
    }

    @Override
    public Boolean importProductListByLocal(String fileName) {
        //导入Excel路径
        String path = "D:\\plane\\program\\Java\\project\\sincer\\src\\main\\resources\\static\\" + fileName;

        Boolean save = false;
        try {
            FileInputStream stream = new FileInputStream(path);
            List<ProductList> pds = getProductLists(stream);
            save = this.saveBatch(pds);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return save;
    }

    private List<ProductList> getProductLists(InputStream stream) {
        //创建Excel操作对象
        HSSFWorkbook wb = null;

        List<ProductList> pds = new ArrayList<>();
        try {
            wb = new HSSFWorkbook(stream);
            //读取表格数据
            HSSFSheet sheet = wb.getSheet("产品清单信息");
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow(i);
                //封装产品信息
                ProductList pd = new ProductList();
                for (int j = 0; j < 12; j++) {
                    HSSFCell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    switch (j) {
                        case 0:
                            pd.setPdId(cell.getStringCellValue());
                            break;
                        case 1:
                            pd.setPdLine(cell.getStringCellValue());
                            break;
                        case 2:
                            pd.setType(cell.getStringCellValue());
                            break;
                        case 3:
                            pd.setPdCode(cell.getStringCellValue());
                            break;
                        case 4:
                            pd.setPdName(cell.getStringCellValue());
                            break;
                        case 5:
                            pd.setSpec(cell.getStringCellValue());
                            break;
                        case 6:
                            if (!cell.getStringCellValue().equals("")) {
                                pd.setCt(Double.parseDouble(cell.getStringCellValue()));
                            }
                            break;
                        case 7:
                            if (!cell.getStringCellValue().equals("")) {
                                pd.setCount(Integer.parseInt(cell.getStringCellValue()));
                            }
                            break;
                        case 8:
                            pd.setProcessNo(cell.getStringCellValue());
                            break;
                        case 9:
                            if (!cell.getStringCellValue().equals("")) {
                                pd.setAssist(Integer.parseInt(cell.getStringCellValue()));
                            }
                            break;
                        case 11:
                            pd.setMcCode(cell.getStringCellValue());
                            break;
                    }
                }
                pds.add(pd);
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
        return pds;
    }
}




