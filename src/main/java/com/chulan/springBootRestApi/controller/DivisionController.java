package com.chulan.springBootRestApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chulan.springBootRestApi.model.Division;
import com.chulan.springBootRestApi.service.DivisionService;

@RestController
@RequestMapping("/division")
public class DivisionController {

	@Autowired
	DivisionService divisionService;
	
	//to save a division
	@PostMapping("/save")
	public Division createDivision(@Valid @RequestBody Division division) {
		return divisionService.save(division);
	}
	
	//to get the division list
	@GetMapping("/list")
	public List<Division> getAll() {
		return divisionService.findAll();
	}
	
	//to get a division by id
	@GetMapping("/get/{id}")
	public ResponseEntity<Division> getDivision(@PathVariable(value="id") Long divisionId) {
		Division div = divisionService.findOne(divisionId);
		if(div== null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(div);
	}
	
	//update a division
	@PutMapping("/update/{id}")
	public ResponseEntity<Division> updateDivision(@PathVariable(value="id") Long divisionId, @Valid @RequestBody Division division) {
		/*Division div = divisionService.findOne(divisionId);
		if(div==null) {
			return ResponseEntity.notFound().build();
		}*/
		divisionService.save(division);
		return ResponseEntity.ok().body(division);
	}
	
	//delete a division
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Division> deleteDivision(@PathVariable(value="id") Long divisionId) {
		Division div = divisionService.findOne(divisionId);
		if(div==null ) {
			return ResponseEntity.notFound().build();
		}
		divisionService.deleteDivision(div);
		return ResponseEntity.ok().build();
	}
	
}
