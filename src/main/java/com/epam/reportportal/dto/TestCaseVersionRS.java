package com.epam.reportportal.dto;

public record TestCaseVersionRS(long id,
                                String name,
                                boolean isDefault,
                                boolean isDraft,
                                ManualScenarioRS manualScenario) {
    
}
