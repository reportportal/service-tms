package com.epam.reportportal.db.repository;

import com.epam.reportportal.db.model.TestSuite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestSuiteRepository extends JpaRepository<TestSuite, Long> {
    List<TestSuite> findAllByProjectId(long projectID);
}
