package test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import dao.DataAccess;
import dao.IGuitar;
import model.Builder;
import model.Guitar;
import model.GuitarSpec;
import model.Inventory;
import model.Type;
import model.Wood;

public class GuitarTest {

	@Test
	public void searchGuitar() throws Exception {
		IGuitar guitarDao=DataAccess.createGuitarDao();
		Inventory inventory=new Inventory(guitarDao.getGuitar());
		    GuitarSpec whatErinLikes = 
		      new GuitarSpec(Builder.FENDER, "model1", 
		                     Type.ELECTRIC, Wood.INDIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD,1);
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
	@Test
	public void delGuitar() throws Exception{
		IGuitar guitarDao=DataAccess.createGuitarDao();
		guitarDao.delGuitar("guitar2");
	}
	@Test
	public void addGuitar() throws Exception{
		IGuitar guitarDao=DataAccess.createGuitarDao();
		GuitarSpec guitarSpec= new GuitarSpec(Builder.FENDER, "model1", Type.ELECTRIC, 
				Wood.INDIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD,1);
		Guitar guitar=new Guitar("guitar4", 800,guitarSpec);
		guitarDao.addGuitar(guitar);
		
	}

}
