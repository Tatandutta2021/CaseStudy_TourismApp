package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.DataNotFoundException;
import com.cg.model.Tourism_User;
import com.cg.service.UserService;

@RestController

@RequestMapping("/api/v1")
public class UserController {
private UserService userserv;
@Autowired
public UserController(UserService userserv) {
this.userserv = userserv;
	}
	
 @GetMapping("/getdest/{destination}")
public ResponseEntity<Tourism_User> getdestinationBydestination(@PathVariable String destination)throws DataNotFoundException{
	 return ResponseEntity.ok().body(userserv.getAlldestination(destination));
	
	    }
}
