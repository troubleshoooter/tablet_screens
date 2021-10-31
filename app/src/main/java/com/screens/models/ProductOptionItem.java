package com.screens.models;

import java.util.List;

public class ProductOptionItem{

	private int categoryId;

	private List<OptionsItem> options;

	private String type;

	private String title;

	private String required;

	public int getCategoryId(){
		return categoryId;
	}

	public List<OptionsItem> getOptions(){
		return options;
	}

	public String getType(){
		return type;
	}

	public String getTitle(){
		return title;
	}

	public String getRequired(){
		return required;
	}

	public ProductOptionItem(int categoryId, List<OptionsItem> options, String type, String title, String required) {
		this.categoryId = categoryId;
		this.options = options;
		this.type = type;
		this.title = title;
		this.required = required;
	}
}