package da;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import dataobject.User;

public class UserDA extends WHConnection {

	public Vector<User> getAllUsers() {
		String sql = "SELECT * FROM user";
		Vector<User> userList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				User user = new User(); 
					rs.getInt("id");
					rs.getString("username");
				    rs.getString("password");
					rs.getBoolean("active");
				userList.add(user);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return userList;
	}

	public User getUser(int id) {
		String sql = "SELECT username, password, active FROM user WHERE id = " + id;
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return null;
	}

	public DefaultTableModel getUser() {
		String sql = "SELECT * FROM user";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			return buildTableModel(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void insert(String username, String password) {
		String spl = "INSERT INTO user(username, password)" + "VALUES(?, ?)";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(spl)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	public void update(String username, String password, int id) {
		String sql = "UPDATE user SET username = ?, password = ? WHERE id = ?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
}