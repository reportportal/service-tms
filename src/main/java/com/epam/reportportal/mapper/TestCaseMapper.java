package com.epam.reportportal.mapper;

import com.epam.reportportal.db.model.TestCase;
import com.epam.reportportal.dto.TestCaseOutputDto;
import com.epam.reportportal.dto.TestCaseVersionOutputDto;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TestCaseMapper {
    
    public TestCaseOutputDto convertToOutputDto(final TestCase testCase) {
        return new TestCaseOutputDto(testCase.getId(),
                                     testCase.getName(),
                                     testCase.getDescription(),
                                     testCase.getVersions()
                                             .stream()
                                             .map(model -> new TestCaseVersionOutputDto(model.getId(),
                                                                                        model.getName(),
                                                                                        model.isDefault(),
                                                                                        model.isDraft(),
                                                                                        null))
                                             .collect(Collectors.toSet()));
    }
    
}
