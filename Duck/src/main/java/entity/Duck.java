package entity;

public abstract class Duck {
	//不变的
	public void swim(){
		System.out.println("ALl ducks can swim!!!");
	}
		
	public abstract void display();
	
	QuackBehavior quackBehavior;
	
	FlyBehavior flyBehavior;
	
	//委托
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void performFly(){
		flyBehavior.fly();
	}
	//动态设置
	public void setQuackBehavior(QuackBehavior behavior) {
		this.quackBehavior = behavior;
	}
	
	public void setFlyBehavior(FlyBehavior behavior){
		this.flyBehavior = behavior;
	}
	
}
