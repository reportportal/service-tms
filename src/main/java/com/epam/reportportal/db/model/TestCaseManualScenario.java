package com.epam.reportportal.db.model;

import java.util.List;

public class TestCaseManualScenario {
    private Long id;
    private Integer executionEstimationTime;
    private String linkToRequirements;
    private String preconditions;
    private List<Attribute> attributes;
    private List<TestCaseStep> steps;
}
