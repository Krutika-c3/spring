package com.learning.spring.jpa.relationships.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseMaterialId;

    private String tenure;

    /*
     * Establishes a one-to-one relationship with the Course entity.
     * The cascade type ALL means that all operations (persist, merge, remove, etc.)
     * will be cascaded to the Course entity.
     */
    @OneToOne(
            cascade = CascadeType.ALL,  // Cascade all operations to the Course entity
            fetch = FetchType.LAZY,   // Lazy loading to delay loading the Course entity until it's accessed
            optional = false // This means that Course is not optional(required) when saving a CourseMaterial
            // A CourseMaterial cannot exist without being linked to a Course.
    )
    @JoinColumn(
            name = "course_id", // The name of the foreign key column in the CourseMaterial table
            referencedColumnName = "courseId"   // The primary key column in the Course table to which the foreign key refers
    )
    @ToString.Exclude
    // Foreign key "course_id" will be added to the courseMaterial table, indicating that the courseMaterial belongs to a course
    private Course course;
}
