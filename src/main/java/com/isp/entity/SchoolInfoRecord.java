package com.isp.entity;

import java.sql.Timestamp;

/**
 * Created by zhang on 2017/9/14.
 */
public class SchoolInfoRecord {
    private Integer id;
    private Integer school_id;
    private Integer type;
    private String info;
    private String new_info;
    private Timestamp date;

    private School schoole;
    private InfoType infoTypee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNew_info() {
        return new_info;
    }

    public void setNew_info(String new_info) {
        this.new_info = new_info;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public School getSchoole() {
        return schoole;
    }

    public void setSchoole(School schoole) {
        this.schoole = schoole;
    }

    public InfoType getInfoTypee() {
        return infoTypee;
    }

    public void setInfoTypee(InfoType infoTypee) {
        this.infoTypee = infoTypee;
    }
}
