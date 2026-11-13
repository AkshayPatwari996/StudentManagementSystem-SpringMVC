
package com.studentmanagement.service;

import com.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {

    // Register Student
    void saveStudent(Student student);

    // Retrieve All Students
    List<Student> getAllStudents();

    // Retrieve Student By ID
    Student getStudentById(Long id);

    // Update Student
    void updateStudent(Student student);

    // Delete Student
    void deleteStudent(Long id);
}
