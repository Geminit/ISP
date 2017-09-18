package com.isp.entity;

/**
 * Created by zhang on 2017/9/14.
 */
public class Teacher {
    private Integer id;
    private String name;
    private int age;
    private Integer school;
    private Integer diploma;
    private Integer subject;
    private String image;
    private Integer title;
    private Integer isGood;

    private School schoole;
    private Subject subjecte;
    private Title titlee;

    public Subject getSubjecte() {
        return subjecte;
    }

    public void setSubjecte(Subject subjecte) {
        this.subjecte = subjecte;
    }

    public Title getTitlee() {
        return titlee;
    }

    public void setTitlee(Title titlee) {
        this.titlee = titlee;
    }

    public School getSchoole() {
        return schoole;
    }

    public void setSchoole(School schoole) {
        this.schoole = schoole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    public Integer getDiploma() {
        return diploma;
    }

    public void setDiploma(Integer diploma) {
        this.diploma = diploma;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public Integer getIsGood() {
        return isGood;
    }

    public void setIsGood(Integer isGood) {
        this.isGood = isGood;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }
}
