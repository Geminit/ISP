package com.isp.service.impl;

import com.isp.dao.InfoTypeDao;
import com.isp.entity.InfoType;
import com.isp.service.InfoTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class InfoTypeServiceImpl implements InfoTypeService {

    @Autowired
    private InfoTypeDao infoTypeDao;

    public List<InfoType> getAll() {
        return infoTypeDao.getAll();
    }

    public List<InfoType> getInfoTypeByPage(Map<String, Object> argsMap) {
        List<InfoType> list = infoTypeDao.getInfoTypeByPage(argsMap);
        return list;
    }

    public List<InfoType> getInfoTypeByName(String name) {
        List<InfoType> list = infoTypeDao.getInfoTypeByName(name);
        return list;
    }

    public List<InfoType> getInfoTypeById(Integer id) {
        List<InfoType> list = infoTypeDao.getInfoTypeById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return infoTypeDao.getTotalNumber();
    }

    public void insertInfoType(Map<String, Object> argsMap) {
        infoTypeDao.insertInfoType(argsMap);
    }

    public void updateInfoType(Map<String, Object> argsMap) {
        infoTypeDao.updateInfoType(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        infoTypeDao.deleteById(id);
    }
}
