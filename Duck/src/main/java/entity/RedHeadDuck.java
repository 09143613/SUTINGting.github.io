package entity;

public class RedHeadDuck extends Duck {
	
	public RedHeadDuck() {   
		flyBehavior=new FlyWithWings();   
		quackBehavior=new Squack();   
	}   
	     
	public void display() {   
		System.out.println("Red head £¡");   
	}
}
