package com.cmsystem.wms.service;

import com.cmsystem.wms.mapper.AuthMapper;
import com.cmsystem.wms.mapper.RoleMapper;
import com.cmsystem.wms.model.Auth;
import com.cmsystem.wms.model.UserInfo;
import com.cmsystem.wms.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthValidateService extends BaseService {

    @Autowired
    AuthMapper authMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    HttpServletRequest request;

    private String requestAddr;
    private UserInfo loginUser;

    /**
     * 验证用户权限是否足够
     * 查询auth 权限是否有定义
     * 没有定义则直接通过验证
     * 验证接口是否在登录用户的auth 列表中
     *
     * @return
     */
    public boolean validate() {
        init();
        if (loginUser.getIsRoot() == 1) {
            return true;
        }
        if (request.getMethod().toLowerCase().equals("get")) {
            return true;
        }
        if (!checkExp()) {
            return false;
        }
        Auth a = authMapper.findByName(requestAddr);
        if (a == null) {
            return true;
        }
        Auth myAuth = authMapper.findByUserAndAuthName(loginUser, requestAddr);
        return myAuth != null;
    }

    /**
     * 初始化
     */
    private void init() {
        requestAddr = request.getRequestURI();
        loginUser = userInfoService.getLoginUser();
    }

    /**
     * 检查权限例外
     * 是否为例外接口
     * 是否为 isRoot
     *
     * @return
     */
    private boolean checkExp() {
        if (!requestAddr.contains("/role_auth/auth")) {
            return true;
        }
        return loginUser.getIsRoot() == 1;
    }


}
