package com.epam.reportportal.controller;

import com.epam.reportportal.dto.TestCaseRQ;
import com.epam.reportportal.dto.TestCaseRS;
import com.epam.reportportal.service.TestCaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project/{projectId}/tms/testcase")
@Tag(name = "Test Case", description = "Test Case API collection")
public class TestCaseController {

    private final TestCaseService testCaseService;

    @Autowired
    public TestCaseController(final TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping("/{testCaseId}")
    TestCaseRS getTestCaseById(@PathVariable("projectId") final long projectId,
                               @PathVariable("testCaseId") final long testCaseId) {
        return testCaseService.getTestCaseById(projectId,testCaseId);
    }
    @GetMapping("/")
    List<TestCaseRS> getTestCaseByProjectId(@PathVariable("projectId") final long projectId) {
        return testCaseService.getTestCaseByProjectId(projectId);
    }

    @PostMapping
    TestCaseRS createTestCase(@PathVariable("projectId") final long projectId,
                              @RequestBody @Valid final TestCaseRQ inputDto) {
        return testCaseService.createTestCase(inputDto);
    }

    @PutMapping("/{testCaseId}")
    TestCaseRS updateTestCase(@PathVariable("projectId") final long projectId,
                              @PathVariable("testCaseId") final long testCaseId,
                              @RequestBody final TestCaseRQ inputDto) {
        return testCaseService.updateTestCase(testCaseId, inputDto);
    }

}
