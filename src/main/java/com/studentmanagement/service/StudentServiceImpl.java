
package com.studentmanagement.service;

import com.studentmanagement.entity.Student;
import com.studentmanagement.exception.StudentNotFoundException;
import com.studentmanagement.repository.StudentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Register Student
    @Override
    @Transactional
    public void saveStudent(Student student) {

        studentRepository.save(student);

        System.out.println("Student registered successfully!");
    }

    // Retrieve All Students
    @Override
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    // Retrieve Student By ID
    @Override
    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {

        Student student = studentRepository.findById(id);

        if (student == null) {
            throw new StudentNotFoundException(
                    "Student not found with ID: " + id
            );
        }

        return student;
    }

    // Update Student
    @Override
    @Transactional
    public void updateStudent(Student student) {

        if (student == null || student.getId() == null) {
            throw new IllegalArgumentException(
                    "Student and Student ID cannot be null!"
            );
        }

        // Check whether student exists
        Student existingStudent = getStudentById(student.getId());

        // Preserve original creation timestamp
        student.setCreatedAt(existingStudent.getCreatedAt());

        // Update student
        studentRepository.update(student);

        System.out.println("Student updated successfully!");
    }

    // Delete Student
    @Override
    @Transactional
    public void deleteStudent(Long id) {

        // Check whether student exists
        Student student = getStudentById(id);

        studentRepository.delete(student);

        System.out.println("Student deleted successfully!");
    }
}
