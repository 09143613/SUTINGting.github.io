package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.IGuitar;
import model.Builder;
import model.Guitar;
import model.GuitarSpec;
import model.Type;
import model.Wood;
import util.DbUtil;

public class GuitarDaoImpl implements IGuitar {
	//sqliteÊý¾Ý¿â

	@Override
	public void addGuitar(Guitar guitar) throws Exception{
		// TODO Auto-generated method stub
		GuitarSpec guitarSpec = guitar.getSpec();
		Connection Conn = DbUtil.getSqliteConnection();
		String sql = "insert into guitar values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = Conn.prepareStatement(sql);
		
		pstmt.setString(1, guitar.getSerialNumber());
		pstmt.setDouble(2,guitar.getPrice());
		pstmt.setString(3, guitarSpec.getBuilder().toString());
		pstmt.setString(4, guitarSpec.getType().toString());
		pstmt.setString(5, guitarSpec.getModel().toString());
		pstmt.setString(6, guitarSpec.getBackWood().toString());
		pstmt.setString(7, guitarSpec.getTopWood().toString());
		pstmt.setInt(8, guitar.getNumStrings());
		
		pstmt.executeUpdate();	
		
		pstmt.close();
		Conn.close();
		
	}

	@Override
	public void delGuitar(String serialNumber)  throws Exception{
		// TODO Auto-generated method stub
		Connection Conn = DbUtil.getSqliteConnection();	
		String sql = "delete from guitar where serialNumber = ? ";
		PreparedStatement pstmt = Conn.prepareStatement(sql);
		
	    pstmt.setString(1,serialNumber);
	    
		pstmt.executeUpdate();	
		
		pstmt.close();
		Conn.close();
	}

	@Override
	public List<Guitar> getGuitar() throws Exception{
		// TODO Auto-generated method stub
		List<Guitar> guitarList = new ArrayList<Guitar>();
		
		Connection Conn = DbUtil.getSqliteConnection();
		String sql = "select * from guitar";
		PreparedStatement pstmt = Conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		try{
			while(rs.next()){
				GuitarSpec guitarSpec=new GuitarSpec(Builder.valueOf(rs.getString(3)),
						rs.getString(5),Type.valueOf(rs.getString(4)),
						Wood.valueOf(rs.getString(6)),Wood.valueOf(rs.getString(7))
						,rs.getInt(8));
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
