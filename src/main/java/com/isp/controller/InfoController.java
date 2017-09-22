package com.isp.controller;

import com.isp.entity.School;
import com.isp.service.InfoService;
import com.isp.service.LicenseService;
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
@RequestMapping("/isp/info")
public class InfoController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private InfoService infoService;

    //映射一个action
    @RequestMapping("/establish")
    public  String establish(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page info_establish.");

        List<Map> establishList = new ArrayList<Map>();
        Map map;

        List<School> schools = infoService.getNewSchool();

        for(int i = 0; i<schools.size(); i++){
            map = new HashMap();
            map.put("date",schools.get(i).getLicense().getDate());
            map.put("schoolId",schools.get(i).getId());
            map.put("schoolName",schools.get(i).getName());
            map.put("licenseId",schools.get(i).getLicense().getId());
            establishList.add(map);
        }

        model.addAttribute("establishList",establishList);

        //返回一个index.jsp这个视图
        return "info/establish";
    }

    //映射一个action
    @RequestMapping("/modify")
    public  String modify(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page info_modify.");

        List<Map> modifyList = new ArrayList<Map>();
        Map map;

        List<School> schools = infoService.getModifiedSchool();

        for(int i = 0; i<schools.size(); i++){
            map = new HashMap();
            map.put("date",schools.get(i).getLicense().getDate());
            map.put("schoolId",schools.get(i).getId());
            map.put("schoolName",schools.get(i).getName());
            map.put("licenseId",schools.get(i).getLicense().getId());
            modifyList.add(map);
        }

        model.addAttribute("modifyList",modifyList);

        //返回一个index.jsp这个视图
        return "info/modify";
    }

    //映射一个action
    @RequestMapping("/end")
    public  String end(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page info_end.");

        List<Map> endingList = new ArrayList<Map>();
        Map map;

        List<School> schools = infoService.getEndingSchool();

        for(int i = 0; i<schools.size(); i++){
            map = new HashMap();
            map.put("date",schools.get(i).getLicense().getDate());
            map.put("schoolName",schools.get(i).getName());
            map.put("licenseId",schools.get(i).getLicense().getId());
            endingList.add(map);
        }

        model.addAttribute("endingList",endingList);

        //返回一个index.jsp这个视图
        return "info/end";
    }

}
