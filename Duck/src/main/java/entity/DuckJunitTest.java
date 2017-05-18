package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class DuckJunitTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Duck duck=new MallardDuck();   
	    duck.performFly();   
	    duck.performQuack();   
	    duck.setFlyBehavior(new FlyNoWay());   
	    duck.performFly();
	    System.out.println("test!!!");
	}

}
