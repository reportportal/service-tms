package com.epam.reportportal.db.repository;

import com.epam.reportportal.db.model.TestSuite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestSuiteRepository extends JpaRepository<TestSuite, Long> {
    
}
