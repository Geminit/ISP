package com.isp.service.impl;

import com.isp.dao.NoticeDao;
import com.isp.entity.Notice;
import com.isp.service.NoticeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/9/14.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    public List<Notice> getNoticeAll() {
        return noticeDao.getNoticeAll();
    }

    public List<Notice> getNoticeByPage(Map<String, Object> argsMap) {
        List<Notice> list = noticeDao.getNoticeByPage(argsMap);
        return list;
    }

    public List<Notice> getNoticeByName(String name) {
        List<Notice> list = noticeDao.getNoticeByName(name);
        return list;
    }

    public List<Notice> getNoticeById(Integer id) {
        List<Notice> list = noticeDao.getNoticeById(id);
        return list;
    }

    public Integer getTotalNumber() {
        return noticeDao.getTotalNumber();
    }

    public void insertNotice(Map<String, Object> argsMap) {
        noticeDao.insertNotice(argsMap);
    }

    public void updateNotice(Map<String, Object> argsMap) {
        noticeDao.updateNotice(argsMap);
    }

    public void deleteById(@Param("id") Integer id) {
        noticeDao.deleteById(id);
    }
}
