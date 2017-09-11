package com.isp.controller;

import com.isp.entity.User;
import com.isp.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Geminit
 * @create 2016-9-11
 */

@Controller
@RequestMapping("/ips")
public class UserController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //映射一个action
    @RequestMapping("/index")
    public  String index(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("the first jsp pages");

        model.addAttribute("name","geminit");

        //返回一个index.jsp这个视图
        return "index";
    }

    //映射一个action
    @RequestMapping("/index/demo")
    @ResponseBody
    public String demo(Model model, HttpServletRequest request){

        Long input = Long.parseLong(request.getParameter("input"));


        User user = userService.getUserById(input);

        //返回一个index.jsp这个视图
        return user.getUserName();
    }
}
