package com.epam.reportportal.mapper;

import com.epam.reportportal.db.model.TestFolder;
import com.epam.reportportal.dto.TestFolderRS;
import org.springframework.stereotype.Service;

@Service
public class TestFolderMapper implements DtoMapper<TestFolder, TestFolderRS> {

    public TestFolderRS convert(final TestFolder testFolder) {
        return new TestFolderRS(testFolder.getId(), testFolder.getName(), testFolder.getDescription());
    }
}
