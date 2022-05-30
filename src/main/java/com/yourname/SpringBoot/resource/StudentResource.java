package com.yourname.SpringBoot.resource;

import com.yourname.SpringBoot.exception.StudentNotFoundException;
import com.yourname.SpringBoot.model.Student;
import com.yourname.SpringBoot.model.StudentDto;
import com.yourname.SpringBoot.model.StudentEntity;
import com.yourname.SpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("getAllStudents")
    //@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("getStudentById/{id}")
    //@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentById(@PathVariable("id") UUID studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping("insertNewStudent")
    public void insertNewStudent(@RequestBody Student student){
        studentService.persistnewstudent(UUID.randomUUID(),student);
    }

   @PutMapping("updateStudentById/{id}")
    public int updateStudent(@PathVariable("id") UUID studentId, @RequestBody Student student){
        return studentService.updateStudentById(studentId, student);
   }

    @DeleteMapping("deleteStudentById/{id}")
    public void deleteStudentById(@PathVariable("id") UUID studentId){
        studentService.deleteStudentById(studentId);
    }


    //Connection with In-memory Database
    @PostMapping("postStudent")
    public StudentEntity postStudent(@RequestBody StudentDto studentDto){
        return studentService.postStudent(studentDto);
    }

    @GetMapping("getAllStudentFromDb")
    public List<StudentEntity> getAllStudentsFromDb(){
        return studentService.getAllStudentsFromDb();
    }

    @GetMapping("getStudentByIdFromDb/{id}")
    public Optional<StudentEntity> getStudentsByIdFromDb(@PathVariable("id") Long studentId) throws StudentNotFoundException {
        return studentService.getStudentsByIdFromDb(studentId);
    }

    @DeleteMapping("deleteStudentFromId/{id}")
    public void deleteStudentFromDb(@PathVariable("id") Long studentId){
         studentService.deleteStudentFromDb(studentId);
    }

    //Delete Student Using Query String

   /* @DeleteMapping("deleteStudentById")
    public void deleteStudentById(@RequestParam("id") UUID studentId){
        studentService.deleteStudentById(studentId);
   }*/
}
