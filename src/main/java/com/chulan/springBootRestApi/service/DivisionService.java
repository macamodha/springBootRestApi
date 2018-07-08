package com.chulan.springBootRestApi.service;

import java.util.List;

import com.chulan.springBootRestApi.model.Division;

public interface DivisionService {
	
	Division save(Division division);
	List<Division> findAll();
	Division findOne(Long divisionId);
	void deleteDivision(Division division);
}
