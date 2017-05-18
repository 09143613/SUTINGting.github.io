package entity;

public abstract class Duck {
	//�����
	public void swim(){
		System.out.println("ALl ducks can swim!!!");
	}
		
	public abstract void display();
	
	QuackBehavior quackBehavior;
	
	FlyBehavior flyBehavior;
	
	//ί��
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void performFly(){
		flyBehavior.fly();
	}
	//��̬����
	public void setQuackBehavior(QuackBehavior behavior) {
		this.quackBehavior = behavior;
	}
	
	public void setFlyBehavior(FlyBehavior behavior){
		this.flyBehavior = behavior;
	}
	
}
