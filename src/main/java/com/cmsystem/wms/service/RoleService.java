package com.cmsystem.wms.service;

import com.cmsystem.wms.mapper.RoleAuthMapper;
import com.cmsystem.wms.mapper.RoleMapper;
import com.cmsystem.wms.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleAuthMapper roleAuthMapper;

    @Autowired
    RoleAuthService roleAuthService;

    /**
     * 重置角色权限
     * 将老权限全部删除
     * 批量添加新权限
     *
     * @param role
     */
    public void resetRoleAuth(Role role) {
        roleAuthMapper.deleteByRoleIds(String.valueOf(role.getId()));
        roleAuthMapper.insertAll(roleAuthService.createList(role));
    }

}
