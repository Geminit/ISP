package com.isp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.isp.entity.Region;
import com.isp.entity.School;
import com.isp.entity.SchoolLevel;
import com.isp.service.RegionService;
import com.isp.service.SchoolLevelService;
import com.isp.service.SchoolService;
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
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private SchoolLevelService schoolLevelService;

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
        List<School> list = schoolService.getSchoolByPage(argsMap);         //SQL查询
        List<Region> list_region = regionService.getRegionAll();
        List<SchoolLevel> list_level = schoolLevelService.getSchoolLevelAll();

        double number = schoolService.getTotalNumber();                   //总记录条数
        int pageNumber = (int) Math.ceil(number/10);                    //总页数

        model.addAttribute("currentpage", page);
        model.addAttribute("page", pageNumber);
        model.addAttribute("previous", page-1);
        model.addAttribute("last", page+1);
        model.addAttribute("total", (int) number);
        model.addAttribute("user", list);
        model.addAttribute("region", list_region);
        model.addAttribute("level", list_level);
        return "background_school";
    }

    //年级查询（账号）
    @RequestMapping("/searchByName")
    @ResponseBody
    public String searchByName(HttpServletRequest request){
        String name = request.getParameter("name");
        List<School> list = schoolService.getSchoolByName(name);
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
        List<School> list = schoolService.getSchoolById(id);
        JSONArray resultJson = (JSONArray) JSONArray.toJSON(list);
        String resultString = resultJson.toString();
        System.out.println(resultString);
        return resultString;
    }

    //新建年级
    @RequestMapping("/insertSchool")
    @ResponseBody
    public String insertUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("name", request.getParameter("name"));
        argsMap.put("level", request.getParameter("level"));
        argsMap.put("info", request.getParameter("info"));
        argsMap.put("region_id", request.getParameter("region_id"));
        argsMap.put("address", request.getParameter("address"));
        argsMap.put("image", request.getParameter("image"));
        argsMap.put("isGood", request.getParameter("isGood"));

        String result;
        try {
            schoolService.insertSchool(argsMap);
            result = "{'result': 'success'}";
        }catch (Exception exception){
            result = "{'result': 'error'}";
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String resultString = jsonObject.toJSONString();
        return resultString;
    }

    //通过ID删除年级
    @RequestMapping("/deleteSchool")
    @ResponseBody
    public String deleteById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String result;
        try {
            schoolService.deleteById(id);
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
    @RequestMapping("/updateSchool")
    @ResponseBody
    public String updateUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("id", request.getParameter("id"));
        argsMap.put("name", request.getParameter("name"));
        argsMap.put("level", request.getParameter("level"));
        argsMap.put("info", request.getParameter("info"));
        argsMap.put("region_id", request.getParameter("region_id"));
        argsMap.put("address", request.getParameter("address"));
        argsMap.put("image", request.getParameter("image"));
        argsMap.put("isGood", request.getParameter("isGood"));
        String result;
        try {
            schoolService.updateSchool(argsMap);
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
