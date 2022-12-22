package com.example.demo.composite.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Embeddable
@Data
public class ContractId {
    @OneToOne
    @JoinColumn(name = "student_Id")
    private Student student;
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
