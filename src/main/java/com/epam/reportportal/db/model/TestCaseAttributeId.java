package com.epam.reportportal.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
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
public class TestCaseAttributeId implements Serializable {
    
    @Column(name = "test_case_id")
    private Long testCaseId;
    
    @Column(name = "attribute_id")
    private Long attributeId;
    
    //TODO: override equals and hashCode methods
}
