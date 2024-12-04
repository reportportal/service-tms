package com.epam.reportportal.mapper;

import com.epam.reportportal.db.model.TestSuite;
import com.epam.reportportal.dto.TestSuiteRS;
import org.springframework.stereotype.Service;

@Service
public class TestSuiteMapper implements DtoMapper<TestSuite, TestSuiteRS> {

    public TestSuiteRS convert(final TestSuite testSuite) {
        return new TestSuiteRS(testSuite.getId(), testSuite.getName(), testSuite.getDescription());
    }
}
