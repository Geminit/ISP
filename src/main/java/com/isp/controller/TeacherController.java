package com.isp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.isp.entity.*;
import com.isp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TitleService titleService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SchoolLevelService schoolLevelService;
    @Autowired
    private SchoolService schoolService;

    //年级管理主页
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));     //获取页数
        }catch (Exception exception){}

        int start = (page-1) * 10;                                       //获取起始页数
        int end = page * 10;
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("start", start);
        argsMap.put("end", end);
        List<Teacher> list = teacherService.getTeacherByPage(argsMap);         //SQL查询;
        List<Title> list_title = titleService.getTitleAll();             //获取全部年级
        List<School> list_school = schoolService.getSchoolAll();         //学校
        List<SchoolLevel> list_school_level = schoolLevelService.getSchoolLevelAll();
        List<Subject> list_subject = subjectService.getSubjectAll();

        double number = teacherService.getTotalNumber();                   //总记录条数
        int pageNumber = (int) Math.ceil(number/10);                    //总页数

        model.addAttribute("currentpage", page);
        model.addAttribute("page", pageNumber);
        model.addAttribute("previous", page-1);
        model.addAttribute("last", page+1);
        model.addAttribute("total", (int) number);
        model.addAttribute("user", list);
        model.addAttribute("school", list_school);
        model.addAttribute("title", list_title);
        model.addAttribute("school_level", list_school_level);
        model.addAttribute("subject", list_subject);
        return "background_teacher";
    }

    //年级查询（账号）
    @RequestMapping("/searchByName")
    @ResponseBody
    public String searchByName(HttpServletRequest request){
        String name = request.getParameter("name");
        List<Teacher> list = teacherService.getTeacherByName(name);
        JSONArray resultJson = (JSONArray) JSONArray.toJSON(list);
        String resultString = resultJson.toString();
        System.out.println(resultString);
        return resultString;
    }

    //年级查询（ID）
    @RequestMapping("/searchById")
    @ResponseBody
    public String searchById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        List<Teacher> list = teacherService.getTeacherById(id);
        JSONArray resultJson = (JSONArray) JSONArray.toJSON(list);
        String resultString = resultJson.toString();
        System.out.println(resultString);
        return resultString;
    }

    //新建年级
    @RequestMapping("/insertTeacher")
    @ResponseBody
    public String insertUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("name", request.getParameter("name"));
        argsMap.put("school", request.getParameter("school"));
        argsMap.put("diploma", request.getParameter("diploma"));
        argsMap.put("subject", request.getParameter("subject"));
        argsMap.put("title", request.getParameter("title"));
        argsMap.put("isGood", request.getParameter("isGood"));

        String result;
        try {
            teacherService.insertTeacher(argsMap);
            result = "{'result': 'success'}";
        }catch (Exception exception){
            result = "{'result': 'error'}";
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String resultString = jsonObject.toJSONString();
        return resultString;
    }

    //通过ID删除年级
    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public String deleteById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String result;
        try {
            teacherService.deleteById(id);
            result = "{'result': 'success'}";
        }catch (Exception exception){
            System.out.println(exception);
            result = "{'result': 'error'}";
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String resultString = jsonObject.toJSONString();
        return resultString;
    }

    //更新层次信息
    @RequestMapping("/updateTeacher")
    @ResponseBody
    public String updateUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("id", request.getParameter("id"));
        argsMap.put("name", request.getParameter("name"));
        argsMap.put("school", request.getParameter("school"));
        argsMap.put("diploma", request.getParameter("diploma"));
        argsMap.put("subject", request.getParameter("subject"));
        argsMap.put("title", request.getParameter("title"));
        argsMap.put("isGood", request.getParameter("isGood"));
        String result;
        try {
            teacherService.updateTeacher(argsMap);
            result = "{'result': 'success'}";
        }catch (Exception exception){
            System.out.println(exception);
            result = "{'result': 'error'}";
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String resultString = jsonObject.toJSONString();
        return resultString;
    }
}
