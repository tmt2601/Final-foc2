package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dataobject.Brand;

public class BrandDA extends WHConnection{
	
	public Vector<Brand> getBrand() {
		String sql = "SELECT * FROM brand";
		Vector<Brand> brandList = new Vector<>();

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Brand bra = new Brand();
				bra.setId(rs.getInt("id"));
				bra.setName(rs.getString("brandname"));
				brandList.add(bra);
			}
			return brandList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return brandList;
	}
	
	public DefaultTableModel getBrands() {
		String sql = "SELECT * FROM brand";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			return buildTableModel(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public Brand getBrand(int id) {
		String sql = "SELECT brandname FROM brand WHERE id = " + id;
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			// loop through the result set
			if (rs.next()) {
				Brand brand = new Brand();
				brand.setName(rs.getString("brandname"));
				return brand;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void insert(String bName) {
		String sql = "INSERT INTO brand (brandname) VALUES (?)";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, bName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void update(String bName, int id) {
		String sql = "UPDATE brand SET brandname = ? where id = ?";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, bName);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
