package com.epam.reportportal.db.model;

import java.util.List;

public class TestCaseStep {
    private Long id;
    private String instructions;
    private String expectedResult;
    private List<TestCaseAttachment> attachments;
}
