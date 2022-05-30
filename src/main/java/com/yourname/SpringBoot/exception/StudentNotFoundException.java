package com.yourname.SpringBoot.exception;

public class StudentNotFoundException extends Throwable {
    public StudentNotFoundException(String student) {
        super(student);
    }
}
