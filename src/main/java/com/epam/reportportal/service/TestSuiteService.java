package com.epam.reportportal.service;

import com.epam.reportportal.dto.TestSuiteRQ;
import com.epam.reportportal.dto.TestSuiteRS;

public interface TestSuiteService {
    
    TestSuiteRS createTestSuite(TestSuiteRQ inputDto);
    TestSuiteRS updateTestSuite(long testSuiteId, TestSuiteRQ inputDto);
    TestSuiteRS getTestSuiteById(long id);
}
