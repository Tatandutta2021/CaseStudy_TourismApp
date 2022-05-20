package com.cg.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.DataNotFoundException;

import com.cg.model.Tourism_User;
import com.cg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository UserRepo;
	@Autowired
	public UserServiceImpl(UserRepository UserRepo) {
		super();
		this.UserRepo = UserRepo;

}

	@Override
	public Tourism_User getAlldestination(String destination) throws DataNotFoundException {
		// TODO Auto-generated method stub
		 Optional<Tourism_User>Otu = this.UserRepo.findBydestination(destination);
		 if(Otu.isPresent())
		 {
			 return Otu.get(); 
		 }else {
			 
	throw new 	DataNotFoundException();
	}
		
	}
	}


	
