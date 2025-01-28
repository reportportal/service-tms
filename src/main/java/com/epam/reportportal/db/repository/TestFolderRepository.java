package com.epam.reportportal.db.repository;

import com.epam.reportportal.db.model.TestFolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Andrei_Varabyeu
 */
public interface TestFolderRepository extends JpaRepository<TestFolder, Long> {
    /**
     * Find all folder for given project
     *
     * @param projectID ID of project
     * @return found folders
     */
    List<TestFolder> findAllByProjectId(long projectID);

    /**
     * Finds a folder by given ID and project ID
     * @param id ID of folder
     * @param projectId ID of project
     * @return Test Folder
     */
    TestFolder findByIdAndProjectId(long id, long projectId);
}
