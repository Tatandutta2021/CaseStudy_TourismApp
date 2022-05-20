package com.cg.service;

import com.cg.exception.DataNotFoundException;
import com.cg.model.Tourism_User;

public interface UserService {



public Tourism_User getAlldestination(String destination) throws DataNotFoundException;



}
