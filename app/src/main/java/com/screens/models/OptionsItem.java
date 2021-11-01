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

	public void setPrice(String price) {
		this.price = price;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public OptionsItem(String price, String label) {
		this.price = price;
		this.label = label;
	}

	@Override
	public String toString() {
		return "{" +
				"\"price\":" + "\""+price + "\"" +
				", \"label\":" +"\""+ label + "\"" +
				'}';
	}
}