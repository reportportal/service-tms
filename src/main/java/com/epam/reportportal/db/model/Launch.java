package com.epam.reportportal.db.model;

import java.util.List;

public class Launch {

    private Long id;
    private String name;
    private String description;
    private Milestone milestone;
    private TestPlan testPlan;
    private List<Attribute> attributes;

}
