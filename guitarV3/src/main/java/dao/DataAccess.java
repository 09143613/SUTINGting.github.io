package dao;

public class DataAccess {
	private static String daoName = "sqliteDao";
	//这里可以切换数据库
	//private static String daoName = "mysqlDao";
	public static IGuitar createGuitarDao() {
		IGuitar result = null;
		try {
			Object o = Class.forName(daoName + "." + "GuitarDaoImpl").newInstance();
			result = (IGuitar)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

    /*
     * 原来的
     * private static String db = "sqlite";

	public static IGuitar createGuitarDao() {
		IGuitar result = null;
		switch (db) {
		case "sqlite":
			result = new sqliteDao.GuitarDaoImpl();
			break;
		case "mysql":
			result = new mysqlDao.GuitarDaoImpl();
			break;
		}
		return result;
	}*/

	/*public static IUser createUserDao() {
		IUser ret = null;
		switch (db) {
		case "sqlite":
			ret = new sqliteDao.UserDaoImpl();
			break;
		case "mysql":
			ret = new mysqlDao.UserDaoImpl();
			break;
		}
		return ret;
	}*/

}
