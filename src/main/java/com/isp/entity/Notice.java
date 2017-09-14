package com.isp.entity;

import java.sql.Timestamp;

/**
 * Created by zhang on 2017/9/14.
 */
public class Notice {
    private Integer notice;
    private String title;
    private String content;
    private String publisher;
    private Timestamp date;
    private Integer school;
    private Integer classes;

    private School schoole;

    public Integer getNotice() {
        return notice;
    }

    public void setNotice(Integer notice) {
        this.notice = notice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    public Integer getClasses() {
        return classes;
    }

    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    public School getSchoole() {
        return schoole;
    }

    public void setSchoole(School schoole) {
        this.schoole = schoole;
    }
}
