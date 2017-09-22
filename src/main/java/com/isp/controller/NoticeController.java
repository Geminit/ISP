package com.isp.controller;

import com.isp.entity.Notice;
import com.isp.service.NoticeService;
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
public class NoticeController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private NoticeService noticeService;

    //映射一个action
    @RequestMapping("/notices")
    public  String schools(Model model, HttpServletRequest request) {
        //输出日志文件
        logger.info("Visit page Schools.");

        List<Map> noticesList= new ArrayList<Map>();
        Map map;

        int totle = noticeService.getNoticeNumber();

        List<Notice> notices = noticeService.getNoticeByPage(1);

        for(int i = 0; i<notices.size(); i++){
            map = new HashMap();
            map.put("noticeId",notices.get(i).getId());
            map.put("noticeTitle",notices.get(i).getTitle());
            noticesList.add(map);
        }

        model.addAttribute("noticesList", noticesList);
        model.addAttribute("totle", totle);
        model.addAttribute("page", 1);
        model.addAttribute("pages", (totle/10)+1);

        return "notices";
    }

    //映射一个action
    @RequestMapping("/toNotices")
    public  String toNotices(Model model, HttpServletRequest request) {
        //输出日志文件
        logger.info("Visit page Schools.");

        int page = Integer.parseInt(request.getParameter("page"));

        List<Map> noticesList= new ArrayList<Map>();
        Map map;

        int totle = noticeService.getNoticeNumber();

        List<Notice> notices = noticeService.getNoticeByPage(page);

        for(int i = 0; i<notices.size(); i++){
            map = new HashMap();
            map.put("noticeId",notices.get(i).getId());
            map.put("noticeTitle",notices.get(i).getTitle());
            noticesList.add(map);
        }

        model.addAttribute("noticesList", noticesList);
        model.addAttribute("totle", totle);
        model.addAttribute("page", page);
        model.addAttribute("pages", (totle/10)+1);

        return "notices";
    }

    //映射一个action
    @RequestMapping("/toNotice")
    public  String toNotice(Model model, HttpServletRequest request) {
        //输出日志文件
        logger.info("Visit page Schools.");

        int id = Integer.parseInt(request.getParameter("id"));

        Notice notice = noticeService.getNoticeById(id);

        model.addAttribute("notice", notice);

        return "notice";
    }

}
