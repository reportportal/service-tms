package com.epam.reportportal.service;

import com.epam.reportportal.dto.TestSuiteRQ;
import com.epam.reportportal.dto.TestSuiteRS;

import java.util.List;

public interface TestSuiteService {
    
    TestSuiteRS createTestSuite(final long projectId,final TestSuiteRQ inputDto);
    TestSuiteRS updateTestSuite(long projectId,long testSuiteId, TestSuiteRQ inputDto);
    TestSuiteRS getTestSuiteById(long id);
    List<TestSuiteRS> getTestSuiteByProjectID(long projectId);
}
