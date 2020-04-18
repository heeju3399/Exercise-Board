package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.user;

public class Con2 {

	private Connection conn = null;
	private PreparedStatement pre = null;
	private String sql = null;
	private boolean flag = false;
	private ResultSet rs = null;
	private DBConnectionMgr pool;

	public Con2() {
		pool = DBConnectionMgr.getInstance();
	}

	public boolean login(user uu) {

		try {
			conn = pool.getConnection();
			sql = " select * from user where userid = ? and userpassword = ?  ";
			pre = conn.prepareStatement(sql);
			pre.setString(1, uu.getUserId());
			pre.setString(2, uu.getUserPass());
			rs = pre.executeQuery();
			if (rs.next())
				flag = true;

		} catch (Exception e) {
			System.out.println("login err:" + e);
		} finally {
			pool.freeConnection(conn, pre);
		}
		return flag;
	}

	public boolean signin(user uu) {

		try {
			conn = pool.getConnection();
			sql = "insert into user values (?,?,?,?,?)";
			pre = conn.prepareStatement(sql);

			pre.setString(1, uu.getUserId());
			pre.setString(2, uu.getUserPass());
			pre.setString(3, uu.getUserName());
			pre.setString(4, uu.getUserGender());
			pre.setString(5, uu.getUserEmail());

			pre.executeUpdate();
			flag = true;

		} catch (Exception e) {
			System.out.println("signin err" + e);
			flag = false;
		} finally {
			pool.freeConnection(conn, pre);
		}
		return flag;

	}

}
