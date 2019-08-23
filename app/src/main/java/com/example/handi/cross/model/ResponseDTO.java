package com.example.handi.cross.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResponseDTO implements Serializable {

	@SerializedName("data")
	private List<DataDTO> data;

	public void setData(List<DataDTO> data){
		this.data = data;
	}

	public List<DataDTO> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}