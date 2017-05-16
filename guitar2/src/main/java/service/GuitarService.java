package service;

import java.util.List;

import dao.GuitarDao;
import dao.GuitarDaoImpl;
import entity.Guitar;

public interface GuitarService {
	
	public List<Guitar> getGuitar();
	
	/*public GuitarService() {
		super();
	}*/

	public void setGuitarDao(GuitarDao guitarDao) ;
	
}


	

