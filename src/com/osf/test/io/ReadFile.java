package com.osf.test.io;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class ReadFile {

	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;
	private static final String CLASSNAME;
	static {
		InputStream is = ReadFile.class.getResourceAsStream
				("/com/osf/test/config/db.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		URL = prop.getProperty("url");
		USER = prop.getProperty("user");
		PASSWORD = prop.getProperty("password");
		CLASSNAME = prop.getProperty("classname");
	}
	private static Connection con = null;

	public static void main(String[] args) {
		System.out.println(URL);
		System.out.println(USER);
		System.out.println(PASSWORD);
		System.out.println(CLASSNAME);
	}
}
