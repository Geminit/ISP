package com.isp.service.impl;

import com.isp.dao.ParentDao;
import com.isp.entity.NoticeGroupByConcer;
import com.isp.entity.Parent;
import com.isp.service.ParentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentDao parentDao;

    public List<Parent> getParentByPage(Map<String, Object> argsMap) {
        List<Parent> list = parentDao.getParentByPage(argsMap);
        return list;
    }

    public List<Parent> getParentByName(String parent_name) {
        List<Parent> list = parentDao.getParentByName(parent_name);
        return list;
    }

    public List<Parent> getParentById(Integer id) {
        List<Parent> list = parentDao.getParentById(id);
        return list;
    }

    public List<NoticeGroupByConcer> getParenteGroupByConcer() {
        List<NoticeGroupByConcer> list = parentDao.getParenteGroupByConcer();
        return list;
    }

    public Integer getTotalNumber() {
        return parentDao.getTotalNumber();
    }

    public void insertParent(Map<String, Object> argsMap) {
        parentDao.insertParent(argsMap);
    }

    public void updateParent(Map<String, Object> argsMap) {
        parentDao.updateParent(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        parentDao.deleteById(id);
    }
}
