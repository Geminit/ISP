package com.isp.controller;

import com.isp.entity.License;
import com.isp.service.LicenseService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Geminit
 * @create 2016-9-15
 */

@Controller
@RequestMapping("/isp")
public class LicenseController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    LicenseService licenseService;


    //映射一个action
    @RequestMapping("/toLicense")
    public  String toLicense(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page license.");

        int licenseId = Integer.parseInt(request.getParameter("id"));

        License license = licenseService.getLiceseById(licenseId);

        model.addAttribute("license",license);

        //返回一个index.jsp这个视图
        return "license";
    }

}
