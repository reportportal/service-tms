package com.epam.reportportal.service;

import com.epam.reportportal.dto.TestCaseRQ;
import com.epam.reportportal.dto.TestCaseRS;

public interface TestCaseService {
    
    TestCaseRS createTestCase(TestCaseRQ inputDto);
    TestCaseRS updateTestCase(long testCaseId, TestCaseRQ inputDto);
    TestCaseRS getTestCaseById(long id);
}
