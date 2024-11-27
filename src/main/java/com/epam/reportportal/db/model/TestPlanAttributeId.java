package com.epam.reportportal.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestPlanAttributeId implements Serializable {
    
    @Column(name = "test_plan_id")
    private Long testPlanId;
    
    @Column(name = "attribute_id")
    private Long attributeId;
    
}
