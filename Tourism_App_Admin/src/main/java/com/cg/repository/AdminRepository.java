package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.cg.model.Tourism_Admin;

public interface AdminRepository extends MongoRepository<Tourism_Admin, Integer> {

}
