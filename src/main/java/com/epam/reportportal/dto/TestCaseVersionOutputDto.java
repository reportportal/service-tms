package com.epam.reportportal.dto;

public record TestCaseVersionOutputDto(long id,
                                       String name,
                                       boolean isDefault,
                                       boolean isDraft,
                                       ManualScenarioOutputDto manualScenario) {
    
}
