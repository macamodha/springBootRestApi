package com.chulan.springBootRestApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chulan.springBootRestApi.model.Division;
import com.chulan.springBootRestApi.repositary.DivisionRepositary;
import com.chulan.springBootRestApi.service.DivisionService;

@Service("divisionService")
public class DivisionServiceImpl implements DivisionService {

	@Autowired
	DivisionRepositary divisionRepositary;
	
	@Override
	public Division save(Division division) {
		return divisionRepositary.save(division);
	}

	@Override
	public List<Division> findAll() {
		return divisionRepositary.findAll();
	}

	@Override
	public Division findOne(Long divisionId) {
		return divisionRepositary.findOne(divisionId);
	}

	@Override
	public void deleteDivision(Division division) {
		divisionRepositary.delete(division);
		
	}

}
