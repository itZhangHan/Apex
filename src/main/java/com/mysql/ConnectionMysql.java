package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class ConnectionMysql {

	public static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver"; // 获取mysql数据库的驱动类
		String url = "jdbc:mysql://thdd.apexgame.cn/rm-2ze38ihnc8ll25dxmo.mysql.rds.aliyuncs.com:3306/jhdd_database"; // 连接数据库
		String name = "root";// 连接mysql的用户名
		String pwd = "Dhdd_1009";// 连接mysql的密码
		try {
			System.out.println("1");
			Class.forName(driver);
			System.out.println("2");
			Connection conn = DriverManager.getConnection(url, name, pwd);// 获取连接对象
			System.out.println("3");

			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		System.out.println("进入。");
		Connection cc = ConnectionMysql.getConnection();
		System.out.println("进入2");
		if (!cc.isClosed()) {
			System.out.println("Succeeded connecting to the Database!");
		} else {
			System.out.println("连接关闭");
		}
		Statement statement = cc.createStatement();
		String sql = "SELECT a.userId, a.userName,a.userPortrait FROM jhdd_users  a INNER JOIN jhdd_sidelines b ON a.userId = b.userId WHERE b.roomId=10055";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("id") + "大多数");
		}
	}
}
