package com.epam.reportportal.service;

import com.epam.reportportal.db.model.TestCase;
import com.epam.reportportal.db.model.TestCaseVersion;
import com.epam.reportportal.db.repository.TestCaseRepository;
import com.epam.reportportal.db.repository.TestSuiteRepository;
import com.epam.reportportal.dto.TestCaseRQ;
import com.epam.reportportal.dto.TestCaseRS;
import com.epam.reportportal.exception.NotFoundException;
import com.epam.reportportal.mapper.DtoMapper;
import com.epam.reportportal.mapper.TestCaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import static com.epam.reportportal.service.TestSuiteServiceImpl.TEST_SUITE_NOT_FOUND_BY_ID;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    private static final String TEST_CASE_NOT_FOUND_BY_ID = "Test Case cannot be found by id: {0}";

    private final DtoMapper<TestCase, TestCaseRS> testCaseMapper;
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
    public TestCaseRS createTestCase(final TestCaseRQ inputDto) {
        final var testSuite = testSuiteRepository.findById(inputDto.testSuiteId())
                .orElseThrow(NotFoundException.supplier(TEST_SUITE_NOT_FOUND_BY_ID, inputDto.testSuiteId())); // replace by getting default Test Suite
        final var testCase = new TestCase(null,
                inputDto.name(),
                inputDto.description(),
                new HashSet<>(),
                new HashSet<>(),
                testSuite);
        testCase.addTestCaseVersion(new TestCaseVersion(null, "Default", true, false, null));

        return testCaseMapper.convert(testCaseRepository.save(testCase));
    }

    @Override
    public TestCaseRS updateTestCase(final long testCaseId, final TestCaseRQ inputDto) {
        return null;
    }

    @Override
    public TestCaseRS getTestCaseById(final long id) {
        return testCaseMapper.convert(testCaseRepository.findById(id)
                .orElseThrow(NotFoundException.supplier(TEST_CASE_NOT_FOUND_BY_ID, id)));
    }


}
