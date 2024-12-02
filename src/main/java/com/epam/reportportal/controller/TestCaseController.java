package com.epam.reportportal.controller;

import com.epam.reportportal.dto.TestCaseInputDto;
import com.epam.reportportal.service.TestCaseService;
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
@RequestMapping("/v1/project/{projectId}/tms/testcase")
public class TestCaseController {
    
    private final TestCaseService testCaseService;
    
    @Autowired
    public TestCaseController(final TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }
    
    @GetMapping("/{testCaseId}")
    ResponseEntity<?> getTestCaseById(@PathVariable("projectId") final long projectId,
                                      @PathVariable("testCaseId") final long testCaseId) {
        return ResponseEntity.ok(testCaseService.getTestCaseById(testCaseId));
    }
    
    @PostMapping
    ResponseEntity<?> createTestCase(@PathVariable("projectId") final long projectId,
                                     @RequestBody final TestCaseInputDto inputDto) {
        return ResponseEntity.ok(testCaseService.createTestCase(inputDto));
    }
    
    @PutMapping("/{testCaseId}")
    ResponseEntity<?> updateTestCase(@PathVariable("projectId") final long projectId,
                                     @PathVariable("testCaseId") final long testCaseId,
                                     @RequestBody final TestCaseInputDto inputDto) {
        return ResponseEntity.ok(testCaseService.updateTestCase(testCaseId, inputDto));
    }
    
}
