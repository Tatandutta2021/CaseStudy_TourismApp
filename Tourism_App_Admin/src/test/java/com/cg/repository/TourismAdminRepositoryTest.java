package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.cg.model.Tourism_Admin;
@SpringBootTest
@ExtendWith(SpringExtension.class)

class TourismAdminRepositoryTest {
	
	
	@Autowired
	private AdminRepository AdminRepo;
	
	@Test
	public void givenTourism_AdminShouldReturnTourism_AdminObject() {
		Tourism_Admin t1 = new Tourism_Admin(56, "Switzerland", "Zürich, Basel", 95900);
		AdminRepo.save(t1);
		Tourism_Admin t2 = AdminRepo.findById(t1.getid()).get();
		assertNotNull(t1);
		assertEquals(t1.getid(), t2.getid());
		
}
	@Test
	public void getAllmustReturnAllTourism_Admin() {
		Tourism_Admin t3 = new Tourism_Admin (35, "Bhutan", "Thimpu, Paro", 95000); 
		Tourism_Admin t4 = new Tourism_Admin (58, "France", "Paris, Strasbourg", 74399); 
		AdminRepo.save(t3);
		AdminRepo.save(t4);
		List<Tourism_Admin>Tourismlist = (List<Tourism_Admin>)AdminRepo.findAll();
	assertEquals(95900,Tourismlist.get(4).getTotal_Cost());
	
	}
	
	}


