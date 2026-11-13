
package com.studentmanagement.controller;

import com.studentmanagement.entity.Student;
import com.studentmanagement.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    // Constructor Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 0. Display Home Page
    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    // 1. Display Registration Form
    @GetMapping("/add")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // 2. Save Student
    @PostMapping("/save")
    public String saveStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "student-form";
        }

        studentService.saveStudent(student);

        return "redirect:/student/list";
    }

    // 3. Display All Students
    @GetMapping("/list")
    public String getAllStudents(Model model) {

        List<Student> students = studentService.getAllStudents();

        model.addAttribute("students", students);

        return "student-list";
    }

    // 4. View Individual Student
    @GetMapping("/view/{id}")
    public String viewStudent(
            @PathVariable("id") Long id,
            Model model) {

        Student student = studentService.getStudentById(id);

        model.addAttribute("student", student);

        return "student-details";
    }

    // 5. Display Edit Form
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable("id") Long id,
            Model model) {

        Student student = studentService.getStudentById(id);

        model.addAttribute("student", student);

        return "student-form";
    }

    // 6. Update Student
    @PostMapping("/update")
    public String updateStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "student-form";
        }

        studentService.updateStudent(student);

        return "redirect:/student/list";
    }

    // 7. Delete Student
    @PostMapping("/delete/{id}")
    public String deleteStudent(
            @PathVariable("id") Long id) {

        studentService.deleteStudent(id);

        return "redirect:/student/list";
    }
}
