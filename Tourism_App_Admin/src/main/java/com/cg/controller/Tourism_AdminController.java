package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.DestinationAlreadyExistsException;

import com.cg.model.Tourism_Admin;
import com.cg.service.AdminService;


@RestController
@RequestMapping("/api/v1")
public class Tourism_AdminController {
	
	private AdminService adminservice;
	@Autowired
public Tourism_AdminController(AdminService adminservice) {
this.adminservice = adminservice;
	}
	
	@PostMapping("/add")
public ResponseEntity<Tourism_Admin> addLibrary(@RequestBody Tourism_Admin addDest ) throws DestinationAlreadyExistsException{
Tourism_Admin saveddept = adminservice.adddestination(addDest);
return new ResponseEntity<>(saveddept, HttpStatus.CREATED);
   }
	 @GetMapping("/getall")
public ResponseEntity<List<Tourism_Admin>> getAllDestination(){
return new ResponseEntity<List<Tourism_Admin>>((List<Tourism_Admin>)adminservice.getAlldestination(),HttpStatus.OK);
	    }
	
	    
	 @DeleteMapping("admin/{id}")
public ResponseEntity<Void> deleteDestinationByadmin_ID(@PathVariable int id){
adminservice.deletedestinationByadminid(id);
return ResponseEntity.noContent().build();
	
	 }
	 @PutMapping("/update")
public Tourism_Admin updateDestination(@RequestBody Tourism_Admin updateDest) {
return  adminservice.updatedestination(updateDest);
		}
	 
}
