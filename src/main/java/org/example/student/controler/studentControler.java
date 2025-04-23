package org.example.student.controler;

import org.example.student.model.Student;
import org.springframework.ui.Model;
import org.example.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class studentControler {

    private final StudentService studentService;

    public studentControler(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String home() {
        return "Accueil";
    }


    @RequestMapping("/etudiants")
    public String getAll(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "Etudiants";
    }


    @RequestMapping("/student/{studentId}")
    public String details(@PathVariable("studentId") UUID studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "Etudiant";
    }


    @GetMapping("/inscription")
    public String inscription(Model model) {
        model.addAttribute("student", new Student());
        return "RegisterUserForm";
    }


    @PostMapping("/inscription")
    public String addStudent(@ModelAttribute("Student") Student student) {
        studentService.postStudent(student);
        return "redirect:/etudiants";
    }


}
