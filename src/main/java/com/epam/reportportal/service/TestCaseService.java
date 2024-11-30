package com.epam.reportportal.service;

import com.epam.reportportal.dto.TestCaseInputDto;
import com.epam.reportportal.dto.TestCaseOutputDto;

public interface TestCaseService {
    
    TestCaseOutputDto createTestCase(TestCaseInputDto inputDto);
    TestCaseOutputDto updateTestCase(long testCaseId, TestCaseInputDto inputDto);
    TestCaseOutputDto getTestCaseById(long id);
}
