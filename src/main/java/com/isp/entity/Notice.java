package com.isp.entity;

import java.sql.Timestamp;

/**
 * Created by zhang on 2017/9/15.
 */
public class Notice {
    private Integer id;
    private String title;
    private String content;
    private String publisher;
    private Timestamp date;
    private Integer isClassInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIsClassInfo() {
        return isClassInfo;
    }

    public void setIsClassInfo(Integer isClassInfo) {
        this.isClassInfo = isClassInfo;
    }
}
