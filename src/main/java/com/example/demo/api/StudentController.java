package com.example.demo.api;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")       // enable cors globally
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student existing = repo.findById(id).orElseThrow();
        existing.setName(student.getName());
        existing.setCourse(student.getCourse());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted";
    }
}
