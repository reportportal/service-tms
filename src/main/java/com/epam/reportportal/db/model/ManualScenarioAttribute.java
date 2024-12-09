package com.epam.reportportal.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "manual_scenario_attribute")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManualScenarioAttribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manual_scenario_id")
    private ManualScenario manualScenario;

    // TODO: Do we need this field for test case?
    @Column(name = "key")
    private String key;
    
    @Column(name = "value")
    private String value;
    
    //TODO: override equals and hashCode methods
}
