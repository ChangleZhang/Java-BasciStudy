package com.javaDesignModel.Visitor;

import JAVA_Design_Model_Observer.Observer;
import JAVA_Design_Model_Observer.Subject;

public class MySubject implements Subject, com.javaDesignModel.Visitor.Subject {

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		// TODO Auto-generated method stub
		return "love ";
	}

	@Override
	public void add(Observer observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(Observer observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub

	}

	@Override
	public void operation() {
		// TODO Auto-generated method stub

	}

}
