package com.yourname.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class StudentDto {
    private Long id;
    private Integer age;
    private String firstName;
    private String lastName;
    private String course;


    public StudentDto(
            @JsonProperty("id")
            Long id,
            @JsonProperty("age")
            Integer age,
            @JsonProperty("firstName")
            String firstName,
            @JsonProperty("lastName")
            String lastName,
            @JsonProperty("course")
            String course
    ) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }


}
