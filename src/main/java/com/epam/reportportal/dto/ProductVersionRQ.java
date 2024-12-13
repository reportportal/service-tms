package com.epam.reportportal.dto;

import com.epam.reportportal.db.model.Milestone;
import com.epam.reportportal.db.model.TestPlan;

import java.util.Set;

// TODO add DTOs for TestPlan and Milestones

/**
 * Input DTO for milestone
 *
 * @param id
 * @param version
 * @param documentation
 * @param testPlans
 * @param milestones
 *
 * @author Andrei Varabyeu andrei_varabyeu@epam.com
 */
public record ProductVersionRQ(Long id, String version, String documentation, Set<Long> testPlans,
                               Set<Long> milestones) {

}
