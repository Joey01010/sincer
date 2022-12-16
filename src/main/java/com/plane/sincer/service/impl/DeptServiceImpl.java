package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plane.sincer.entity.Dept;
import com.plane.sincer.service.DeptService;
import com.plane.sincer.mapper.DeptMapper;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* @author Admin
* @description 针对表【dept】的数据库操作Service实现
* @createDate 2022-12-16 09:42:54
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

    @Override
    public Dept getById(Serializable id) {
        return getDept(super.getById(id));
    }

    @Override
    public List<Dept> list() {
        List<Dept> depts = new ArrayList<>();
        super.list().forEach(dept -> {
            Dept temp = getDept(dept);
            depts.add(temp);
        });
        return depts;
    }

    private Dept getDept(Dept dept){
        if(dept != null){
            Dept parent = getById(dept.getParentDeptId());
            dept.setParentDept(parent);
            getDept(parent);
        }
        return dept;
    }
}




