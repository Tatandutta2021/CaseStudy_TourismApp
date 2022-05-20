package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cg.model.Users1;

public interface UserRepositiory extends MongoRepository<Users1, String> {
	Users1 findByuserName(String userName);
}
