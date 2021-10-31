package com.screens.models;

public class OptionsItem{

	private String price;

	private String label;

	public String getPrice(){
		return price;
	}

	public String getLabel(){
		return label;
	}

	public OptionsItem(String price, String label) {
		this.price = price;
		this.label = label;
	}
}