package com.isp.controller;

import com.isp.dao.*;
import com.isp.entity.NoticeGroupByConcer;
import com.isp.entity.PrimaryStudentBySchool;
import com.isp.entity.School;
import com.isp.entity.TeacherGroupByMonth;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by zhang on 2017/9/12.
 */
@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private SchoolDao schoolDao;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private ParentDao parentDao;
    @Autowired
    private NoticeDao noticeDao;

    //添加一个日志器
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    //后台主页
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        DecimalFormat df = new DecimalFormat(".##");
        int teacherTotalNumber = teacherDao.getTotalNumber();           //教师总人数
        int reallyTeacherNumber = teacherDao.getReallyTeacherNumber();  //出去后勤的教师人数
        int schoolNumber = schoolDao.getTotalNumber();                  //学校总数
        int primartTeacherNumber = teacherDao.getPrimaryTeacherNumber();//小学教师数
        int graduateTotal = classDao.getGraduateTotalNumber();          //毕业人数
        int graduateNumber = classDao.getGraduateNumber();              //升学人数
        int classNumber = classDao.getTotalNumber();                    //班级总数
        double averageNumber = classDao.averageNumber();                //平均班级人数
        double teacherRate = (double) reallyTeacherNumber/teacherTotalNumber*100;    //教师率
        double graduateRate = (double) graduateNumber/graduateTotal*100;             //毕业率
        String teacherRateString = df.format(teacherRate);
        String graduateRateString = df.format(graduateRate);
        String averageNumberString = df.format(averageNumber);

        List<TeacherGroupByMonth> teacherGroupByMonthList = teacherDao.getTeacherGroupByMonth();
        List<School> schoolNameList = schoolDao.getSchoolName();
        List<PrimaryStudentBySchool> primaryStudentBySchoolList = schoolDao.primaryStudentBySchool();

        //教师变化数据构造
        String teachMonth = "[";
        for(int month=1; month<=12; month++){
            for(int index=0; index<teacherGroupByMonthList.size(); index++){
                if(month == teacherGroupByMonthList.get(index).getMonth()){
                    teachMonth += teacherGroupByMonthList.get(index).getNumber() + ",";
                    break;
                }
                if (index == teacherGroupByMonthList.size()-1){
                    teachMonth += 0 + ",";
                }
            }
        }
        teachMonth = teachMonth.substring(0, teachMonth.length()-1);
        teachMonth += "]";

        //学校名称数据构造
        String schoolName = "[";
        for(int index=0; index<schoolNameList.size(); index++){
            schoolName += '"' + schoolNameList.get(index).getName() + '"' + ",";
        }
        schoolName = schoolName.substring(0, schoolName.length()-1);
        schoolName += "]";

        //小学人数占比数据构造
        String primaryStudent = "[";
        for (int outindex=0; outindex<schoolNameList.size(); outindex++){
            for(int innerindex=0; innerindex<primaryStudentBySchoolList.size(); innerindex++){
                if(schoolNameList.get(outindex).getName().equals(primaryStudentBySchoolList.get(innerindex).getName())){
                    primaryStudent += "{value:"+primaryStudentBySchoolList.get(innerindex).getNumber()+
                            ", name:'"+schoolNameList.get(outindex).getName()+"'},";
                    break;
                }
                if(innerindex == primaryStudentBySchoolList.size()-1){
                    schoolNameList.remove(outindex);
                }
            }
        }
        primaryStudent = primaryStudent.substring(0, primaryStudent.length()-1);
        primaryStudent += "]";

        model.addAttribute("teacherTotalNumber", teacherTotalNumber);
        model.addAttribute("reallyTeacherNumber", reallyTeacherNumber);
        model.addAttribute("schoolNumber", schoolNumber);
        model.addAttribute("primartTeacherNumber", primartTeacherNumber);
        model.addAttribute("graduateTotal", graduateTotal);
        model.addAttribute("graduateNumber", graduateNumber);
        model.addAttribute("classNumber", classNumber);
        model.addAttribute("teacherRateString", teacherRateString);
        model.addAttribute("graduateRateString", graduateRateString);
        model.addAttribute("averageNumberString", averageNumberString);
        model.addAttribute("teachMonth", teachMonth);
        model.addAttribute("schoolName", schoolName);
        model.addAttribute("primaryStudent", primaryStudent);
        return "background_index";
    }

    //校外数据
    @RequestMapping("/dataview")
    public String dataview(Model model, HttpServletRequest request){
        int school = schoolDao.getTotalNumber();
        int studentNumber = classDao.getGraduateTotalNumber();
        int classNumber = classDao.getTotalNumber();
        int parent = parentDao.getTotalNumber();

        List<NoticeGroupByConcer> noticeGroupByConcerList = parentDao.getParenteGroupByConcer();
        String titledata = "[";
        String data = "[";
        for(int index=0; index<noticeGroupByConcerList.size(); index++){
            titledata += '"' + noticeGroupByConcerList.get(index).getConcern() + '"' + ",";
            data += "{value:"+noticeGroupByConcerList.get(index).getNumber()+", " +
                    "name:'"+noticeGroupByConcerList.get(index).getConcern()+"'},";
        }
        titledata = titledata.substring(0, titledata.length()-1);
        data = data.substring(0, data.length()-1);
        titledata += "]";
        data += "]";

        List<NoticeGroupByConcer> list2016 = noticeDao.getNoticeGroupByMonth(2016);
        List<NoticeGroupByConcer> list2017 = noticeDao.getNoticeGroupByMonth(2017);

        String string2016 = "[";
        String string2017 = "[";
        for(int month=1; month<=12; month++){
            for(int index=0; index<list2016.size(); index++){
                if(month == list2016.get(index).getMonth()){
                    string2016 += list2016.get(index).getNumber() + ",";
                    break;
                }
                if (index == list2016.size()-1){
                    string2016 += 0 + ",";
                }
            }
            for(int index=0; index<list2017.size(); index++){
                if(month == list2017.get(index).getMonth()){
                    string2017 += list2017.get(index).getNumber() + ",";
                    break;
                }
                if (index == list2017.size()-1){
                    string2017 += 0 + ",";
                }
            }
        }
        string2016 = string2016.substring(0, string2016.length()-1);
        string2017 = string2017.substring(0, string2017.length()-1);
        string2016 += "]";
        string2017 += "]";

        model.addAttribute("school",school);
        model.addAttribute("studentNumber",studentNumber);
        model.addAttribute("classNumber",classNumber);
        model.addAttribute("parent",parent);
        model.addAttribute("titledata", titledata);
        model.addAttribute("data", data);
        model.addAttribute("string2016", string2016);
        model.addAttribute("string2017", string2017);
    return "background_dataview";
    }
}
