package com.javaDesignModel.Visitor;

public interface Subject {
	public void accept(Visitor visitor);  
    public String getSubject();
}
