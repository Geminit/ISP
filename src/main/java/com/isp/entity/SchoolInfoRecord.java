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

    private School school3;
    private InfoType infoType;

    public School getSchool3() {
        return school3;
    }

    public void setSchool3(School school3) {
        this.school3 = school3;
    }

    public InfoType getInfoType() {
        return infoType;
    }

    public void setInfoType(InfoType infoType) {
        this.infoType = infoType;
    }

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
}
