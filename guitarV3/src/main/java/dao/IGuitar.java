package dao;

import java.util.List;

import model.Guitar;

public interface IGuitar {
	//add
	public void addGuitar(Guitar guitar) throws Exception;
	//delete
	public void delGuitar(String serialNumber) throws Exception;
	//search
	public List<Guitar> getGuitar() throws Exception;
	
}
