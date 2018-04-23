package com.yash.addressbook.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.yash.addressbook.dao.UserDAO;
import com.yash.addressbook.model.User;
import com.yash.addressbook.util.JNDIDBUtil;

@Repository
public class UserDAOImpl implements UserDAO {
	private Logger logger = Logger.getLogger(UserDAOImplTest.class);

	@Override
	public int insert(User user) {
		logger.info("Insert method Called");
		int status = 0;
		String sql = "INSERT INTO users(name,email,contact) VALUES(?,?,?)";
		PreparedStatement pstmt = JNDIDBUtil.getPreparedStatement(sql);
		try {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getContact());
			status = pstmt.executeUpdate();
			logger.info("Query Executed");
			JNDIDBUtil.closeStatement(pstmt);
		} catch (SQLException e) {
			logger.error("Error in Insert Querry of UserDAOImpl  " + e);
		}
		return status;
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("getAllUsers method Called");
		List<User> users = null;
		String sql = "SELECT * FROM users";
		PreparedStatement pstmt = JNDIDBUtil.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			users = new ArrayList<>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setContact(rs.getString("conatct"));
				users.add(user);
			}
			logger.info("Query Executed");
			JNDIDBUtil.closeStatement(pstmt);
		} catch (SQLException e) {
			logger.error("Error in ListAllUsers Query in UserDAOImpl  " + e);
		} finally {
			if(rs!=null)
			try {
				rs.close();
			} catch (SQLException | NullPointerException e) {
				logger.error("Error in closing ResultSet  " + e);
			}
		}
		return users;
	}

}
