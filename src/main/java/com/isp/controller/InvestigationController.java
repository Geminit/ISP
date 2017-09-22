package com.isp.controller;

import com.isp.dao.SchoolDao;
import com.isp.service.InvestigationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-21
 */

@Controller
@RequestMapping("/isp")
public class InvestigationController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    InvestigationService investigationService;

    @Autowired
    SchoolDao schoolDao;

    //映射一个action
    @RequestMapping("/investigation")
    public  String investigation(Model model, HttpServletRequest request) {
        //输出日志文件
        logger.info("Visit page Schools.");

        List<String> schools = schoolDao.getAllSchool();
        List<String> focus = investigationService.getAllFocus();

        model.addAttribute("schools", schools);
        model.addAttribute("focus", focus);

        return "investigation";
    }

    //映射一个action
    @RequestMapping("/investigate")
    public void investigate(Model model, HttpServletRequest request) {
        //输出日志文件
        logger.info("Visit page Schools.");

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String focus = request.getParameter("focus");
        String bestSchool = request.getParameter("bestSchool");
        String bestReason = request.getParameter("bestReason");
        String badestSchool = request.getParameter("badestSchool");
        String badestReason = request.getParameter("badestReason");
        String advice = request.getParameter("advise");

        investigationService.putUpInvestigation(name, phone, email, focus, bestSchool, bestReason, badestSchool, badestReason, advice);

    }

}
