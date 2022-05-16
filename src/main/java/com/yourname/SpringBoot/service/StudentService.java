package com.yourname.SpringBoot.service;

import com.yourname.SpringBoot.data.object.access.StudentDao;
import com.yourname.SpringBoot.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class StudentService {

    private final StudentDao studentDao;
    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistnewstudent(UUID studentId, Student student){
        UUID studentUid=studentId==null?UUID.randomUUID():studentId;
        student.setId(studentId);
        log.info("adding new student with id -: {}",studentId);
        return studentDao.insertNewStudent(studentUid,student);
    }

    public Student getStudentById(UUID studentId){
        return studentDao.selectStudentById(studentId);

    }

    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }

    public int updateStudentById(UUID studentId, Student student){
        return studentDao.updateStudentById(studentId,student);
    }

    public int deleteStudentById(UUID studentId){
        return studentDao.deleteStudentById(studentId);
    }

    /*public Student updateStudent(UUID studentId, Student student) {

        studentDao.deleteStudent(studentId);
        studentDao.insertNewStudent(studentId,student);
        return studentDao.selectStudentById(studentId);

    }*/
}
