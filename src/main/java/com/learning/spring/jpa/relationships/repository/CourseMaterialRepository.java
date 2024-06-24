package com.learning.spring.jpa.relationships.repository;

import com.learning.spring.jpa.relationships.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Integer> {
}
