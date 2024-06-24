package com.learning.spring.jpa.relationships.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    private String firstName;

    private String lastName;

    /* the below means that a teacher is teaching multiple courses
    whenever possible use ManyToOne instead of OneToMany
    ManyToOne would mean that each course will have to have a teacher assigned tp it.

    @OneToMany(
            cascade = CascadeType.ALL   // Cascade all operations (persist, merge, remove, etc.) to the Course entities
    )
    @JoinColumn(
            name = "teacher_id",    // The name of the foreign key column in the Course table
            referencedColumnName = "teacherId"  // The primary key column in the Teacher table to which the foreign key refers
    ) // Join column will be created where the "many" side of the relationship is present (in the Course table)
    private List<Course> courses;
     */
}
