package com.isp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.isp.entity.InfoType;
import com.isp.entity.SchoolInfoRecord;
import com.isp.entity.School;
import com.isp.service.InfoTypeService;
import com.isp.service.SchoolInfoRecordService;
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
@RequestMapping("/schoolInfoRecord")
public class SchoolInfoRecordController {

    @Autowired
    private SchoolInfoRecordService schoolInfoRecordService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private InfoTypeService infoTypeService;

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
        List<SchoolInfoRecord> list = schoolInfoRecordService.getSchoolInfoRecordByPage(argsMap);         //SQL查询
        List<School> list_school = schoolService.getSchoolAll();
        List<InfoType> list_info_type = infoTypeService.getAll();
        double number = schoolInfoRecordService.getTotalNumber();                   //总记录条数
        int pageNumber = (int) Math.ceil(number/10);                    //总页数

        model.addAttribute("currentpage", page);
        model.addAttribute("page", pageNumber);
        model.addAttribute("previous", page-1);
        model.addAttribute("last", page+1);
        model.addAttribute("total", (int) number);
        model.addAttribute("user", list);
        model.addAttribute("school", list_school);
        model.addAttribute("info_type", list_info_type);
        return "background_school_info_record";
    }

    //年级查询（账号）
    @RequestMapping("/searchByName")
    @ResponseBody
    public String searchByName(HttpServletRequest request){
        String name = request.getParameter("name");
        List<SchoolInfoRecord> list = schoolInfoRecordService.getSchoolInfoRecordByName(name);
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
        List<SchoolInfoRecord> list = schoolInfoRecordService.getSchoolInfoRecordById(id);
        JSONArray resultJson = (JSONArray) JSONArray.toJSON(list);
        String resultString = resultJson.toString();
        System.out.println(resultString);
        return resultString;
    }

    //新建年级
    @RequestMapping("/insertSchoolInfoRecord")
    @ResponseBody
    public String insertUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("school_id", request.getParameter("school_id"));
        argsMap.put("type", request.getParameter("type"));
        argsMap.put("info", request.getParameter("info"));
        argsMap.put("new_info", request.getParameter("new_info"));

        String result;
        try {
            schoolInfoRecordService.insertSchoolInfoRecord(argsMap);
            result = "{'result': 'success'}";
        }catch (Exception exception){
            result = "{'result': 'error'}";
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String resultString = jsonObject.toJSONString();
        return resultString;
    }

    //通过ID删除年级
    @RequestMapping("/deleteSchoolInfoRecord")
    @ResponseBody
    public String deleteById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String result;
        try {
            schoolInfoRecordService.deleteById(id);
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
    @RequestMapping("/updateSchoolInfoRecord")
    @ResponseBody
    public String updateUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("id", request.getParameter("id"));
        argsMap.put("school_id", request.getParameter("school_id"));
        argsMap.put("type", request.getParameter("type"));
        argsMap.put("info", request.getParameter("info"));
        argsMap.put("new_info", request.getParameter("new_info"));
        String result;
        try {
            schoolInfoRecordService.updateSchoolInfoRecord(argsMap);
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
