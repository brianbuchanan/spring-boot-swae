package com.fsi.edu.springboot.swae.web;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsi.edu.springboot.swae.dal.Stock;
import com.fsi.edu.springboot.swae.dal.StockService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
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
@OpenAPIDefinition(info = @Info(title = "Stock Web Service"))
public class WebService {

	@Autowired
	private StockService stockService;
	
	/**
	 * Stops the Replication Engine (no data comes in, no data goes out)
	 * 
	 * @return "Stopped"
	 */
	@Operation(summary = "Query Stocks", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Error occurred while getting stocks") })
	@GetMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON)
	public List<Stock> getStocks(@Parameter(description = "Symbol") @RequestParam(required = false) String symbol) {
		List<Stock> stocks = new ArrayList<>();
		if (symbol == null) {
			stocks.addAll(stockService.getAllStocks());
		} else {
			stocks.add(stockService.findStockBySymbol(symbol));
		}
		return stocks;
	}
	
	@Operation(summary = "Get Single Stock by Symbol", responses = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Error occurred while getting stock") })
	@GetMapping(value = "/stocks/{symbol}", produces = MediaType.APPLICATION_JSON)
	public Stock queryBySymbolQueryParameter(@Parameter(description = "Symbol") @PathVariable String symbol) {
		return stockService.findStockBySymbol(symbol);
	}
}
