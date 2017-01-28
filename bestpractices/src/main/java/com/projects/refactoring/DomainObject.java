package com.projects.refactoring;

public class DomainObject {
	
	protected String name = "no name";
	
	public DomainObject() {};
	
	public DomainObject(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.name;
	}
}
