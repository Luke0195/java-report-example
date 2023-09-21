package br.com.jasperreportexample.userslist.controllers;

import br.com.jasperreportexample.userslist.services.implementation.UserImplementation;

import br.com.jasperreportexample.userslist.vo.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserImplementation  userImplementation;

    public  UserController(UserImplementation implementation){
        this.userImplementation = implementation;
    }


    @GetMapping("/reports")
    public ResponseEntity<String> getUsersReports(){
        String result = userImplementation.getUserReport();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
