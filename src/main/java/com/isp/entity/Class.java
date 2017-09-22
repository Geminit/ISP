23:01:46 对方已成功接收文件“Teacher.java”
张沛  00:58:31
Teacher Entity里面age不能用int，要用Integer，不然反向映射要出错
是我的海  00:59:16
好
是我的海  00:59:46
还有那个。teacher表里的diploma怎么接到了school_level呢
张沛  01:00:30
反正都是学校的等级，所以我就没有新建表了
张沛  01:01:00
School_level里面也是高中，本科，专科，之类的数据
是我的海  01:01:21
好咯
是我的海  17:07:00
这个
是我的海  17:07:03
大数据的网页
是我的海  17:07:07
emmmmm
张沛  17:07:24
咋了？
是我的海  17:08:10
很懵逼
张沛  17:08:35
等下，就是echart那几个页面么
是我的海  17:08:40
啊
张沛  20:13:36
[图片]
张沛  20:13:49
你待会儿打完游戏了，我们把代码合起来吧
是我的海  20:15:23
行吧
张沛  20:15:30
[表情]
是我的海  21:55:11
怎么搞呢
张沛  22:28:17
package com.isp.entity;

/**
 * Created by zhang on 2017/9/14.
 */
public class Class {
    private Integer id;
    private Integer school;
    private Integer grade;
    private Integer classnumber;
    private Integer number;
    private Integer hometeacher;
    private Integer graduate_number;
    private Integer graduate_year;

    private Grade gradee;
    private School schoole;
    private Teacher teachere;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(Integer classnumber) {
        this.classnumber = classnumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getHometeacher() {
        return hometeacher;
    }

    public void setHometeacher(Integer hometeacher) {
        this.hometeacher = hometeacher;
    }

    public Integer getGraduate_number() {
        return graduate_number;
    }

    public void setGraduate_number(Integer graduate_number) {
        this.graduate_number = graduate_number;
    }

    public Integer getGraduate_year() {
        return graduate_year;
    }

    public void setGraduate_year(Integer graduate_year) {
        this.graduate_year = graduate_year;
    }

    public Grade getGradee() {
        return gradee;
    }

    public void setGradee(Grade gradee) {
        this.gradee = gradee;
    }

    public School getSchoole() {
        return schoole;
    }

    public void setSchoole(School schoole) {
        this.schoole = schoole;
    }

    public Teacher getTeachere() {
        return teachere;
    }

    public void setTeachere(Teacher teachere) {
        this.teachere = teachere;
    }
}
