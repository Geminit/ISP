package com.isp.service.impl;

import com.isp.dao.TitleDao;
import com.isp.entity.Title;
import com.isp.service.TitleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleDao titleDao;

    public List<Title> getTitleAll() {
        return titleDao.getTitleAll();
    }

    public List<Title> getTitleByPage(Map<String, Object> argsMap) {
        List<Title> list = titleDao.getTitleByPage(argsMap);
        return list;
    }

    public List<Title> getTitleByName(String name) {
        List<Title> list = titleDao.getTitleByName(name);
        return list;
    }

    public List<Title> getTitleById(Integer id) {
        List<Title> list = titleDao.getTitleById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return titleDao.getTotalNumber();
    }

    public void insertTitle(Map<String, Object> argsMap) {
        titleDao.insertTitle(argsMap);
    }

    public void updateTitle(Map<String, Object> argsMap) {
        titleDao.updateTitle(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        titleDao.deleteById(id);
    }
}
