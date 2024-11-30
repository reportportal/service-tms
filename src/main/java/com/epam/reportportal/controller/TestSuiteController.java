package com.epam.reportportal.controller;

import com.epam.reportportal.dto.TestSuiteInputDto;
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
@RequestMapping("/v1/project/{projectId}/tms/testsuite")
public class TestSuiteController {
    
    private final TestSuiteService testSuiteService;
    
    @Autowired
    public TestSuiteController(final TestSuiteService testSuiteService) {
        this.testSuiteService = testSuiteService;
    }
    
    @PostMapping
    ResponseEntity<?> createTestSuite(@PathVariable("projectId") final long projectId,
                                      @RequestBody final TestSuiteInputDto inputDto) {
        return ResponseEntity.ok(testSuiteService.createTestSuite(inputDto));
    }
    
    @PutMapping("/{testSuiteId}")
    ResponseEntity<?> updateTestSuite(@PathVariable("projectId") final long projectId,
                                      @PathVariable("testSuiteId") final long testSuiteId,
                                      @RequestBody final TestSuiteInputDto inputDto) {
        return ResponseEntity.ok(testSuiteService.updateTestSuite(testSuiteId, inputDto));
    }
    
    @GetMapping("/{testCaseId}")
    ResponseEntity<?> getTestSuiteById(@PathVariable("projectId") final long projectId,
                                       @PathVariable("testSuiteId") final long testSuiteId) {
        return ResponseEntity.ok(testSuiteService.getTestSuiteById(testSuiteId));
    }
}
