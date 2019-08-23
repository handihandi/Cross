package com.example.handi.cross.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class DataDTO implements Serializable {

	@SerializedName("section")
	private String section;

	@SerializedName("items")
	private List<ItemsDTO> items;

	public void setSection(String section){
		this.section = section;
	}

	public String getSection(){
		return section;
	}

	public void setItems(List<ItemsDTO> items){
		this.items = items;
	}

	public List<ItemsDTO> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"DataDTO{" + 
			"section = '" + section + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}