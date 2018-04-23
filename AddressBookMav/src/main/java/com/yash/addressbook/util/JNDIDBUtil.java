package com.yash.addressbook.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class JNDIDBUtil {
	
	private static Logger logger = Logger.getLogger(JNDIDBUtil.class);
	private static Context ctx = null;
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	
	static {
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
			con = ds.getConnection();
			logger.info("JNDI LookUp Done Connection Object Obtained " + con);
		} catch (NamingException | SQLException e) {
			logger.error(e);
		}
	}

	private JNDIDBUtil() {

	}

	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			logger.error("Error in Creating preparedStatement  " + e);
		}
		return pstmt;
	}

	public static void closeStatement(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			logger.error("Error in Closing preparedStatement  " + e);
		}
	}
}
