package com.isp.controller;

import com.alibaba.fastjson.JSONArray;
import com.isp.service.DataService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Geminit
 * @create 2016-9-21
 */

@Controller
@RequestMapping("/isp")
public class DataController {

    @Autowired
    DataService dataService;

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    //映射一个action
    @RequestMapping("/data")
    public  String data(Model model, HttpServletRequest request) {
        //输出日志文件
        logger.info("Visit page Schools.");

        int totle = dataService.getTotleSchoolNumberByRegion("");

        List<String> levels = dataService.getAllLevel();
        List<String> regions = dataService.getAllRegion();

        List<Map> schoolNumbers = new ArrayList<Map>();
        List<Map> regionSchoolNumbers = new ArrayList<Map>();
        Map map;

        for(int i=0; i<levels.size(); i++){
            map = new HashMap();
            map.put("level", levels.get(i));
            map.put("number", dataService.getSchoolNumberByRegionAndLevel("",levels.get(i)));
            schoolNumbers.add(map);
        }

        for(int i=0; i<regions.size(); i++){
            map = new HashMap();
            map.put("region", regions.get(i));
            map.put("number", dataService.getTotleSchoolNumberByRegion(regions.get(i)));
            regionSchoolNumbers.add(map);
        }

        model.addAttribute("totle", totle);
        model.addAttribute("schoolNumbers", schoolNumbers);
        model.addAttribute("regionSchoolNumbers", regionSchoolNumbers);

        return "data";
    }

    //映射一个action
    @RequestMapping("/dataGet")
    @ResponseBody
    public JSONArray dataGet(Model model, HttpServletRequest request) {
        String region = request.getParameter("region");

        List<String> levels = dataService.getAllLevel();
        JSONArray schoolNumbers = new JSONArray();
        Map map;

        for(int i=0; i<levels.size(); i++){
            map = new HashMap();
            map.put("level", levels.get(i));
            map.put("number", dataService.getSchoolNumberByRegionAndLevel(region,levels.get(i)));
            schoolNumbers.add(map);
        }

        return schoolNumbers;
    }
}
