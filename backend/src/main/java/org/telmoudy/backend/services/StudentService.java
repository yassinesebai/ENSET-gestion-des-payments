package org.telmoudy.backend.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telmoudy.backend.entities.Student;
import org.telmoudy.backend.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> findStudentsByFullName(String firstName, String lastName) {
        return studentRepository.findByFirstNameContainsIgnoreCase(firstName);
    }
    public Student getStudentById(String id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            updatedStudent.setId(id);
            return studentRepository.save(updatedStudent);
        } else {
            return null;
        }
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
