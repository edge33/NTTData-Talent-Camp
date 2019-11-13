package com.nttdata.talentcamp.magazzino.models;

public class Product {

	public Product(String name, String category, int price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	private String name;
	private String category;
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
