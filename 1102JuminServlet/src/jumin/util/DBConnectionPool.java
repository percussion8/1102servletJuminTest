package jumin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnectionPool {
	String url;
	String username;
	String password;
	ArrayList<Connection> connList = new ArrayList<Connection>();
	
	public DBConnectionPool(String driver, String url, String user, String pass) throws Exception {
		this.url = url;
		this.password = pass;
		this.username = user;
		Class.forName(driver);
	}
	
	public Connection getConnection() throws Exception {
		if(connList.size() > 0) { //이미 존재하면 꺼내와서 연결확인 후 반환해줌
			Connection conn = connList.remove(0); 
			if(conn.isValid(10)) {
				return conn;
			}
		}
		return DriverManager.getConnection(url, username, password); //if문 false시 새로 생성해서 반환해줌
	}
	
	public void returnConnection (Connection conn) throws Exception{
		connList.add(conn);
	}
	
	public void closeAll() {
		for(Connection conn : connList) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
