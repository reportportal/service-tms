package com.epam.reportportal.dto;

import java.util.List;

public record TestCaseRQ(String name, String description, Long testFolderId, List<AttributeRQ> attributes) {
    
}
