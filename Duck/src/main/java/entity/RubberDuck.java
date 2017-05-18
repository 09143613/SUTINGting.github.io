package entity;

public class RubberDuck extends Duck {
	
	public RubberDuck() {   
		flyBehavior=new FlyNoWay();   
		quackBehavior=new MuteQuack();   
	} 
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("It's a rubber duck £¡");
	}
	
}
