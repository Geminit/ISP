package com.isp.entity;

/**
 * Created by zhang on 2017/9/14.
 */
public class Class {
    private Integer id;
    private Integer school;
    private Integer grade;
    private Integer number;
    private Integer hometeacher;
    private Integer graduate_number;
    private Integer graduate_year;

    private Grade gradee;
    private School schoole;

    public School getSchoole() {
        return schoole;
    }

    public void setSchoole(School schoole) {
        this.schoole = schoole;
    }

    public Grade getGradee() {
        return gradee;
    }

    public void setGradee(Grade gradee) {
        this.gradee = gradee;
    }

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
}
