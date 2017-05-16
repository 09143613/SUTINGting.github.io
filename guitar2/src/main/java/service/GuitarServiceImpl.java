package service;

import java.util.List;

import dao.GuitarDao;
import entity.Guitar;

public class GuitarServiceImpl implements GuitarService{
	@Override
	public List<Guitar> getGuitar() {
		// TODO Auto-generated method stub
		return guitarDao.getGuitar();
	}
	@Override
	public void setGuitarDao(GuitarDao guitarDao) {
		// TODO Auto-generated method stub
		this.guitarDao=guitarDao;
	}
	private GuitarDao guitarDao;
}

