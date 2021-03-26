package com.fsi.edu.springboot.swae.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, String> {
	
	List<Stock> findByName(String name);
}
