package com.fsi.edu.springboot.swae.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	public List<Stock> getAllStocks() {
		Iterable<Stock> unitIterable = stockRepository.findAll();
		List<Stock> stocks = new ArrayList<>();
		unitIterable.forEach(stocks::add);
		return stocks;
	}

	public Stock findStockBySymbol(String symbol) {
		if (symbol == null) {
			throw new IllegalArgumentException("Null symbol provided");
		}
		Optional<Stock> stock = stockRepository.findById(symbol);
		if (stock.isPresent()) {
			return stock.get();
		} else {
			return null;
		}
	}

	public Stock saveStock(Stock unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Null stock provided");
		}
		return stockRepository.save(unit);
	}

	public Stock getStockByName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Null stock name provided");
		}
		List<Stock> stocksByName = stockRepository.findByName(name);
		if (stocksByName.isEmpty()) {
			return null;
		} else if (stocksByName.size() > 1) {
			throw new IllegalStateException("There should never be more than one stock with the same name");
		} else {
			return stocksByName.get(0);
		}
	}
}
