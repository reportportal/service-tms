package com.epam.reportportal.db.repository;

import com.epam.reportportal.db.model.ProductVersion;
import com.epam.reportportal.db.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVersionRepository extends JpaRepository<ProductVersion, Long> {
    
}
