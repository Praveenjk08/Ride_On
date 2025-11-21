package com.servlet.Dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.servlet.Db.DatabaseConnection;
import com.servlet.Dto.User;
import com.servlet.dbutil.DbConnection;
import java.sql.Statement;

public class UserDaoImlimaenation implements  UserDao{
	Connection con=null;
	PreparedStatement pst=null;

	
	@Override
	public boolean isRegisterd(User user) {
//		int userId=0;
		
		String register="insert into users(full_name, email, password, phone_number, created_at) values(?,?,?,?,?)";
		
		
		con=DatabaseConnection.givemePower();
		try {
			pst=con.prepareStatement(register);
			pst.setString(1, user.getFullname());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPass());
			pst.setLong(4, user.getPhone());
			LocalDateTime now=LocalDateTime.now();
			pst.setTimestamp(5,java.sql.Timestamp.valueOf(LocalDateTime.now()));
//			pst.setTimestamp(5, java.sql.Timestamp.valueOf(user.getCurrDateTime()));
			int count=pst.executeUpdate();
			
			
			if(count>0) {
				return true;
				
				
				
			}
//			System.out.println("Generated User ID = " + userId);

			// Now forward userId to admin servlet OR session
//			request.getSession().setAttribute("userId", userId);
//			response.sendRedirect("adminRegister.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public User isLogin(String email, String pass) {
		String  login="select * from users where email=? and password=?";
	      con=DatabaseConnection.givemePower();
		User user=null;
		try {
			pst=con.prepareStatement(login);
			pst.setString(1, email);
			pst.setString(2, pass);
			ResultSet res=pst.executeQuery();
			if(res.next())
			{
				user=new User();
				user.setU_id(res.getInt("user_id"));
				user.setFullname(res.getString("full_name"));
				user.setEmail(res.getString("email"));
				user.setPass(res.getString("password"));
				user.setPhone(res.getLong("phone_number"));
				user.setCurrDateTime(res.getTimestamp("created_at"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public List<User> getUserDetails() {
		
		List<User> userlist=new ArrayList<User>();
		User user=null;
		String deatils="select * from users";
		con=DatabaseConnection.givemePower();
		try {
			pst=con.prepareStatement(deatils);
			ResultSet res=pst.executeQuery();
			while (res.next()) {
				user=new User();
//				System.out.println(res.getInt("user_id"));
				user.setU_id(res.getInt("user_id"));
				user.setFullname(res.getString("full_name"));
				user.setEmail(res.getString("email"));
				user.setPass(res.getString("password"));
				user.setPhone(res.getLong("phone_number"));
				user.setCurrDateTime(res.getTimestamp("created_at"));
				userlist.add(user);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userlist;
	}

	@Override
	public boolean isDelete(int uid) {
		String  delete="delete from users where user_id=?";
		con=DatabaseConnection.givemePower();
		try {
			pst=con.prepareStatement(delete);
			pst.setInt(1, uid);
			int count=pst.executeUpdate();
			if(count>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public User findUserById(int empid) {
		String find="select * from users where user_id=?";
		User user=null;
		con=DatabaseConnection.givemePower();
		try {
			pst=con.prepareStatement(find);
			pst.setInt(1, empid);
			ResultSet res=pst.executeQuery();
			if(res.next())
			{
				user=new User();
				user.setU_id(res.getInt("user_id"));
				user.setFullname(res.getString("full_name"));
				user.setEmail(res.getString("email"));
				user.setPass(res.getString("password"));
				user.setPhone(res.getLong("phone_number"));
				user.setCurrDateTime(res.getTimestamp("created_at"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		String update="update users set full_name=?, email=?, password=?, phone_number=? where user_id=?";
		con=DatabaseConnection.givemePower();
		try {
			pst=con.prepareStatement(update);
			pst.setString(1, user.getFullname());
			pst.setString(2,user.getEmail());
			pst.setString(3, user.getPass());
			pst.setLong(4, user.getPhone());
			pst.setInt(5, user.getU_id());
			int count=pst.executeUpdate();
			if(count>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public User getSingleUserDetails(int uid) {
		User user=null;
		String details="select * from users where user_id=? ;";
		con=DatabaseConnection.givemePower();
		try {
			
			pst=con.prepareStatement(details);
			pst.setInt(1, uid);
			ResultSet res=pst.executeQuery();
			if(res.next())
			{
				user=new User();
				user.setU_id(res.getInt("user_id"));
				user.setFullname(res.getString("full_name"));
				user.setEmail(res.getString("email"));
				user.setPass(res.getString("password"));
				user.setPhone(res.getLong("phone_number"));
				user.setCurrDateTime(res.getTimestamp("created_at"));
						 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean udateSingleUserData(User user) {
		String update="update users set full_name=?, email=?, password=?, phone_number=? where user_id=?";
		con=DatabaseConnection.givemePower();
		try {
			pst=con.prepareStatement(update);
			pst.setString(1, user.getFullname());
			pst.setString(2,user.getEmail());
			pst.setString(3, user.getPass());
			pst.setLong(4, user.getPhone());
			pst.setInt(5, user.getU_id());
			int count=pst.executeUpdate();
			if(count>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}

	
	
	

}
