package com.learning.spring.jpa.relationships.repository;

import com.learning.spring.jpa.relationships.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Page<Course> findByNameContaining(
            String title,
            Pageable pageable);
}
