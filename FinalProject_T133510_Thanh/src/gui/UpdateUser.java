package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import da.BrandDA;
import da.UserDA;
import dataobject.Brand;
import dataobject.User;

public class UpdateUser extends JFrame {
	private UserDA userDA;
	private JTextField txtUsername;
	private JTextField txtpassword;
	private int userid;
	private JTextField txtPassword;

	public UpdateUser(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userid = id;
		userDA = new UserDA();

		unitGUI();

		User b = userDA.getUser(userid);
		txtUsername.setText(b.getUsername());
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(23, 75, 95, 31);
		getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setText((String) null);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBounds(128, 72, 169, 34);
		getContentPane().add(txtPassword);

	}

	public void unitGUI() {
		setTitle("Update User");
		setBounds(650, 200, 337, 218);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(23, 27, 95, 31);
		getContentPane().add(lblNewLabel);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setBounds(128, 24, 169, 34);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(44, 127, 89, 41);
		getContentPane().add(btnSave);

		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancle.setBounds(182, 127, 89, 41);
		getContentPane().add(btnCancle);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				UpdateUser();
				UpdateUser.this.dispose();
				AddUser.getUser();
			}
		});
		btnCancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				UpdateUser.this.dispose();
			}
		});
	}

	private void UpdateUser() {
		String username = txtUsername.getText();
		String password = txtPassword.getText();
		int id = userid;
		userDA.update(username, password, id);
	}
	
}
