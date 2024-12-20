package com.epam.reportportal.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "tms_test_case_version", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class TestCaseVersion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "is_default")
    private boolean isDefault;
    
    @Column(name = "is_draft")
    private boolean isDraft;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;
    
    @OneToOne(mappedBy = "testCaseVersion", fetch = FetchType.LAZY)
    private ManualScenario manualScenario;
    
    public TestCaseVersion(final Long id,
                           final String name,
                           final boolean isDefault,
                           final boolean isDraft,
                           final ManualScenario manualScenario) {
        this.id = id;
        this.name = name;
        this.isDefault = isDefault;
        this.isDraft = isDraft;
        this.manualScenario = manualScenario;
    }
    
    //TODO: override equals and hashCode methods
    
}
