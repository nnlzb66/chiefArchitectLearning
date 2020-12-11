package com.zhss.oa.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.oa.auth.mapper.AuthorizationMapper;
import com.zhss.oa.auth.model.Authorization;
import com.zhss.oa.auth.service.AuthorizationService;

@Service("authorizationService")  
public class AuthorizationServiceImpl implements AuthorizationService {

	@Autowired
	private AuthorizationMapper authorizationMapper;
	
	public void authorize(Authorization auth) {
		authorizationMapper.authorize(auth); 
	}

	public void unauthorize(Long id) {
		authorizationMapper.unauthorize(id); 
	}

	public Authorization findById(Long id) {
		return authorizationMapper.findById(id);
	}

}
