package com.epam.reportportal.dto;

import java.util.List;

public record TestCaseInputDto(String name, String description, Long testSuiteId, List<AttributeInputDto> attributes) {
    
}
