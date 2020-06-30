package com.cmsystem.wms.controller;

import com.cmsystem.wms.controller.base.BaseController;
import com.cmsystem.wms.entity.Result;
import com.cmsystem.wms.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/access_common")
public class AccessCommonController extends BaseController {

    @Autowired
    UserInfoMapper userInfoMapper;

    Result logout(){
        return null;
    }

}
