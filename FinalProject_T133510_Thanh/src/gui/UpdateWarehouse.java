package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import da.WarehouseDA;
import dataobject.Brand;
import dataobject.Category;
import dataobject.Product;
import dataobject.UnitOfMeasure;
import dataobject.Warehouse;

public class UpdateWarehouse extends JFrame {
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtDescription;
	private WarehouseDA warehouseDA;
	private int warehouseID = 1;

	public UpdateWarehouse(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		warehouseID = id;

		unitGUI();
		Warehouse w = warehouseDA.getWarehouse(warehouseID);
		txtName.setText(w.getName());
		txtAddress.setText(w.getAddress());
		txtDescription.setText(w.getDescription());
	}

	public void unitGUI() {
		setTitle("Update Warehouse");
		setBounds(300, 200, 376, 391);
		getContentPane().setLayout(null);

		JLabel lblUpdateWarehouse = new JLabel("Update Warehouse");
		lblUpdateWarehouse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUpdateWarehouse.setBounds(89, 11, 210, 38);
		getContentPane().add(lblUpdateWarehouse);

		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(21, 67, 74, 14);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Address");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(21, 107, 74, 14);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Desciption");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(21, 193, 74, 14);
		getContentPane().add(label_3);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setColumns(10);
		txtName.setBounds(126, 60, 210, 30);
		getContentPane().add(txtName);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAddress.setColumns(10);
		txtAddress.setBounds(126, 101, 210, 81);
		getContentPane().add(txtAddress);

		txtDescription = new JTextField();
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDescription.setColumns(10);
		txtDescription.setBounds(126, 193, 210, 89);
		getContentPane().add(txtDescription);

		JButton button = new JButton("Save");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(64, 306, 89, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("Cancle");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(208, 306, 89, 23);
		getContentPane().add(button_1);
	}

	private void updateProduct() {
		String wName = txtName.getText();
		String address = txtAddress.getText();
		String description = txtDescription.getText();
		int id = warehouseID;

		warehouseDA.update(wName, address, description, id);
	}
}
