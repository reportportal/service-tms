package com.epam.reportportal.service;

import com.epam.reportportal.db.model.TestCase;
import com.epam.reportportal.db.model.TestCaseVersion;
import com.epam.reportportal.db.repository.TestCaseRepository;
import com.epam.reportportal.db.repository.TestFolderRepository;
import com.epam.reportportal.dto.TestCaseRQ;
import com.epam.reportportal.dto.TestCaseRS;
import com.epam.reportportal.exception.NotFoundException;
import com.epam.reportportal.mapper.DtoMapper;
import com.epam.reportportal.mapper.TestCaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.reportportal.service.TestFolderServiceImpl.TEST_FOLDER_NOT_FOUND_BY_ID;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    private static final String TEST_CASE_NOT_FOUND_BY_ID = "Test Case cannot be found by id: {0}";

    private final DtoMapper<TestCase, TestCaseRS> testCaseMapper;
    private final TestCaseRepository testCaseRepository;
    private final TestFolderRepository testFolderRepository;

    @Autowired
    public TestCaseServiceImpl(final TestCaseMapper testCaseMapper,
                               final TestCaseRepository testCaseRepository,
                               final TestFolderRepository testFolderRepository) {
        this.testCaseMapper = testCaseMapper;
        this.testCaseRepository = testCaseRepository;
        this.testFolderRepository = testFolderRepository;
    }

    @Override
    public TestCaseRS createTestCase(final TestCaseRQ inputDto) {
        final var testFolder = testFolderRepository.findById(inputDto.testFolderId())
                .orElseThrow(NotFoundException.supplier(TEST_FOLDER_NOT_FOUND_BY_ID, inputDto.testFolderId())); // replace by getting default Test Folder
        final var testCase = new TestCase(null,
                inputDto.name(),
                inputDto.description(),
                new HashSet<>(),
                new HashSet<>(),
                testFolder);
        testCase.addTestCaseVersion(new TestCaseVersion(null, "Default", true, false, null));

        return testCaseMapper.convert(testCaseRepository.save(testCase));
    }

    @Override
    public TestCaseRS updateTestCase(final long testCaseId, final TestCaseRQ inputDto) {
        final var testCase = testCaseRepository.findById(testCaseId)
                .orElseThrow(NotFoundException.supplier(TEST_FOLDER_NOT_FOUND_BY_ID, testCaseId)); // replace by getting default Test Folder
        return null;
    }

    @Override
    public TestCaseRS getTestCaseById(long projectId, long id) {
        return testCaseMapper.convert(testCaseRepository.findById(id)
                .orElseThrow(NotFoundException.supplier(TEST_CASE_NOT_FOUND_BY_ID, id)));
    }
    @Override
    public List<TestCaseRS> getTestCaseByProjectId(long projectId) {
        return testCaseRepository.findByTestFolder_ProjectId(projectId).stream().map(testCaseMapper::convert).toList();
    }

}
