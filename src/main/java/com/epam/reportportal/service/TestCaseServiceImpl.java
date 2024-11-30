package com.epam.reportportal.service;

import com.epam.reportportal.db.model.TestCase;
import com.epam.reportportal.db.model.TestCaseVersion;
import com.epam.reportportal.db.repository.TestCaseRepository;
import com.epam.reportportal.db.repository.TestSuiteRepository;
import com.epam.reportportal.dto.TestCaseInputDto;
import com.epam.reportportal.dto.TestCaseOutputDto;
import com.epam.reportportal.exception.NotFoundException;
import com.epam.reportportal.mapper.TestCaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import static com.epam.reportportal.service.TestSuiteServiceImpl.TEST_SUITE_NOT_FOUND_BY_ID;

@Service
public class TestCaseServiceImpl implements TestCaseService {
    
    private static final String TEST_CASE_NOT_FOUND_BY_ID = "Test Case cannot be found by id: {0}";
    
    private final TestCaseMapper testCaseMapper;
    private final TestCaseRepository testCaseRepository;
    private final TestSuiteRepository testSuiteRepository;
    
    @Autowired
    public TestCaseServiceImpl(final TestCaseMapper testCaseMapper,
                               final TestCaseRepository testCaseRepository,
                               final TestSuiteRepository testSuiteRepository) {
        this.testCaseMapper = testCaseMapper;
        this.testCaseRepository = testCaseRepository;
        this.testSuiteRepository = testSuiteRepository;
    }
    
    @Override
    public TestCaseOutputDto createTestCase(final TestCaseInputDto inputDto) {
        final var testSuite = testSuiteRepository.findById(inputDto.testSuiteId())
                                                 .orElseThrow(NotFoundException.supplier(TEST_SUITE_NOT_FOUND_BY_ID, inputDto.testSuiteId())); // replace by getting default Test Suite
        final var testCase = new TestCase(null,
                                          inputDto.name(),
                                          inputDto.description(),
                                          new HashSet<>(),
                                          new HashSet<>(),
                                          testSuite);
        testCase.addTestCaseVersion(new TestCaseVersion(null, "Default", true, false, null));
        
        return testCaseMapper.convertToOutputDto(testCaseRepository.save(testCase));
    }
    
    @Override
    public TestCaseOutputDto updateTestCase(final long testCaseId, final TestCaseInputDto inputDto) {
        return null;
    }
    
    @Override
    public TestCaseOutputDto getTestCaseById(final long id) {
        return testCaseMapper.convertToOutputDto(testCaseRepository.findById(id)
                                                     .orElseThrow(NotFoundException.supplier(TEST_CASE_NOT_FOUND_BY_ID, id)));
    }
    
    
}
