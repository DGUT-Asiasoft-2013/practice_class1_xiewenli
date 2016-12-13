package com.example.helloworld.api.entity;

import java.util.List;

public class Page<T> {
	List<T> content;
	Integer number;
	
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
