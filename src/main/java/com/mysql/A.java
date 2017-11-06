package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class A {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";

	public static final String DBURL = "rm-2ze38ihnc8ll25dxmo.mysql.rds.aliyuncs.com:3306/jhdd_database";

	public static final String DBUSER = "root";

	public static final String DBPASS = "Dhdd_1009";

	public static void main(String[] args) throws Exception {

		Connection conn = null;// 表示数据库连接的对象

		Statement stmt = null;// 表示数据库更新操作

		ResultSet result = null;// 表示接受数据库查询到的结果

		Class.forName(DBDRIVER);// 使用class类加载驱动程序

		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);// 连接数据库

		stmt = conn.createStatement();// tatement接口需要通过connection接口进行实例化操作

		result = stmt.executeQuery("select * from jhdd_rooms");// 执行sql语句，结果集放在result中

		while (result.next()) {// 判断是否还有下一行
			String name = result.getString("roomName");// 获取数据库person表中name字段的值
			System.out.println(name);
		}
		result.close();
		stmt.close();
		conn.close();

	}
}
