package com.rj.gate.coding;

public class A implements Cloneable{
	int a,b,c;	
	
	public static void main(String[] args){
		A a1=new A();
		a1.a=1;
		a1.b=2;
		a1.c=3;	
	
		try {
			a1.sum((A)a1.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a1.a+""+a1.b+""+a1.c);
	}
	
	public void sum(A a){
		a.a=11;
		a.b=22;
		a.c=33;
		System.out.println(a.a+""+a.b+""+a.c);
	
	}
}
