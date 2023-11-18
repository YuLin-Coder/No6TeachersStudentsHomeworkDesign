package cn.smxy.fzw;
import java.sql.Connection;

import javax.activation.DataSource;


import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBconnectionUtils {

	private static ComboPooledDataSource ds;  //สýพÝิด
	static {
		ds=new ComboPooledDataSource();
	}
	public static Connection getConnectionFromPool() {
		try {
			Connection conn= ds.getConnection();
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}	
}
