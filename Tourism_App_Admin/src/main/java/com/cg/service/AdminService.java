package com.cg.service;

import java.util.List;

import com.cg.exception.DestinationAlreadyExistsException;
import com.cg.model.Tourism_Admin;




public interface AdminService {
//CRUD Part
	
	public List<Tourism_Admin> getAlldestination();
	public void deletedestinationByadminid(int id);
	public Tourism_Admin adddestination(Tourism_Admin addDest)throws DestinationAlreadyExistsException;
	public Tourism_Admin updatedestination(Tourism_Admin updateDest);
}
