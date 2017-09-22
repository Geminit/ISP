package com.isp.controller;

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
 * @create 2016-9-15
 */

@Controller
@RequestMapping("/isp")
public class ServiceController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    SchoolsService schoolsService;

    //映射一个action
    @RequestMapping("/service")
    public  String service(Model model, HttpServletRequest request) {
        //输出日志文件
        logger.info("Visit page Schools.");

        List<School> schools = schoolsService.getSchoolPhone();

        School theLastSchool = new School();

        List<Map> schoolPhoneList = new ArrayList<Map>();
        Map map;

        for(int i = 0; schools.size() == 1 || i<schools.size()/2; i++){
            map = new HashMap();
            map.put("previousSchool",schools.get(i*2));
            map.put("subsequentSchool",schools.get(i*2+1));
            schoolPhoneList.add(map);
        }

        if(schools.size()%2 == 1){
            theLastSchool = schools.get(schools.size()-1);
        }else{
            theLastSchool = null;
        }

        model.addAttribute("schoolPhoneList", schoolPhoneList);
        model.addAttribute("theLastSchool", theLastSchool);

        return "service";
    }
}
