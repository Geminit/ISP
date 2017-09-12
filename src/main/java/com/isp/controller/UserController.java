package com.isp.controller;

import com.alibaba.fastjson.JSONArray;
import com.isp.service.UserService;
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
 * @create 2016-9-11
 */

@Controller
@RequestMapping("/isp")
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

        List<Map> mapList = new ArrayList<Map>();
        Map map ;

        List<String> title = new ArrayList<String>();
        List<String> content = new ArrayList<String>();

        title.add("全国统一考试大纲正式发布");
        title.add("教育部直属事业单位公开招聘平台开放");
        title.add("2017年教育大事记");

        content.add("会议回顾总结了党的十七大以来高校党建工作取得的成绩和经验，深刻分析了高校党建工作面临的新形势新挑战，系统阐述了党的十七届六中全会对高校提出的新要求");
        content.add("教育部直属事业单位公开招聘平台”已于日前开放，教育部考试中心2016年招聘信息已发布在平台上。欢迎符合条件的考生到平台报名，后续相关信息请到平台查阅。");
        content.add("考试大纲是高考命题的规范性文件和标准，是考试评价、复习备考的依据。2017年普通高等学校招生全国统一考试大纲已经教育部有关部门组织修订、审定，现予以公布。");

        for(int i = 0; i<3; i++) {
            map = new HashMap();
            map.put("id",i);
            map.put("title",title.get(i));
            map.put("content",content.get(i));
            int lenth = title.get(i).length();
            map.put("lenth",lenth);
            mapList.add(map);
        }

        model.addAttribute("list",mapList);

        //返回一个index.jsp这个视图
        return "index";
    }

//    //映射一个action
//    @RequestMapping("/index/demo")
//    @ResponseBody
//    public String demo(Model model, HttpServletRequest request){
//
//        Long input = Long.parseLong(request.getParameter("input"));
//
//
//        User user = userService.getUserById(input);
//
//        //返回一个index.jsp这个视图
//        return user.getUserName();
//    }
}
