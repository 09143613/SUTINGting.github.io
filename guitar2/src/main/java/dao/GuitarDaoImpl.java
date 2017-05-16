package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dbutil.SQLiteJDBC;
import entity.Builder;
import entity.Guitar;
import entity.GuitarSpec;
import entity.Type;
import entity.Wood;

public class GuitarDaoImpl implements GuitarDao{
	
	@Override
	public List<Guitar> getGuitar() {
		// TODO Auto-generated method stub
		ResultSet rs= SQLiteJDBC.executeQuery("select * from guitar", new Object[]{});
		List<Guitar> guitarList = new LinkedList<Guitar>();
		
		try{
			while(rs.next()){
				GuitarSpec guitarSpec=new GuitarSpec(Builder.valueOf(rs.getString(3)),
						rs.getString(5),Type.valueOf(rs.getString(4)),
						Wood.valueOf(rs.getString(6)),Wood.valueOf(rs.getString(7)));
				//GuitarSpec guitarSpec = null;
				Guitar guitar = new Guitar(rs.getString(1), rs.getDouble(2), guitarSpec);
				guitarList.add(guitar);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return guitarList;
	}
	
}
