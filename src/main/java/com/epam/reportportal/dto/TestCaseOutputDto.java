package com.epam.reportportal.dto;

import java.util.Set;

public record TestCaseOutputDto(long id, String name, String description, Set<TestCaseVersionOutputDto> testCaseVersions) {
    
}
