
package com.studentmanagement.repository;

import com.studentmanagement.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Save Student
    public void save(Student student) {
        entityManager.persist(student);
    }

    // Find All Students
    public List<Student> findAll() {
        return entityManager
                .createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
    }

    // Find Student By ID
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    // Update Student
    public void update(Student student) {
        entityManager.merge(student);
    }

    // Delete Student
    public void delete(Student student) {
        entityManager.remove(
                entityManager.contains(student)
                        ? student
                        : entityManager.merge(student)
        );
    }
}
