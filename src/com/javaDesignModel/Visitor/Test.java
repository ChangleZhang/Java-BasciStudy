package com.javaDesignModel.Visitor;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Visitor visitor = new MyVisitor();
		Subject sub = new MySubject();
		sub.accept(visitor);
	}

}
