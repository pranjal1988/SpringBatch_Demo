package com.github.pranjal1988.demo.Model;

public class Stock {
	private String stockName;
	private String stockSymbol;
	private double stockPrice;
	private String issuingCountry;
	private String currency;
	
	public Stock(String name, String symbol){
		this.stockName = name;
		this.stockSymbol = symbol;
	}
	
	public Stock(String name, String symbol, String country, String currency, double price){
		this(name, symbol);
		this.currency = currency;
		this.issuingCountry = country;
		this.stockPrice = price;
	}
	
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getIssuingCountry() {
		return issuingCountry;
	}
	public void setIssuingCountry(String issuingCountry) {
		this.issuingCountry = issuingCountry;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((issuingCountry == null) ? 0 : issuingCountry.hashCode());
		result = prime * result
				+ ((stockName == null) ? 0 : stockName.hashCode());
		result = prime * result
				+ ((stockSymbol == null) ? 0 : stockSymbol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (issuingCountry == null) {
			if (other.issuingCountry != null)
				return false;
		} else if (!issuingCountry.equals(other.issuingCountry))
			return false;
		if (stockName == null) {
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		if (stockSymbol == null) {
			if (other.stockSymbol != null)
				return false;
		} else if (!stockSymbol.equals(other.stockSymbol))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.stockName + " [ " + stockSymbol + " ] : \n\t Price :- " + stockPrice + currency + " \n\t " + "Country Of Issue : " + issuingCountry;
	}
	
	

}
