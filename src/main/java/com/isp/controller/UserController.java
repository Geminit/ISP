package com.isp.controller;

import com.isp.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Geminit
 * @create 2016-9-11
 */

@Controller
@RequestMapping("/user")
public class UserController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //用户管理主页
    @RequestMapping("/index")
//    @ResponseBody
    public String index(Model model, HttpServletRequest request){

        int page = Integer.parseInt(request.getParameter("page"));     //获取页数
        int start = (page-1) * 10;                                       //获取起始页数
        int end = page * 10;
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("start", start);
        argsMap.put("end", end);
        List<Object> list = userService.getUserByPage(argsMap);         //SQL查询

        model.addAttribute("user", list);
        return "background_user";
    }


}
