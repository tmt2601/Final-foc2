package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dataobject.Category;

public class CategoryDA extends WHConnection {
	public Vector<Category> getCategory() {
		String sql = "SELECT * FROM categories";
		Vector<Category> categoryList = new Vector<>();

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Category cat = new Category();
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("categoryname"));
				categoryList.add(cat);
			}
			return categoryList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return categoryList;
	}

	public DefaultTableModel getCategories() {
		String sql = "SELECT * FROM categories";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			return buildTableModel(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Category getCategory(int id) {
		String sql = "SELECT categoryname FROM categories WHERE id = " + id;
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			// loop through the result set
			if (rs.next()) {
				Category category = new Category();
				category.setName(rs.getString("categoryname"));
				return category;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void insert(String Name) {
		String sql = "INSERT INTO categories (categoryname) VALUES (?)";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(String Name, int id) {
		String sql = "UPDATE categories SET categoryname = ? where id = ?";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
