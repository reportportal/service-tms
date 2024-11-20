package com.epam.reportportal.db.model;

public class Milestone {

    private String name;
    private String type;
    private String productVersion; //TODO reference to Version
    private Long startDate;
    private Long endDate;

    //TODO reference to Test Cases ? Suite ?

}
