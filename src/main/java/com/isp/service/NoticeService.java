package com.isp.service;

import com.isp.entity.Notice;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-14
 */

public interface NoticeService {

    int getNoticeNumber();

    Notice getNoticeById(int id);

    List<Notice> getNoticeByPage(int page);

}
