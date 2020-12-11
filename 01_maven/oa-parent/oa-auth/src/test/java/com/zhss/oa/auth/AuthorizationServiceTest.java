package com.zhss.oa.auth;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhss.oa.auth.model.Authorization;
import com.zhss.oa.auth.service.AuthorizationService;

@ContextConfiguration(locations = {"classpath:application-auth.xml"})  
@RunWith(SpringJUnit4ClassRunner.class)  
public class AuthorizationServiceTest {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Test
	public void testAuthorize() {
		Authorization auth = new Authorization();
		auth.setEmployeeId(1L); 
		auth.setRoleId(1L);
		authorizationService.authorize(auth);
		assertEquals(true, auth.getId() > 0L); 
	}
	
	@Test
	public void testFindById() {
		Authorization auth = new Authorization();
		auth.setEmployeeId(1L); 
		auth.setRoleId(1L);
		authorizationService.authorize(auth);
		Authorization _auth = authorizationService.findById(auth.getId());
		assertEquals(true, _auth != null); 
	}
	
	@Test
	public void testUnauthorize() {
		Authorization auth = new Authorization();
		auth.setEmployeeId(1L); 
		auth.setRoleId(1L);
		
		authorizationService.authorize(auth);
		authorizationService.unauthorize(auth.getId());  
		Authorization _auth = authorizationService.findById(auth.getId());
		
		assertEquals(true, _auth == null);  
	}
	
}
