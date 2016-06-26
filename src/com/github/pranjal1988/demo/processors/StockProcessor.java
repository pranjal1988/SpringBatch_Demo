package com.github.pranjal1988.demo.processors;

import org.springframework.batch.item.ItemProcessor;

import com.github.pranjal1988.demo.Model.Stock;

public class StockProcessor implements ItemProcessor<String, Stock>{

	@Override
	public Stock process(String item) throws Exception {
		if(item == null){
			return null;
		}
		String[] args = item.split("\\|");
		String name = args[0];
		String symbol = args[1];
		String priceString = args[2];
		String currency = args[3];
		String country = args[4];
		Stock st = new Stock(name, symbol, country, currency, Double.parseDouble(priceString));
		return st;
	}

}
