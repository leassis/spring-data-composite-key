package com.example.demo.composite;

import com.example.demo.composite.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends CrudRepository<Course, UUID> {
}
