package org.example.service;

import org.example.dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    // Create a new student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Retrieve all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Retrieve a student by id
    public Optional<Student> getStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    // Update a student
    public boolean updateStudent(int id, Student newStudent) {
        return getStudentById(id).map(existingStudent -> {
            students.remove(existingStudent);
            students.add(newStudent);
            return true;
        }).orElse(false);
    }

    // Delete a student by id
    public boolean deleteStudent(int id) {
        return students
                .removeIf(student -> student.getId() == id);
    }
}
