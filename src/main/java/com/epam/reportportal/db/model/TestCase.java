package com.epam.reportportal.db.model;

import java.util.List;
import java.util.Set;

public class TestCase {
    
    private Long id;
    private String name;
    private String description;
    private Set<Tag> tags;
    private List<TestCaseVersion> versions;
    private Long testPlanId;
    private DataSet dataSet;


}
