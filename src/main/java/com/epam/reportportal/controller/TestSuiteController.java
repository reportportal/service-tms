package com.epam.reportportal.controller;

import com.epam.reportportal.dto.TestSuiteRQ;
import com.epam.reportportal.dto.TestSuiteRS;
import com.epam.reportportal.service.TestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project/{projectId}/tms/testsuite")
public class TestSuiteController {
    
    private final TestSuiteService testSuiteService;
    
    @Autowired
    public TestSuiteController(final TestSuiteService testSuiteService) {
        this.testSuiteService = testSuiteService;
    }
    
    @PostMapping
    TestSuiteRS createTestSuite(@PathVariable("projectId") final long projectId,
                                @RequestBody final TestSuiteRQ inputDto) {
        return testSuiteService.createTestSuite(inputDto);
    }
    
    @PutMapping("/{testSuiteId}")
    TestSuiteRS updateTestSuite(@PathVariable("projectId") final long projectId,
                                      @PathVariable("testSuiteId") final long testSuiteId,
                                      @RequestBody final TestSuiteRQ inputDto) {
        return testSuiteService.updateTestSuite(testSuiteId, inputDto);
    }
    
    @GetMapping("/{testSuiteId}")
    TestSuiteRS getTestSuiteById(@PathVariable("projectId") final long projectId,
                                       @PathVariable("testSuiteId") final long testSuiteId) {
        return testSuiteService.getTestSuiteById(testSuiteId);
    }
}
