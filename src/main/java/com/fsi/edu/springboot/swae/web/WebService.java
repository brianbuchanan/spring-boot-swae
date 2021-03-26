package com.fsi.edu.springboot.swae.web;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsi.edu.springboot.swae.dal.Stock;
import com.fsi.edu.springboot.swae.dal.StockService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * Replication Engine Service
 * 
 * @author bbuchanan
 *
 */
@CrossOrigin
@RestController
@RequestMapping
public class WebService {

	@Autowired
	private StockService stockService;
	
	/**
	 * Stops the Replication Engine (no data comes in, no data goes out)
	 * 
	 * @return "Stopped"
	 */
	@Operation(summary = "", responses = {
			@ApiResponse(responseCode = "200", description = ""),
			@ApiResponse(responseCode = "500", description = "") })
	@GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON)
	public List<Stock> query() {
		return stockService.getAllStocks();
	}
	
}
