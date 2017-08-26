package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import da.BrandDA;
import dataobject.Brand;

public class UpdateBrand extends JFrame {
	private BrandDA brandDA;
	private JTextField txtName;
	private int brandid;

	public UpdateBrand(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		brandid = id;

		brandDA = new BrandDA();

		unitGUI();
		// Điền dữ liệu vào textfield
		Brand b = brandDA.getBrand(brandid);
		txtName.setText(b.getName());

	}

	public void unitGUI() {
		setTitle("Update Brand");
		setBounds(300, 200, 300, 182);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Brand Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 27, 95, 31);
		getContentPane().add(lblNewLabel);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setBounds(128, 24, 122, 34);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(23, 93, 89, 23);
		getContentPane().add(btnSave);

		JButton btnCancle = new JButton("Cancle");
		btnCancle.setBounds(161, 93, 89, 23);
		getContentPane().add(btnCancle);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateBrand();
				UpdateBrand.this.dispose();
				AddBrand.getBrandList();
			}
		});
		btnCancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateBrand.this.dispose();
			}
		});
	}

	private void updateBrand() {
		String Name = txtName.getText();
		int id = brandid;
		brandDA.update(Name, id);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBrand form = new UpdateBrand(1);
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
