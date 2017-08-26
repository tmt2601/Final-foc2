package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import da.WarehouseDA;

public class AddWarehouse extends JFrame {
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtDescription;
	private WarehouseDA warehouseDA;

	public AddWarehouse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Warehouse");
		setBounds(300, 200, 376, 391);
		getContentPane().setLayout(null);

		JLabel lblAddWarehouse = new JLabel("Add Warehouse");
		lblAddWarehouse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddWarehouse.setBounds(90, 11, 171, 38);
		getContentPane().add(lblAddWarehouse);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 67, 74, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(23, 107, 74, 14);
		getContentPane().add(lblAddress);

		JLabel lblDesciption = new JLabel("Desciption");
		lblDesciption.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesciption.setBounds(23, 193, 74, 14);
		getContentPane().add(lblDesciption);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setBounds(128, 60, 210, 30);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAddress.setColumns(10);
		txtAddress.setBounds(128, 101, 210, 81);
		getContentPane().add(txtAddress);

		txtDescription = new JTextField();
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDescription.setColumns(10);
		txtDescription.setBounds(128, 193, 210, 89);
		getContentPane().add(txtDescription);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(60, 306, 89, 23);
		getContentPane().add(btnSave);

		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancle.setBounds(204, 306, 89, 23);
		getContentPane().add(btnCancle);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addWarehouse();
				WarehouseList.getWHList();
			}
		});
		btnCancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddWarehouse.this.dispose();
			}
		});
	}

	private void addWarehouse() {
		String name = txtName.getText();
		String address = txtAddress.getText();
		String description = txtDescription.getText();

		warehouseDA.insert(name, address, description);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWarehouse form = new AddWarehouse();
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
