package service;

import java.util.List;

import dao.IGuitar;
import model.Guitar;

public class GuitarServiceImpl implements GuitarService{

	@Override
	public void setGuitarDao(IGuitar guitarDao) {
		// TODO Auto-generated method stub
		this.guitarDao =guitarDao;
	}

	@Override
	public void addGuitar(Guitar guitar) throws Exception {
		// TODO Auto-generated method stub
		guitarDao.addGuitar(guitar);
	}

	@Override
	public void delGuitar(String serialNumber) throws Exception {
		// TODO Auto-generated method stub
		guitarDao.delGuitar(serialNumber);
	}

	@Override
	public List<Guitar> getGuitar() throws Exception {
		// TODO Auto-generated method stub
		 return guitarDao.getGuitar();
	}
	
	private IGuitar guitarDao;

}
