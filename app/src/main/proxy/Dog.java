package proxy;

import proxy.Animal;

public class Dog implements Animal {

	public void bark() {
		System.out.println("狗叫");
	}

	public void stop(){
		System.out.println("狗子，停");
	}
	
}
