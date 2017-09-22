package com.isp.entity;

import java.sql.Timestamp;

/**
 * @author Geminit
 * @create 2016-9-14
 */

public class License {

    private Integer id;
    private Integer school_id;
    private String content;
    private Integer kind;
    private Timestamp date;

    private School schoole;
    private InfoType infoType;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
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

    public InfoType getInfoType() { return infoType; }

    public void setInfoType(InfoType infoType) { this.infoType = infoType; }
}
