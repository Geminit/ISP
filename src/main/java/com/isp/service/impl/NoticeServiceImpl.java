package com.isp.service.impl;

import com.isp.dao.NoticeDao;
import com.isp.entity.Notice;
import com.isp.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-15
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    public int getNoticeNumber() { return noticeDao.getNoticeNumber(); };

    public Notice getNoticeById(int id) { return noticeDao.getNoticeById(id); };

    public List<Notice> getNoticeByPage(int page) {return noticeDao.getNoticeByPage(page); };

}
