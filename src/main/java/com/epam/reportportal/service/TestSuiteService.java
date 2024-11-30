package com.epam.reportportal.service;

import com.epam.reportportal.dto.TestSuiteInputDto;
import com.epam.reportportal.dto.TestSuiteOutputDto;

public interface TestSuiteService {
    
    TestSuiteOutputDto createTestSuite(TestSuiteInputDto inputDto);
    TestSuiteOutputDto updateTestSuite(long testSuiteId, TestSuiteInputDto inputDto);
    TestSuiteOutputDto getTestSuiteById(long id);
}
