package com.yourname.SpringBoot.data.object.access;

import com.yourname.SpringBoot.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("fakeDao")
@Slf4j
public class FakeStudentDaoImpl implements StudentDao{

    private final Map<UUID,Student> database;

    public FakeStudentDaoImpl() {
        database=new HashMap<>();
        UUID studentId=UUID.randomUUID();
        database.put(
                studentId,
                new Student(studentId, 30, "Vibha", "Thumar", "Computer Eng")
        );
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId,student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        database.put(studentId, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }

    @Override
    public void deleteStudent(UUID studentId) {
        database.remove(studentId);
    }
}
