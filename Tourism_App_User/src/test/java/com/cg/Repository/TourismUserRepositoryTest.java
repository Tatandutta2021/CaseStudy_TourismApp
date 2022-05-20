package com.cg.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.Tourism_User;
import com.cg.repository.UserRepository;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TourismUserRepositoryTest {
	

	@Autowired
		private UserRepository UserRepo;
		
		@Test
		public void givenTourism_AdminShouldReturnTourism_AdminObject() {
			Tourism_User t1 = new Tourism_User(56, "Switzerland", "Zürich, Basel", 95900);
			UserRepo.save(t1);
			Tourism_User t2 = UserRepo.findById(t1.getAdminid()).get();
			assertNotNull(t1);
			assertEquals(t1.getAdminid(), t2.getAdminid());
			
	}
		@Test
		public void getAllmustReturnAllTourism_Admin() {
			Tourism_User t3 = new Tourism_User (35, "Bhutan", "Thimpu, Paro", 95000); 
			Tourism_User t4 = new Tourism_User (58, "France", "Paris, Strasbourg", 74399); 
			UserRepo.save(t3);
			UserRepo.save(t4);
			List<Tourism_User>Tourismlist = (List<Tourism_User>)UserRepo.findAll();
		assertEquals(95900,Tourismlist.get(4).getTotal_Cost());
		
		}
		
		}



