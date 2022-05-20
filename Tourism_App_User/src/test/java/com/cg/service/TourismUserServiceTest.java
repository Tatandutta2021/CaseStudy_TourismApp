package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.DataNotFoundException;
import com.cg.model.Tourism_User;
import com.cg.repository.UserRepository;




@SpringBootTest

@ExtendWith(MockitoExtension.class)
public class TourismUserServiceTest {
	
	
	
		@Mock

		private UserRepository lr;

		@InjectMocks

		private UserServiceImpl lsl;
			
			@Test
			public void TestAddLibrary() throws DataNotFoundException {
				
				Tourism_User l1 = new Tourism_User (35, "Bhutan", "Thimpu, Paro", 95000);
				
		when(lr.save(any())).thenReturn(l1);     // any = any Object>> call any object and return.
		//lsl.getBydestination(l1);                     // data saved in database 
		verify(lr,times(1)).save(any());       // verify repository by calling 1 time and perform operation
		}
			
		//Create GetALL Library	
			@Test
			public void testgetAlldestination() {
				Tourism_User l1 = new Tourism_User (39, "Bhutan", "Thimpu, Paro", 94500);
				Tourism_User l2 = new Tourism_User(75, "Nepal", "Thimpu, Paro", 98000); 
				Tourism_User l3 = new Tourism_User(19, "Malayasia", "Thimpu, Paro", 95890); 
				lr.save(l1);
				lr.save(l2); // Data saved in Database
				lr.save(l3);
				List<Tourism_User>lbList = new ArrayList<>();
				lbList.add(l1);
				lbList.add(l2);
				lbList.add(l3);
				
				when(lr.findAll()).thenReturn(lbList);
				//List<Tourism_User> lbList1 = lsl.getBydestination();
				//assertEquals(lbList, lbList1);
				verify(lr,times(1)).save(l1);
				verify(lr,times(1)).findAll();
				
				
				}
			
		

	}



