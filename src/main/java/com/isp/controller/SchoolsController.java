package com.isp.controller;

import com.isp.entity.License;
import com.isp.entity.School;
import com.isp.service.SchoolsService;
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
public class SchoolsController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private SchoolsService schoolsService;

    //映射一个action
    @RequestMapping("/schools")
    public  String schools(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page Schools.");

        List<Map> goodSchoolList = new ArrayList<Map>();
        Map map;

        int totle = schoolsService.getGoodSchoolNumber();

        List<School> schools = schoolsService.getGoodSchoolByPage(1);

        for(int i = 0; i<schools.size(); i++){
            map = new HashMap();
            map.put("schoolId",schools.get(i).getId());
            map.put("schoolName",schools.get(i).getName());
            goodSchoolList.add(map);
        }

        model.addAttribute("goodSchoolList", goodSchoolList);
        model.addAttribute("totle", totle);
        model.addAttribute("page", 1);
        model.addAttribute("pages", (totle/10)+1);

        //返回一个index.jsp这个视图
        return "schools";
    }

    //映射一个action
    @RequestMapping("/toSchools")
    public  String toSchools(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page Schools.");

        int page = Integer.parseInt(request.getParameter("page"));

        List<Map> goodSchoolList = new ArrayList<Map>();
        Map map;

        int totle = schoolsService.getGoodSchoolNumber();

        List<School> schools = schoolsService.getGoodSchoolByPage(page);

        for(int i = 0; i<schools.size(); i++){
            map = new HashMap();
            map.put("schoolId",schools.get(i).getId());
            map.put("schoolName",schools.get(i).getName());
            goodSchoolList.add(map);
        }

        model.addAttribute("goodSchoolList", goodSchoolList);
        model.addAttribute("totle", totle);
        model.addAttribute("page", page);
        model.addAttribute("pages", (totle/10)+1);

        //返回一个index.jsp这个视图
        return "schools";
    }

    //映射一个action
    @RequestMapping("/toSchool")
    public  String toSchool(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page school.");

        int schoolId = Integer.parseInt(request.getParameter("id"));

        School school = schoolsService.getSchoolById(schoolId);

        model.addAttribute("school",school);

        //返回一个index.jsp这个视图
        return "school";
    }

}
