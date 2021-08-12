/**
 * @author Xiaohan Chen
 */
package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends IllegalArgumentException{

    private final int id;

    public EmployeeNotFoundException(int id) {
        super("User with Id " + id +  " not found.");
        this.id = id;
    }
}






