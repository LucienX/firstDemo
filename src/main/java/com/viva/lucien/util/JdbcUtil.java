package com.viva.lucien.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @time:2017年4月14日 下午4:51:39
 * @author Wuqx
 *
 * @Description:JDBC工具
 */
public class JdbcUtil {
	private static Connection connection;

	/**
	 * 获取数据库连接
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {

		connection = init();
		return connection;
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return Connection
	 */
	private static Connection init() {
		Connection connection = null;
		try {

			/*Properties properties = new Properties();
			InputStream stream = JdbcUtil.class.getResourceAsStream("/jdbc.properties");

			properties.load(stream);

			String userName = properties.get("username").toString();
			String password = properties.get("password").toString();
			String driverName = properties.get("driverClassName").toString();
			String url = properties.get("url").toString();*/

			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucien?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8", "root", "");


		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}
}
