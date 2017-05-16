package guitar2;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import entity.Builder;
import entity.Guitar;
import entity.GuitarSpec;
import entity.Inventory;
import entity.Type;
import entity.Wood;

public class GuitarTest {

	@Test
	public void test() {
		 // Set up Rick's guitar inventory
	    Inventory inventory = new Inventory();
	    initializeInventory(inventory);

	    GuitarSpec whatErinLikes = 
	      new GuitarSpec(Builder.FENDER, "model1", 
	                     Type.ELECTRIC, Wood.INDIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD);
	    List matchingGuitars = inventory.search(whatErinLikes);
	    if (!matchingGuitars.isEmpty()) {
	      System.out.println("Erin, you might like these guitars:");
	      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
	        Guitar guitar = (Guitar)i.next();
	        GuitarSpec spec = guitar.getSpec();
	        System.out.println("  We have a " +
	          spec.getBuilder() + " " + spec.getModel() + " " +
	          spec.getType() + " guitar:\n     " +
	          spec.getBackWood() + " back and sides,\n     " +
	          spec.getTopWood() + " top.\n  You can have it for only $" +
	          guitar.getPrice() + "!\n  ----");
	      }
	    } else {
	      System.out.println("Sorry, Erin, we have nothing for you.");
	    }
	  }

	  private static void initializeInventory(Inventory inventory){
	    inventory.addGuitar("guitar1", 200.0, 
	      new GuitarSpec(Builder.FENDER, "model1", Type.ACOUSTIC, 
	                     Wood.INDIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD));
	    inventory.addGuitar("guitar2", 500.0, 
	      new GuitarSpec(Builder.FENDER, "model1", Type.ELECTRIC, 
	                     Wood.MAHOGANY, Wood.MAHOGANY));
	  }

}

