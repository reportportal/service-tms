package com.epam.reportportal.dto;

import java.util.Set;

public record TestCaseRS(long id, String name, String description, Set<TestCaseVersionRS> testCaseVersions) {
    
}
