package com.example.di;

public class Greeting {
	private final long id;
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
		System.out.println("greeting constructor");
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
}
