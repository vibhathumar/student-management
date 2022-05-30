package com.yourname.SpringBoot.exception.handler;

import com.yourname.SpringBoot.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionRepresentation> StudentNotFound(StudentNotFoundException ex){

        ExceptionRepresentation exceptionRepresentation=new ExceptionRepresentation();
        exceptionRepresentation.setMessage(ex.getMessage());
        exceptionRepresentation.setCode(String.valueOf(404));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionRepresentation);
    }

}
