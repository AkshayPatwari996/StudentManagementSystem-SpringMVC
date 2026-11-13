
package com.studentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleStudentNotFoundException(
            StudentNotFoundException exception,
            Model model) {

        model.addAttribute(
                "errorMessage",
                exception.getMessage()
        );

        return "error";
    }

    // Handle all other unexpected exceptions
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGlobalException(
            Exception exception,
            Model model) {

        // Log exception on server side
        System.err.println("Exception: " + exception.getClass().getName());
        System.err.println("Message: " + exception.getMessage());
        exception.printStackTrace();

        model.addAttribute(
                "errorMessage",
                "Something went wrong. Please try again later."
        );

        return "error";
    }
}
