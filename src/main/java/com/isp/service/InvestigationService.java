package com.isp.service;

import java.util.List;

/**
 * @author Geminit
 * @create 2016-9-12
 */

public interface InvestigationService {

    List<String> getAllFocus();

    void putUpInvestigation(String name, String phone, String email, String focus, String bestSchool, String bestReason,
                            String badestSchool, String badestReason, String advise);

}
