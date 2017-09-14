package com.isp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.isp.entity.SchoolLevel;
import com.isp.service.SchoolLevelService;
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
@RequestMapping("/schoollevel")
public class SchoolLevelController {

    @Autowired
    private SchoolLevelService schoolLevelService;

    //学校层次管理主页
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
        List<SchoolLevel> list = schoolLevelService.getSchoolLevelByPage(argsMap);         //SQL查询

        double number = schoolLevelService.getTotalNumber();                   //总记录条数
        int pageNumber = (int) Math.ceil(number/10);                    //总页数

        model.addAttribute("currentpage", page);
        model.addAttribute("page", pageNumber);
        model.addAttribute("previous", page-1);
        model.addAttribute("last", page+1);
        model.addAttribute("total", (int) number);
        model.addAttribute("user", list);
        return "background_school_level";
    }

    //学校层次查询（账号）
    @RequestMapping("/searchByName")
    @ResponseBody
    public String searchByName(HttpServletRequest request){
        String name = request.getParameter("name");
        List<SchoolLevel> list = schoolLevelService.getSchoolLevelByName(name);
        JSONArray resultJson = (JSONArray) JSONArray.toJSON(list);
        String resultString = resultJson.toString();
        System.out.println(resultString);
        return resultString;
    }

    //学校层次查询（ID）
    @RequestMapping("/searchById")
    @ResponseBody
    public String searchById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        List<SchoolLevel> list = schoolLevelService.getSchoolLevelById(id);
        JSONArray resultJson = (JSONArray) JSONArray.toJSON(list);
        String resultString = resultJson.toString();
        System.out.println(resultString);
        return resultString;
    }

    //新建学校层级
    @RequestMapping("/insertSchoolLevel")
    @ResponseBody
    public String insertUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("name", request.getParameter("name"));

        String result;
        try {
            schoolLevelService.insertSchoolLevel(argsMap);
            result = "{'result': 'success'}";
        }catch (Exception exception){
            result = "{'result': 'error'}";
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String resultString = jsonObject.toJSONString();
        return resultString;
    }

    //通过ID删除学校层次
    @RequestMapping("/deleteSchoolLevel")
    @ResponseBody
    public String deleteById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String result;
        try {
            schoolLevelService.deleteById(id);
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
    @RequestMapping("/updateSchoolLevel")
    @ResponseBody
    public String updateUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("id", request.getParameter("id"));
        argsMap.put("name", request.getParameter("name"));
        String result;
        try {
            schoolLevelService.updateSchoolLevel(argsMap);
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
