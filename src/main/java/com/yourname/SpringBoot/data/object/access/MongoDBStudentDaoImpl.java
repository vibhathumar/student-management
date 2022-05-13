package com.yourname.SpringBoot.data.object.access;

import com.yourname.SpringBoot.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("MongoBdDao")
public class MongoDBStudentDaoImpl implements StudentDao{
    @Override
    public int insertNewStudent(UUID studentId, Student student) {

        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return null;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> mongoDb=new ArrayList<>();
        mongoDb.add(new Student(UUID.randomUUID(),2,"Yaana","Thumar","Pre School"));
        return mongoDb;
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        return 0;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        return 0;
    }

    @Override
    public void deleteStudent(UUID studentId) {

    }
}
