package com.epam.reportportal.mapper;

import com.epam.reportportal.db.model.TestCase;
import com.epam.reportportal.dto.TestCaseRS;
import com.epam.reportportal.dto.TestCaseVersionRS;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TestCaseMapper implements DtoMapper<TestCase, TestCaseRS> {

    public TestCaseRS convert(final TestCase testCase) {
        return new TestCaseRS(testCase.getId(),
                testCase.getName(),
                testCase.getDescription(),
                testCase.getVersions()
                        .stream()
                        .map(model -> new TestCaseVersionRS(model.getId(),
                                model.getName(),
                                model.isDefault(),
                                model.isDraft(),
                                null))
                        .collect(Collectors.toSet()));
    }

}
