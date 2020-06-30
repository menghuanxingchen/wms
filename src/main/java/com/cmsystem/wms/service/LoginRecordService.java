package com.cmsystem.wms.service;

import com.cmsystem.wms.mapper.LoginRecordMapper;
import com.cmsystem.wms.model.LoginRecord;
import com.cmsystem.wms.model.UserInfo;
import com.cmsystem.wms.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginRecordService extends BaseService {

    @Autowired
    LoginRecordMapper loginRecordMapper;

    @Autowired
    HttpServletRequest request;

    /**
     * 根据 type 类型添加
     * 自动追加其他需要字段
     *
     * @param type 类型 1：登录 2：登出
     * @return
     */
    public Integer addByType(Integer type) {
        LoginRecord log = new LoginRecord();
        log.setType(type);
        log.setIp(commonService.getIpAddr());
        log.setUid(userInfoService.getLoginUser().getId());
        return loginRecordMapper.insert(log);
    }

    /**
     * 添加登录日志
     *
     * @return
     */
    public Integer addLogin(UserInfo user) {
        LoginRecord log = new LoginRecord();
        log.setType(1);
        log.setIp(commonService.getIpAddr());
        log.setUid(user.getId());
        return loginRecordMapper.insert(log);
    }

    /**
     * 添加退出日志
     *
     * @return
     */
    public Integer addLogout() {
        return addByType(2);
    }

}
