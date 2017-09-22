package com.isp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.isp.service.UserService;
import org.slf4j.LoggerFactory;
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
 * @author Geminit
 * @create 2016-9-11
 */

@Controller
@RequestMapping("/user")
public class UserController {

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //用户管理主页
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
        List<Object> list = userService.getUserByPage(argsMap);         //SQL查询

        double number = userService.getTotalNumber();                   //总记录条数
        int pageNumber = (int) Math.ceil(number/10);                    //总页数

        model.addAttribute("currentpage", page);
        model.addAttribute("page", pageNumber);
        model.addAttribute("previous", page-1);
        model.addAttribute("last", page+1);
        model.addAttribute("total", (int) number);
        model.addAttribute("user", list);
        return "background_user";
    }

    //用户查询（账号）
    @RequestMapping("/searchByAccount")
    @ResponseBody
    public String searchByAccount(HttpServletRequest request){
        String account = request.getParameter("account");
        List<Object> list = userService.getUserByAccount(account);
        JSONArray resultJson = (JSONArray) JSONArray.toJSON(list);
        String resultString = resultJson.toString();
        System.out.println(resultString);
        return resultString;
    }

    //用户查询（id）
    @RequestMapping("/searchById")
    @ResponseBody
    public String searchById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        List<Object> list = userService.getUserById(id);
        JSONArray resultJson = (JSONArray) JSONArray.toJSON(list);
        String resultString = resultJson.toString();
        System.out.println(resultString);
        return resultString;
    }

    //新建用户
    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(HttpServletRequest request){
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String role = request.getParameter("role");
        String status = request.getParameter("status");
        String email = request.getParameter("email");

        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("account", account);
        argsMap.put("password", password);
        argsMap.put("username", username);
        argsMap.put("role", role);
        argsMap.put("status", status);
        argsMap.put("email", email);

        String result;
        try {
            userService.insertUser(argsMap);
            result = "{'result': 'success'}";
        }catch (Exception exception){
            result = "{'result': 'error'}";
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String resultString = jsonObject.toJSONString();
        return resultString;
    }

    //更新用户信息
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(HttpServletRequest request){
        Map<String, Object> argsMap = new HashMap<String, Object>();
        argsMap.put("id", request.getParameter("id"));
        argsMap.put("account", request.getParameter("account"));
        argsMap.put("username", request.getParameter("username"));
        argsMap.put("role", request.getParameter("role"));
        argsMap.put("status", request.getParameter("status"));
        argsMap.put("email", request.getParameter("email"));
        String result;
        try {
            userService.updateUser(argsMap);
            result = "{'result': 'success'}";
        }catch (Exception exception){
            System.out.println(exception);
            result = "{'result': 'error'}";
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String resultString = jsonObject.toJSONString();
        return resultString;
    }

    //通过ID删除用户
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String result;
        try {
            userService.deleteById(id);
            result = "{'result': 'success'}";
        }catch (Exception exception){
            result = "{'result': 'error'}";
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String resultString = jsonObject.toJSONString();
        return resultString;
    }
}
