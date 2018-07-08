package com.chulan.springBootRestApi.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chulan.springBootRestApi.model.Division;

@Repository("divisionRepositary")
public interface DivisionRepositary extends JpaRepository<Division, Long> {

}
