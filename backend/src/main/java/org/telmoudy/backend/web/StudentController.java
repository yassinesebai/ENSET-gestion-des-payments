package org.telmoudy.backend.web;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telmoudy.backend.entities.Student;
import org.telmoudy.backend.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
@CrossOrigin("*")
public class StudentController {

    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/fullname")
    public List<Student> findStudentsByFullName(
            @RequestParam(defaultValue = "") String firstName,
            @RequestParam(defaultValue = "")String lastName) {

        List<Student> students = studentService.findStudentsByFullName(firstName, lastName);
        return students;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}



//    @GetMapping
//    public Page<Student> getAllStudents(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//        PageRequest pageable = PageRequest.of(page, size);
//        return studentService.getAllStudents(pageable);
//    }
//    @GetMapping("/fullname")
//    public Page<Student> findStudentsByFullName(
//            @RequestParam(defaultValue = "") String firstName,
//            @RequestParam(defaultValue = "")String lastName,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//        PageRequest pageable = PageRequest.of(page, size);
//
//        Page<Student> students = studentService.findStudentsByFullName(firstName, lastName, pageable);
//        return students;
//    }