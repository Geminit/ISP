package com.isp.service.impl;

import com.isp.dao.InfoDao;
import com.isp.dao.InvestigationDao;
import com.isp.service.InvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-12
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class InvestigationServiceImpl implements InvestigationService{

    @Autowired
    InvestigationDao investigationDao;

    public List<String> getAllFocus(){ return investigationDao.getAllFocus(); }

    public void putUpInvestigation(String name, String phone, String email, String focus, String bestSchool, String bestReason,
                            String badestSchool, String badestReason, String advise){
        investigationDao.putUpInvestigation(name, phone, email, focus, bestSchool, bestReason, badestSchool, badestReason, advise);
    }

}
