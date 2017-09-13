package com.isp.entity;

/**
 * Created by zhang on 2017/9/12.
 */
public class Role {
    private Long id;
    private String name;
    private Integer premission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPremission() {
        return premission;
    }

    public void setPremission(Integer premission) {
        this.premission = premission;
    }
}
