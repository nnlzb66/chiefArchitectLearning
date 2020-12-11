package com.zhss.oa.flow.mapper;

import com.zhss.oa.flow.model.Application;

public interface ApplicationMapper {
	
	public void create(Application app);
	
	public void delete(Long id);
	
	public Application findById(Long id);
	
}
