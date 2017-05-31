package service;

import java.util.List;

import dao.DataAccess;
import dao.IGuitar;
import model.Guitar;
import model.Inventory;

public interface GuitarService {
	
	public void setGuitarDao(IGuitar guitarDao);
	
	public void addGuitar(Guitar guitar) throws Exception;
	
	public void delGuitar(String serialNumber) throws Exception;

	public List<Guitar> getGuitar() throws Exception;
	
	/*private IGuitar dao = DataAccess.createGuitarDao();
	
	public GuitarService(){}
	
	public Inventory getInventory() throws Exception{
		Inventory inv = new Inventory();
		List<Guitar> List = dao.getGuitar();
		for(Guitar i : List){
			inv.addGuitar(i.getSerialNumber(),i.getPrice(),i.getSpec());
		}
		return inv;
	}*/
}
