package com.epam.reportportal.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "test_suite", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class TestSuite implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;

    //TODO to become foreign key
    @Column(name = "project_id")
    private Long projectId;

    @OneToMany(mappedBy = "testSuite")
    private List<TestCase> testCases;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private TestSuite parent;
    
    @OneToMany(mappedBy = "parent")
    private List<TestSuite> subTestSuites;
    
    public TestSuite(final Long projectId, final Long id, final String name, final String description) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.description = description;
    }
}
