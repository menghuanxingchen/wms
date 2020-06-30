package com.cmsystem.wms.service.base;

import com.cmsystem.wms.service.ApproveLogService;
import com.cmsystem.wms.service.CommonService;
import com.cmsystem.wms.service.PageService;
import com.cmsystem.wms.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Autowired
    protected PageService pageService;

    @Autowired
    protected UserInfoService userInfoService;

    @Autowired
    protected ApproveLogService approveLogService;

    @Autowired
    protected CommonService commonService;
}
