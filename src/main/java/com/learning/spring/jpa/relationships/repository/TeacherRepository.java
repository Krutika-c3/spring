package com.learning.spring.jpa.relationships.repository;

import com.learning.spring.jpa.relationships.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
