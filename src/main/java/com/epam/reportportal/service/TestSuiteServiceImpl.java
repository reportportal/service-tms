package com.epam.reportportal.service;

import com.epam.reportportal.db.model.TestSuite;
import com.epam.reportportal.db.repository.TestSuiteRepository;
import com.epam.reportportal.dto.TestSuiteInputDto;
import com.epam.reportportal.dto.TestSuiteOutputDto;
import com.epam.reportportal.exception.NotFoundException;
import com.epam.reportportal.mapper.TestSuiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSuiteServiceImpl implements TestSuiteService {
    
    public static final String TEST_SUITE_NOT_FOUND_BY_ID = "Test Suite cannot be found by id: {0}";
    
    private final TestSuiteMapper testSuiteMapper;
    private final TestSuiteRepository testSuiteRepository;
    
    @Autowired
    public TestSuiteServiceImpl(final TestSuiteMapper testSuiteMapper, final TestSuiteRepository testSuiteRepository) {
        this.testSuiteMapper = testSuiteMapper;
        this.testSuiteRepository = testSuiteRepository;
    }
    
    @Override
    public TestSuiteOutputDto createTestSuite(final TestSuiteInputDto inputDto) {
        return testSuiteMapper.convertToOutputDto(testSuiteRepository.save(new TestSuite(null, inputDto.name(), inputDto.description())));
    }
    
    @Override
    public TestSuiteOutputDto updateTestSuite(final long testSuiteId, final TestSuiteInputDto inputDto) {
        final var testSuite = testSuiteRepository.findById(testSuiteId)
                                                 .orElseThrow(NotFoundException.supplier(TEST_SUITE_NOT_FOUND_BY_ID, testSuiteId));
        
        testSuite.setName(inputDto.name());
        testSuite.setDescription(inputDto.description());
        
        return testSuiteMapper.convertToOutputDto(testSuiteRepository.save(testSuite));
    }
    
    @Override
    public TestSuiteOutputDto getTestSuiteById(final long id) {
        return testSuiteRepository.findById(id)
                                  .map(testSuiteMapper::convertToOutputDto)
                                  .orElseThrow(NotFoundException.supplier(TEST_SUITE_NOT_FOUND_BY_ID, id));
    }
}
