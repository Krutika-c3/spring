package com.learning.spring.jpa.relationships.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    @Id // used to mark a field as primary key - unique value
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Integer courseId;

    private String name;

    /*
     * Establishes a bi-directional one-to-one relationship with the CourseMaterial entity.
     * The "mappedBy" attribute indicates that the CourseMaterial entity owns the relationship.
     * This means the "course" field in the CourseMaterial entity is responsible for the relationship mapping.
     */
    @OneToOne(
            mappedBy = "course" // Specifies that the "course" attribute in the CourseMaterial entity is the owner of the relationship
    )
    private CourseMaterial courseMaterial;

    // ManyToOne meaning that many course can be taught by one teacher
    // Each course should have a teacher assigned to it
    @ManyToOne(
            cascade = CascadeType.ALL   // Cascade all operations (persist, merge, remove, etc.) to the Course entities
    )
    @JoinColumn(
            name = "teacher_id",    // The name of the foreign key column in the Course table
            referencedColumnName = "teacherId"  // The primary key column in the Teacher table to which the foreign key refers
    ) // Join column will be created where the "many" side of the relationship is present (in the Course table)
    private Teacher teacher;

    // ManyToMany meaning many students can enroll in many courses
    // for mapping many to many relationship we will have to create a mapping table
    @ManyToMany (
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    @ToString.Exclude
    private List<Student> students;

    public void addStudents(Student student) {
        if(students == null){
            students = new ArrayList<>();
        }
        students.add(student);
    }
}
