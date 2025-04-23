package org.example.student.service;

import org.example.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentService {

    private final Map<UUID, Student> students;

    public StudentService() {
        students = new HashMap<>();

        Student student1 = Student.builder()
                .id(UUID.randomUUID())
                .firstName("Alice")
                .lastName("Dubois")
                .age(18)
                .email("alice.dubois@example.com")
                .build();

        Student student2 = Student.builder()
                .id(UUID.randomUUID())
                .firstName("Lucas")
                .lastName("Martin")
                .age(19)
                .email("lucas.martin@example.com")
                .build();

        Student student3 = Student.builder()
                .id(UUID.randomUUID())
                .firstName("Emma")
                .lastName("Bernard")
                .age(20)
                .email("emma.bernard@example.com")
                .build();

        Student student4 = Student.builder()
                .id(UUID.randomUUID())
                .firstName("Nathan")
                .lastName("Petit")
                .age(21)
                .email("nathan.petit@example.com")
                .build();

        Student student5 = Student.builder()
                .id(UUID.randomUUID())
                .firstName("Chloé")
                .lastName("Robert")
                .age(22)
                .email("chloe.robert@example.com")
                .build();

        students.put(student1.getId(), student1);
        students.put(student2.getId(), student2);
        students.put(student3.getId(), student3);
        students.put(student4.getId(), student4);
        students.put(student5.getId(), student5);

    }

    public List<Student> getAllStudents() {
        return students.values().stream().toList();
    }

    public Student getStudentById(UUID id) {
        return students.get(id);
    }

    public Student postStudent(Student student) {
        students.put(student.getId(), student);
        return student;

    }
}
