package com.example;

import jakarta.ejb.Remote;

@Remote
public interface StatelessEjbRemote {
	void insert(String name);
	public String sayHello();
}
