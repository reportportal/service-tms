package com.epam.reportportal.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "test_plan_attribute")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestPlanAttribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "test_plan_id")
    private TestPlan testPlan;

    // TODO: Do we actually need to mark this field unique=true and nullable=false ?
    @Column(name = "key", nullable = false, unique = true)
    private String key;
    
    @Column(name = "value")
    private String value;
}
