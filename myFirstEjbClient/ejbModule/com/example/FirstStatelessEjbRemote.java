package com.example;

import jakarta.ejb.Remote;

@Remote
public interface FirstStatelessEjbRemote {
	void insert(String name);
}
