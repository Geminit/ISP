package com.isp.controller;

import com.isp.entity.School;
import com.isp.entity.Teacher;
import com.isp.service.TeacherService;
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
 * @create 2016-9-18
 */

@Controller
@RequestMapping("/isp")
public class TeachersController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private TeacherService teacherService;

    //映射一个action
    @RequestMapping("/teachers")
    public  String teachers(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page Schools.");

        List<Map> teacherList = new ArrayList<Map>();
        List<Map> choosed = new ArrayList<Map>();
        Map map;

        int totle = teacherService.getTeacherNumber();

        String[] list = {"region", "level", "subject", "age", "diploma", "title"};
        String[] para = new String[6];

        for(int i = 0; i<list.length; i++){
            map = new HashMap();
            map.put("name",list[i]);
            map.put("value",request.getParameter(list[i]));
            if(request.getParameter(list[i]) == null)
                para[i] = "";
            else
                para[i] = request.getParameter(list[i]).toString();

            choosed.add(map);
        }

        int age = 0;
        if(para[3] != "")
            age = Integer.parseInt(para[3].split("'")[1]);

        List<Teacher> teachers = teacherService.getTeacherBySelection(para[0], para[1], para[2], age, para[4], para[5]);


        for(int i = 0; i<teachers.size(); i++){
            map = new HashMap();
            map.put("id",teachers.get(i).getId());
            map.put("name",teachers.get(i).getName());
            map.put("image",teachers.get(i).getImage());
            teacherList.add(map);
        }

        List<String> regions = teacherService.getRegions();
        List<String> levels = teacherService.getLevels();
        List<String> subjects = teacherService.getSubjects();
        List<String> ages = teacherService.getAges();
        List<String> diplomas = teacherService.getDiplomas();
        List<String> titles = teacherService.getTitles();

        model.addAttribute("teacherList", teacherList);
        model.addAttribute("choosed", choosed);
        model.addAttribute("totle", totle);
        model.addAttribute("regions", regions);
        model.addAttribute("levels", levels);
        model.addAttribute("subjects", subjects);
        model.addAttribute("ages", ages);
        model.addAttribute("diplomas", diplomas);
        model.addAttribute("titles", titles);

        //返回一个index.jsp这个视图
        return "teachers";
    }

    //映射一个action
    @RequestMapping("/toTeacher")
    public  String toTeacher(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page Schools.");

        int id = Integer.parseInt(request.getParameter("id"));

        Teacher teacher = teacherService.getTeacherById(id);

        model.addAttribute("teacher", teacher);

        //返回一个index.jsp这个视图
        return "teacher";
    }

}
