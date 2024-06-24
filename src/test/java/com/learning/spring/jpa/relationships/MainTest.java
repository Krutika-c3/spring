package com.learning.spring.jpa.relationships;

import com.learning.spring.jpa.relationships.entity.Course;
import com.learning.spring.jpa.relationships.entity.CourseMaterial;
import com.learning.spring.jpa.relationships.entity.Student;
import com.learning.spring.jpa.relationships.entity.Teacher;
import com.learning.spring.jpa.relationships.repository.CourseMaterialRepository;
import com.learning.spring.jpa.relationships.repository.CourseRepository;
import com.learning.spring.jpa.relationships.repository.StudentRepository;
import com.learning.spring.jpa.relationships.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class MainTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    // one to one relationship
    @Test
    public void testSave() {
        Course course = Course.builder()
                .courseId(4)
                .name("AEM")
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .courseMaterialId(2)
                .tenure("3 months")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    void fetchAllHouses() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }

    @Test
    @Transactional
    void printCourseMaterialDetails() {
        CourseMaterial courseMaterial = courseMaterialRepository.findById(1)
                                        .orElseThrow(
                                                () -> new RuntimeException("CourseMaterial not found")
                                        );
        // Access the Course entity
        if (courseMaterial.getCourse() != null) {
            System.out.println("Course details:");
            System.out.println("ID: " + courseMaterial.getCourse().getCourseId());
            System.out.println("Name: " + courseMaterial.getCourse().getName());
        } else {
            System.out.println("No course associated with this courseMaterial.");
        }
    }

    @Test
    void fetchAllPerson() {
        List<Course> people = courseRepository.findAll();
        System.out.println(people);
    }

    // one to many relationship
    /*@Test
    void saveTeacher() {
        Course cnCourse = Course.builder().courseId(2).name("CN").build();
        Course deCourse = Course.builder().courseId(3).name("DE").build();
        Teacher teacher = Teacher.builder().teacherId(1).firstName("Naman").lastName("Tanuja").courses(List.of(cnCourse, deCourse)).build();
        teacherRepository.save(teacher);
    }*/

    // many to one relationship
    @Test
    void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                            .teacherId(2)
                            .firstName("Sunita")
                            .lastName("Tyagi")
                            .build();
        Course course = Course.builder()
                            .courseId(5)
                            .name("DSA")
                            .teacher(teacher)
                            .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                                        .courseMaterialId(3)
                                        .course(course)
                                        .tenure("12 months")
                                        .build();
        courseMaterialRepository.save(courseMaterial); // course and teach will be automatically saved as we have cascade as ALL
    }

    // pagination
    @Test
    void fetchAllCoursesWithPagination(){
        Pageable pageable = Pageable.ofSize(2).withPage(1);
        Page<Course> courses = courseRepository.findAll(pageable);
        System.out.println("Total courses: "+ courses.getTotalElements());
        System.out.println("Total course pages: "+ courses.getTotalPages());
        System.out.println("Courses: "+ courses.getContent());
    }

    // sorting
    @Test
    void fetchAllCoursesSortedByName(){
        Sort sortByName = Sort.by(Sort.Order.asc("name"));
        List<Course> courses = courseRepository.findAll(sortByName);
        System.out.println(courses);
    }

    // pagination and sorting
    @Test
    void fetchAllCourseWithPaginationAndSorting(){
        Sort sortInDescByName = Sort.by(Sort.Order.desc("name"));
        Pageable pageable = PageRequest.of(1, 2, sortInDescByName);
        Page<Course> courses = courseRepository.findAll(pageable);
        System.out.println("Total courses: "+ courses.getTotalElements());
        System.out.println("Total course pages: "+ courses.getTotalPages());
        System.out.println("Courses sorted by "+ courses.getSort());
        System.out.println("Courses: "+ courses.getContent());
    }

    @Test
    void fetchAllCoursesByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByNameContaining(
                        "D",
                        firstPageTenRecords).getContent();

        System.out.println("Courses = " + courses);
    }

    // many to many relationship
    @Test
    void saveCourseWithCourseMaterialTeacherAndStudent(){
        Teacher teacher = Teacher.builder()
                            .teacherId(3)
                            .firstName("Rani")
                            .lastName("Kushwah")
                            .build();
        Student student = Student.builder()
                            .studentId(1)
                            .firstName("Zayn")
                            .lastName("Malik")
                            .contactNumber(1234567890)
                            .email("zayn@gmail.com")
                            .build();
        Course course = Course.builder()
                        .courseId(6)
                        .name("ML")
                        .teacher(teacher)
                        .build();
        course.addStudents(student);
        CourseMaterial courseMaterial = CourseMaterial.builder()
                                        .courseMaterialId(4)
                                        .course(course)
                                        .tenure("24 months")
                                        .build();
        courseMaterialRepository.save(courseMaterial); // course and teach will be automatically saved as we have cascade as ALL
    }

}