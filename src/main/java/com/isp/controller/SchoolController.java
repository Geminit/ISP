package com.isp.controller;

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
 * @create 2016-9-12
 */

@Controller
@RequestMapping("/isp")
public class SchoolController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    List<String> title = new ArrayList<String>();
    List<String> url = new ArrayList<String>();

    //映射一个action
    @RequestMapping("/schools")
    public  String index(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page Schools.");

        List<Map> list = new ArrayList<Map>();
        Map map;

        title.add("baidu");
        title.add("baidu");
        title.add("baidu");

        url.add("www.baidu.com");
        url.add("www.baidu.com");
        url.add("www.baidu.com");

        for(int i = 0; i<title.size(); i++){
            map = new HashMap();
            map.put("title",title.get(i));
            map.put("url",url.get(i));
            list.add(map);
        }

        model.addAttribute("list",list);

        //返回一个index.jsp这个视图
        return "schools";
    }
}
