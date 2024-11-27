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
public class ManualScenarioAttributeId implements Serializable {
    
    @Column(name = "manual_scenario_id")
    private Long manualScenarioId;
    
    @Column(name = "attribute_id")
    private Long attributeId;
    
    //TODO: override equals and hashCode methods
}
