package com.epam.reportportal.service;

import com.epam.reportportal.db.model.TestFolder;
import com.epam.reportportal.db.repository.TestFolderRepository;
import com.epam.reportportal.dto.TestFolderRQ;
import com.epam.reportportal.dto.TestFolderRS;
import com.epam.reportportal.exception.NotFoundException;
import com.epam.reportportal.mapper.DtoMapper;
import com.epam.reportportal.mapper.TestFolderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestFolderServiceImpl implements TestFolderService {
    
    public static final String TEST_FOLDER_NOT_FOUND_BY_ID = "Test Folder cannot be found by id: {0}";
    public static final String TEST_CASE_NOT_FOUND_BY_ID = "Test Case cannot be found by id: {0}";

    private final DtoMapper<TestFolder, TestFolderRS> testFolderMapper;
    private final TestFolderRepository testFolderRepository;
    
    @Autowired
    public TestFolderServiceImpl(final TestFolderMapper testFolderMapper, final TestFolderRepository testFolderRepository) {
        this.testFolderMapper = testFolderMapper;
        this.testFolderRepository = testFolderRepository;
    }
    
    @Override
    public TestFolderRS createFolder(final long projectId, final TestFolderRQ inputDto) {
        return testFolderMapper.convert(testFolderRepository.save(new TestFolder(null,projectId, inputDto.name(), inputDto.description())));
    }
    
    @Override
    public TestFolderRS updateFolder(final long projectId, final long folderId, final TestFolderRQ inputDto) {
        // TODO validate project value

        final var testFolder = testFolderRepository.findById(folderId)
                                                 .orElseThrow(NotFoundException.supplier(TEST_FOLDER_NOT_FOUND_BY_ID, folderId));
        
        testFolder.setProjectId(projectId);
        testFolder.setName(inputDto.name());
        testFolder.setDescription(inputDto.description());
        
        return testFolderMapper.convert(testFolderRepository.save(testFolder));
    }
    
    @Override
    public TestFolderRS getFolderById(final long id) {
        return testFolderRepository.findById(id)
                                  .map(testFolderMapper::convert)
                                  .orElseThrow(NotFoundException.supplier(TEST_FOLDER_NOT_FOUND_BY_ID, id));
    }
    @Override
    public List<TestFolderRS> getFolderByProjectID(final long projectId) {
        return testFolderRepository.findAllByProjectId(projectId)
                .stream().map(testFolderMapper::convert)
                .toList();
    }
}
