package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dataobject.UnitOfMeasure;

public class UnitOfMeasureDA extends WHConnection{
	public Vector<UnitOfMeasure> getUnitOfMeasures() {
		String sql = "SELECT * FROM unitofmeasure";
		Vector<UnitOfMeasure> unitofmeasureList = new Vector<>();

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				UnitOfMeasure unt = new UnitOfMeasure();
				unt.setId(rs.getInt("id"));
				unt.setName(rs.getString("unitname"));
				unitofmeasureList.add(unt);
			}
			return unitofmeasureList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return unitofmeasureList;
	}
	public DefaultTableModel getUnitOfMeasure() {
		String sql = "SELECT * FROM unitofmeasure";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			return buildTableModel(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public UnitOfMeasure getUnitOfMeasure(int id) {
		String sql = "SELECT unitname FROM unitofmeasure WHERE id = " + id;
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			// loop through the result set
			if (rs.next()) {
				UnitOfMeasure unit = new UnitOfMeasure();
				unit.setName(rs.getString("unitname"));
				return unit;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void insert(String Name) {
		String sql = "INSERT INTO unitofmeasure (unitname) VALUES (?)";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(String Name, int id) {
		String sql = "UPDATE unitofmeasure SET unitname = ? where id = ?";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}

