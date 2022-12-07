package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plane.sincer.entity.Dept;
import com.plane.sincer.service.DeptService;
import com.plane.sincer.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【dept】的数据库操作Service实现
* @createDate 2022-12-07 17:10:32
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

}




