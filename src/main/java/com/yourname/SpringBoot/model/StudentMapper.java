package com.yourname.SpringBoot.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class StudentMapper {

    public StudentEntity toEntity(StudentDto studentDto){

        StudentEntity studentEntity=new StudentEntity();

        studentEntity.setId(studentDto.getId());
        studentEntity.setAge(studentDto.getAge());
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setCourse(studentDto.getCourse());

        return studentEntity;
    }

    public StudentDto toDto(StudentEntity studentEntity){

        StudentDto studentDto=new StudentDto(
                studentEntity.getId(),
                studentEntity.getAge(),
                studentEntity.getFirstName(),
                studentEntity.getLastName(),
                studentEntity.getCourse());
        return studentDto;

    }
}
