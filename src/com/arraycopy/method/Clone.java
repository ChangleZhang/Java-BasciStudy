package com.arraycopy.method;

public class Clone {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Cat cat1 = new Cat("xiaohua",3);
		System.out.println(cat1);
		//调用clone()方法
		Cat cat2 = (Cat)cat1.clone();
		System.out.println(cat2);
	}

}

class Cat implements Cloneable{
	private String name;
	private int age;
	public Cat(String name,int age){
		this.name = name;
		this.age = age;
	}
	//重写clone()
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
