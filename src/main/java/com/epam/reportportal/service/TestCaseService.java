package com.epam.reportportal.service;

import com.epam.reportportal.dto.TestCaseRQ;
import com.epam.reportportal.dto.TestCaseRS;

import java.util.List;

public interface TestCaseService {

    TestCaseRS createTestCase(TestCaseRQ inputDto);

    TestCaseRS updateTestCase(long testCaseId, TestCaseRQ inputDto);

    TestCaseRS getTestCaseById(long projectId, long id);

    List<TestCaseRS> getTestCaseByProjectId(long projectId);
}
