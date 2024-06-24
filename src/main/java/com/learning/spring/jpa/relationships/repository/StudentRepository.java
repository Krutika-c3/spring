package com.learning.spring.jpa.relationships.repository;

import com.learning.spring.jpa.relationships.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
