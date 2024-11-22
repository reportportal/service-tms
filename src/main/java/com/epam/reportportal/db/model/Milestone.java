package com.epam.reportportal.db.model;

import java.util.List;

public class Milestone {

    private Long id;
    private String name;
    private String type;
    private Version productVersion;
    private Long startDate;
    private Long endDate;
    private List<TestCase> testCases;
}
