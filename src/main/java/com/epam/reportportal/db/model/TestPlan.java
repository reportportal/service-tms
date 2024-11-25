package com.epam.reportportal.db.model;

import java.util.List;

public class TestPlan {
    
    private Long id;
    private String name;
    private String description;
    private Environment environment;
    private Version version;
    private List<TestPlanAttribute> attributes;
    private List<TestCase> testCases;
    
}
