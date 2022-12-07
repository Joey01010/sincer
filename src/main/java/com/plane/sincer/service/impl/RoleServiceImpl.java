package com.plane.sincer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plane.sincer.entity.Role;
import com.plane.sincer.service.RoleService;
import com.plane.sincer.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【role】的数据库操作Service实现
* @createDate 2022-12-07 17:10:27
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




