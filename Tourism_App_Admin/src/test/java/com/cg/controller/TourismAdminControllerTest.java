package com.cg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.model.Tourism_Admin;
import com.cg.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)

public class TourismAdminControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private AdminService adminserv;
	private Tourism_Admin ja;
	private List<Tourism_Admin> destList;

	@InjectMocks
	private Tourism_AdminController jpc;

	@BeforeEach
	public void setUp()
	{
	ja=new Tourism_Admin(10, "Bhutan", "Thimpu, Paro", 95000);
	mockMvc=MockMvcBuilders.standaloneSetup(jpc).build();
	}



	@Test
	public void addTourismAdminControllerTest() throws Exception {
	when(adminserv.adddestination(any())).thenReturn(ja);

		mockMvc.perform(post("/api/v1/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(ja)))
		        .andExpect(status().isCreated());
		
	} 

	@Test
	public void getAllTourismAdminControllerTest() throws  Exception {
	when(adminserv.getAlldestination()).thenReturn(destList);
	
		
			mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getall")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJSONString(ja)))
			.andDo(MockMvcResultHandlers.print());
		
		// TODO Auto-generated catch block
verify(adminserv,times(1)).getAlldestination();
	}



	public static String asJSONString(final Object obj) {
	
	try {
	return new ObjectMapper().writeValueAsString(obj);
	}
	catch(Exception e)
	{
	throw new RuntimeException (e);
	}
	}


}
