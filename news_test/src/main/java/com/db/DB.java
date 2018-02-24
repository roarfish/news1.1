package com.db;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * JDBC连接数据库
 * @author zhoup
 *
 */
public class DB {
	//1.驱动
	private static String driver="com.mysql.jdbc.Driver";
	//2.连接地址
	private static String url="jdbc:mysql:///newsdb?autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&useSSL=true";
	//3.用户名
	private static String username="root";
	//4.密码
	private static String pwd=null;
	/**
	 * 创建mysql的连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, username, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
