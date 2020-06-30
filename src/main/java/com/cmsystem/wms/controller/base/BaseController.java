package com.cmsystem.wms.controller.base;

import com.cmsystem.wms.service.PageService;
import com.cmsystem.wms.service.UserInfoService;
import com.cmsystem.wms.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseController {

    @Autowired
    public UserInfoService userInfoService;

    @Autowired
    public PageService pageService;

    @Autowired
    public ValidateService validateService;

}
