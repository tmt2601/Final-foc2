package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dataobject.Warehouse;

public class WarehouseDA extends WHConnection {

	public Vector<Warehouse> getWareHouses() {
		String sql = "SELECT * FROM warehouse";
		Vector<Warehouse> whouseList = new Vector<>();

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Warehouse wh = new Warehouse();
				wh.setId(rs.getInt("id"));
				wh.setName(rs.getString("warehousename"));
				wh.setAddress(rs.getString("address"));
				wh.setDescription(rs.getString("description"));

				whouseList.add(wh);
			}
			return whouseList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return whouseList;
	}

	public DefaultTableModel getWarehouses() {
		String sql = "SELECT * FROM warehouse";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			return buildTableModel(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Warehouse getWarehouse(int id) {
		String sql = "SELECT warehousename, address, description FROM warehouse WHERE id = " + id;
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				Warehouse who = new Warehouse();
				who.setName(rs.getString("warehousename"));
				who.setAddress(rs.getString("address"));
				who.setDescription(rs.getString("description"));

				return who;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void insert(String whousename, String address, String description) {
		String sql = "INSERT INTO warehouse (warehousename, address, description) VALUES (?, ? , ?)";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, whousename);
			pstmt.setString(2, address);
			pstmt.setString(3, description);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(String whouesname, String address, String description, int id) {
		String sql = "UPDATE warehouse SET warehousename = ?, address = ?, description = ? WHERE id = ?";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, whouesname);
			pstmt.setString(2, address);
			pstmt.setString(3, description);
			pstmt.setInt(4, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
