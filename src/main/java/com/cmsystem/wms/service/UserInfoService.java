package com.cmsystem.wms.service;

import com.cmsystem.wms.entity.Token;
import com.cmsystem.wms.mapper.RoleMapper;
import com.cmsystem.wms.mapper.UserInfoMapper;
import com.cmsystem.wms.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    HttpServletRequest request;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    LoginRecordService loginRecordService;

    /**
     * 刷新用户在数据库中的  token
     *
     * @param userinfo 用户
     */
    public void refreshUserToken(UserInfo userinfo) {
        Token token = new Token(userinfo);
        userinfo.setToken(token.createTokenEnString());
        userInfoMapper.refreshToken(userinfo);
    }

    /**
     * 获取登录用户
     *
     * @return
     */
    public UserInfo getLoginUser() {
        return (UserInfo) request.getAttribute("loginUser");
    }

    /**
     * 批量隐藏安全字段
     *
     * @param users
     * @return
     */
    public List<UserInfo> hiddenSecurity(List<UserInfo> users) {
        for (UserInfo user : users) {
            user.hiddenSecurity();
        }
        return users;
    }

    /**
     * 用户退出登录
     *
     * @return
     */
    public Integer logOut() {
        loginRecordService.addLogout();
        return userInfoMapper.logout(getLoginUser());
    }

}
