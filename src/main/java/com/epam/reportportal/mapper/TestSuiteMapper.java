package com.epam.reportportal.mapper;

import com.epam.reportportal.db.model.TestSuite;
import com.epam.reportportal.dto.TestSuiteOutputDto;
import org.springframework.stereotype.Service;

@Service
public class TestSuiteMapper {
    
    public TestSuiteOutputDto convertToOutputDto(final TestSuite testSuite) {
        return new TestSuiteOutputDto(testSuite.getId(), testSuite.getName(), testSuite.getDescription());
    }
}
