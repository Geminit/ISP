package com.isp.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhang on 2017/9/12.
 */
@Controller
@RequestMapping("/manage")
public class ManageController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    //后台主页
    @RequestMapping("/index")
    public  String index(Model model, HttpServletRequest request){
        return "background_public";
    }
}
