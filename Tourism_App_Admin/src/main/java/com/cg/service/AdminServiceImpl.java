package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.DestinationAlreadyExistsException;

import com.cg.model.Tourism_Admin;
import com.cg.repository.AdminRepository;



@Service
public class AdminServiceImpl implements AdminService {
	private AdminRepository AdminRepo;
	@Autowired
	public AdminServiceImpl(AdminRepository AdminRepo) {
		super();
		this.AdminRepo = AdminRepo;
	}
		
	@Override
	public Tourism_Admin adddestination(Tourism_Admin addDest)throws DestinationAlreadyExistsException{
		if(AdminRepo.existsById(addDest.getid())) {
			throw new  DestinationAlreadyExistsException();
		}
		Tourism_Admin savedDept = AdminRepo.save(addDest);
		return savedDept;
	}
		
		
	@Override
	public List<Tourism_Admin> getAlldestination() {
	
		return (List<Tourism_Admin>) AdminRepo.findAll();
	}

	@Override
	public void deletedestinationByadminid(int  adminid) {
		AdminRepo.deleteById(adminid);
		}

	

	@Override
	public Tourism_Admin updatedestination(Tourism_Admin updateDest) {
		Tourism_Admin record;
		Optional<Tourism_Admin> opt = AdminRepo.findById(updateDest.getid());
		if(opt.isPresent()) {
			record=opt.get();
		record.setAdminid(updateDest.getid());
			record.setDestination(updateDest.getDestination());
			AdminRepo.save(record);
		}else {
			return new Tourism_Admin();
		}
		return record;
	}

}


















