package com.epam.reportportal.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "test_case_attribute")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseAttribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    // TODO: Do we need this field for test case?
    @Column(name = "key")
    private String key;


    // TODO: Do we need this field for test case?
    @Column(name = "value")
    private String value;

    //TODO: override equals and hashCode methods
}
