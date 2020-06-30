package com.cmsystem.wms.controller;

import com.cmsystem.wms.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
public class TestController {

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/test1")
    Result beanUtil() {
        return Result.success(request.getRequestURI());
    }

}
