package com.cg.service;

import static org.junit.jupiter.api.Assertions.*;
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

import com.cg.exception.DestinationAlreadyExistsException;
import com.cg.model.Tourism_Admin;
import com.cg.repository.AdminRepository;




@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TourismAdminServiceTest {
	@Mock

	private AdminRepository lr;

	@InjectMocks

	private AdminServiceImpl lsl;
		
		@Test
		public void TestAddLibrary() throws DestinationAlreadyExistsException {
			
			Tourism_Admin l1 = new Tourism_Admin (35, "Bhutan", "Thimpu, Paro", 95000);
			
	when(lr.save(any())).thenReturn(l1);     // any = any Object>> call any object and return.
	lsl.adddestination(l1);                     // data saved in database 
	verify(lr,times(1)).save(any());       // verify repository by calling 1 time and perform operation
	}
		
	//Create GetALL Library	
		@Test
		public void testgetAllLibrary() {
			Tourism_Admin l1 = new Tourism_Admin (35, "Bhutan", "Thimpu, Paro", 94500);
			Tourism_Admin l2 = new Tourism_Admin(78, "Nepal", "Thimpu, Paro", 98000); 
			Tourism_Admin l3 = new Tourism_Admin(79, "Malayasia", "Thimpu, Paro", 95890); 
			lr.save(l1);
			lr.save(l2); // Data saved in Database
			lr.save(l3);
			List<Tourism_Admin>lbList = new ArrayList<>();
			lbList.add(l1);
			lbList.add(l2);
			lbList.add(l3);
			
			when(lr.findAll()).thenReturn(lbList);
			List<Tourism_Admin> lbList1 = lsl.getAlldestination();
			assertEquals(lbList, lbList1);
			verify(lr,times(1)).save(l1);
			verify(lr,times(1)).findAll();
			
			
			}
		
	

}
