package com.example.azuredemo.dto;

import java.io.Serializable;

public class GenericPayload implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8626967142516692426L;
	private String id;
	private String name;
	private String source;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	

}
