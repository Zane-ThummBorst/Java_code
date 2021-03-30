package Pairs;

import java.util.Objects;

public class Pairs<E,F> {
	private E a;
	private F b;
	
	Pairs( E a, F b){
		this.a = a;
		this.b = b;
	}

	public E getA() {
		return a;
	}

	public void setA(E a) {
		this.a = a;
	}

	public F getB() {
		return b;
	}

	public void setB(F b) {
		this.b = b;
	}
	public boolean equals(Object o) {
		if(this == o) {
			System.out.println("ass reached");
			return true;
		}
		if(o == null) {
			return false;
		}
		if(!(o instanceof Pairs<?,?>)) {
			return false;
		}
		Pairs<E,F>p = (Pairs<E,F>) o;
		return Objects.equals(a, p.getA()) && Objects.equals(b, p.getB());
	}
	public static void main(String[] args) {
		Pairs<Integer,Integer> ass = new Pairs(1,2);
		Pairs<Integer,Integer> ass2 = ass;
		System.out.println(ass.equals(ass2));
		
	}
}
