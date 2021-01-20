package com.obj;

public class LearnObject {

	public static void main(String[] args) {
		String str = "some string";
		String str2 = new String("some string");
//		
//		Car c1 = new Car();
//		Engine e1 = new Engine();
//		e1.name = "power366";
//		
//		c1.name = "sonata";
//		c1.horsePower = 27;
//		c1.color = "yellow";
//		c1.engine = e1;
//		c1.engine.run();
//		
//		Engine e2	= new Engine("force");
//		Car c2		= new Car(e2);
//		c2.engine.run();
		
		Car c3 = CarFactory.create("accent", 1, "white", new Engine("dino"));
		

	}

}


class Car {
	String name;
	int horsePower;
	String color;
	Engine engine;
	
	public Car() {}
	
	public Car(Engine e) {
		this.engine = e;
	}
	
	public Car(String n, int h, String c, Engine e) {
		this.name = n;
		this.horsePower = h;
		this.color = c;
		this.engine = e;
	}
}

class Engine {
	String name;
	
	public Engine() {}
	public Engine(String n) {
		this.name = n;
	}
	
	public void run() {
		System.out.println(this.name + " Egine is running");
	}
}


class CarFactory {	
	static public Car create(String name, int horsePower, String color, Engine engine) {
		return new Car(name, horsePower, color, engine);
	}
}