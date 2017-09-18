package com.isp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.isp.entity.Class;
import com.isp.entity.Grade;
import com.isp.entity.School;
import com.isp.entity.Teacher;
import com.isp.service.ClassService;
import com.isp.service.GradeService;
import com.isp.service.SchoolService;
import com.isp.service.TeacherService;
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
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private TeacherService teacherService;

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
        List<Class> list = classService.getClassByPage(argsMap);         //SQL查询;
        List<Grade> list_grage = gradeService.getGradeAll();             //获取全部年级
        List<Teacher> list_teacher = teacherService.getTeacherAll();     //获取全部教师
        List<School> list_school = schoolService.getSchoolAll();         //学校

        double number = classService.getTotalNumber();                   //总记录条数
        int pageNumber = (int) Math.ceil(number/10);                    //总页数

        model.addAttribute("currentpage", page);
        model.addAttribute("page", pageNumber);
        model.addAttribute("previous", page-1);
        model.addAttribute("last", page+1);
        model.addAttribute("total", (int) number);
        model.addAttribute("user", list);
        model.addAttribute("grage", list_grage);
        model.addAttribute("teacher", list_teacher);
        model.addAttribute("school", list_school);
        return "background_class";
    }

    //年级查询（账号）
    @RequestMapping("/searchByName")
    @ResponseBody
    public String searchByName(HttpServletRequest request){
        String name = request.getParameter("name");
        List<Class> list = classService.getClassByName(name);
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
        List<Class> list = classService.getClassById(id);
        JSONArray resultJson = (JSONArray) JSONArray.toJSON(list);
        String resultString = resultJson.toString();
        System.out.println(resultString);
        return resultString;
    }

    //新建年级
    @RequestMapping("/insertClass")
    @ResponseBody
    public String insertUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("school", request.getParameter("school"));
        argsMap.put("grade", request.getParameter("grade"));
        argsMap.put("classnumber", request.getParameter("classnumber"));
        argsMap.put("number", request.getParameter("number"));
        argsMap.put("hometeacher", request.getParameter("hometeacher"));
        argsMap.put("graduate_number", request.getParameter("graduate_number"));
        argsMap.put("graduate_year", request.getParameter("graduate_year"));

        String result;
        try {
            classService.insertClass(argsMap);
            result = "{'result': 'success'}";
        }catch (Exception exception){
            result = "{'result': 'error'}";
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String resultString = jsonObject.toJSONString();
        return resultString;
    }

    //通过ID删除年级
    @RequestMapping("/deleteClass")
    @ResponseBody
    public String deleteById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String result;
        try {
            classService.deleteById(id);
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
    @RequestMapping("/updateClass")
    @ResponseBody
    public String updateUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("id", request.getParameter("id"));
        argsMap.put("school", request.getParameter("school"));
        argsMap.put("grade", request.getParameter("grade"));
        argsMap.put("classnumber", request.getParameter("classnumber"));
        argsMap.put("number", request.getParameter("number"));
        argsMap.put("hometeacher", request.getParameter("hometeacher"));
        argsMap.put("graduate_number", request.getParameter("graduate_number"));
        argsMap.put("graduate_year", request.getParameter("graduate_year"));
        String result;
        try {
            classService.updateClass(argsMap);
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
