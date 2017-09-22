package com.isp.entity;

/**
 * Created by zhang on 2017/9/14.
 */
public class Parent {
    private Integer id;
    private String parent_name;
    private String concern;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getConcern() {
        return concern;
    }

    public void setConcern(String concern) {
        this.concern = concern;
    }
}
