package com.epam.reportportal.service;

import com.epam.reportportal.db.model.TestSuite;
import com.epam.reportportal.db.repository.TestSuiteRepository;
import com.epam.reportportal.dto.TestSuiteRQ;
import com.epam.reportportal.dto.TestSuiteRS;
import com.epam.reportportal.exception.NotFoundException;
import com.epam.reportportal.mapper.DtoMapper;
import com.epam.reportportal.mapper.TestSuiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSuiteServiceImpl implements TestSuiteService {
    
    public static final String TEST_SUITE_NOT_FOUND_BY_ID = "Test Suite cannot be found by id: {0}";
    
    private final DtoMapper<TestSuite, TestSuiteRS> testSuiteMapper;
    private final TestSuiteRepository testSuiteRepository;
    
    @Autowired
    public TestSuiteServiceImpl(final TestSuiteMapper testSuiteMapper, final TestSuiteRepository testSuiteRepository) {
        this.testSuiteMapper = testSuiteMapper;
        this.testSuiteRepository = testSuiteRepository;
    }
    
    @Override
    public TestSuiteRS createTestSuite(final TestSuiteRQ inputDto) {
        return testSuiteMapper.convert(testSuiteRepository.save(new TestSuite(null, inputDto.name(), inputDto.description())));
    }
    
    @Override
    public TestSuiteRS updateTestSuite(final long testSuiteId, final TestSuiteRQ inputDto) {
        final var testSuite = testSuiteRepository.findById(testSuiteId)
                                                 .orElseThrow(NotFoundException.supplier(TEST_SUITE_NOT_FOUND_BY_ID, testSuiteId));
        
        testSuite.setName(inputDto.name());
        testSuite.setDescription(inputDto.description());
        
        return testSuiteMapper.convert(testSuiteRepository.save(testSuite));
    }
    
    @Override
    public TestSuiteRS getTestSuiteById(final long id) {
        return testSuiteRepository.findById(id)
                                  .map(testSuiteMapper::convert)
                                  .orElseThrow(NotFoundException.supplier(TEST_SUITE_NOT_FOUND_BY_ID, id));
    }
}
