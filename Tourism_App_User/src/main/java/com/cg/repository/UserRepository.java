package com.cg.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Tourism_User;

public interface UserRepository extends MongoRepository<Tourism_User, Integer> {
	public Optional<Tourism_User> findBydestination(String destination);

}
