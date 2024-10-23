package pl.cango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.cango.model.Student;
import pl.cango.persistence.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/student/save")
    public Student createStudent(@RequestBody Student student) {

        return repository.save(student);
    }

    @GetMapping("/student/findByEmailDomain")
    public List<Student> findStudentByDomain(@RequestParam("domain")String domain) {
        return repository.findByDomain(domain);
    }
    @GetMapping("/student/findBy")
    public Student findStudent(@RequestParam("email")String email) {
        return repository.findByEmail(email);
    }
    @GetMapping("/student/update")
    public Student updateStudent(@RequestParam("student_id") Long id, @RequestParam("new_email") String email) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            Student studentObj  = student.get();
            studentObj.setEmail(email);
            repository.save(studentObj);
        }
        return null;
    }
}
