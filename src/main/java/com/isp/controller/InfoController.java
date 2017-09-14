package com.isp.controller;

import com.isp.entity.License;
import com.isp.entity.School;
import com.isp.service.InfoService;
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
            map.put("date",schools.get(i).getLicense().getLicenseDate());
            map.put("schoolId",schools.get(i).getSchoolId());
            map.put("schoolName",schools.get(i).getSchoolName());
            map.put("licenseId",schools.get(i).getLicense().getLicenseId());
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
            map.put("date",schools.get(i).getLicense().getLicenseDate());
            map.put("schoolId",schools.get(i).getSchoolId());
            map.put("schoolName",schools.get(i).getSchoolName());
            map.put("licenseId",schools.get(i).getLicense().getLicenseId());
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
            map.put("date",schools.get(i).getLicense().getLicenseDate());
            map.put("schoolName",schools.get(i).getSchoolName());
            map.put("licenseId",schools.get(i).getLicense().getLicenseId());
            endingList.add(map);
        }

        model.addAttribute("endingList",endingList);

        //返回一个index.jsp这个视图
        return "info/end";
    }

    //映射一个action
    @RequestMapping("/toSchool")
    public  String toSchool(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page school.");

        int schoolId = Integer.parseInt(request.getParameter("id"));

        School school = infoService.getSchoolById(schoolId);

        //返回一个index.jsp这个视图
        return "info/school";
    }

    //映射一个action
    @RequestMapping("/toLicense")
    public  String toLicense(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page license.");

        int licenseId = Integer.parseInt(request.getParameter("id"));

        License license = infoService.getLicenseById(licenseId);

        //返回一个index.jsp这个视图
        return "info/license";
    }

    //映射一个action
    @RequestMapping("/guide")
    public  String guide(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page info_guide.");

        List<Map> guideList = new ArrayList<Map>();
        Map map;

//        List<School> guides = infoService.getEndingSchool();
//
//        for(int i = 0; i<guides.size(); i++){
//            map = new HashMap();
//            map.put("id",guides.get(i).getLicense().getLicenseDate());
//            map.put("title",guides.get(i).getLicense().getLicenseDate());
//            guideList.add(map);
//        }

        model.addAttribute("guideList",guideList);

        //返回一个index.jsp这个视图
        return "info/guide";
    }

    //映射一个action
    @RequestMapping("/toGuide")
    public  String toGuide(Model model, HttpServletRequest request){
        //输出日志文件
        logger.info("Visit page guidePage.");

        int guideId = Integer.parseInt(request.getParameter("id"));

        //License license = infoService.getLicenseById(licenseId);

        //返回一个index.jsp这个视图
        return "info/guidePage";
    }

}
