package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import da.UserDA;
import javax.swing.JPasswordField;

public class AddUser extends JFrame {
	private static JTable table;
	private JTextField txtUser;
	private static UserDA userDA;
	private JButton btnUpdateUser;
	private JPasswordField txtPassword;

	public AddUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ADD USER");
		setBounds(200, 150, 454, 426);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 418, 181);
		getContentPane().add(scrollPane);
		userDA = new UserDA();
		DefaultTableModel model = userDA.getUser();

		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserName.setBounds(36, 11, 97, 34);
		getContentPane().add(lblUserName);

		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUser.setBounds(161, 11, 199, 34);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);

		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddUser.setBounds(243, 105, 117, 34);
		getContentPane().add(btnAddUser);

		btnUpdateUser = new JButton("Update");
		btnUpdateUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdateUser.setBounds(63, 342, 117, 34);
		getContentPane().add(btnUpdateUser);

		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancle.setBounds(258, 342, 117, 34);
		getContentPane().add(btnCancle);

		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(36, 59, 97, 34);
		getContentPane().add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(161, 60, 199, 34);
		getContentPane().add(txtPassword);

		btnAddUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				addUser();
				getUser();
				txtUser.setText(null);
			}
		});
		btnUpdateUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				updateUser();
			}
		});
		btnCancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				AddUser.this.dispose();
			}
		});

	}

	public static void getUser() {
		userDA = new UserDA();
		DefaultTableModel model = userDA.getUser();
		table.setModel(model);
	}

	private void addUser() {
		String username = txtUser.getText();
		String password = txtPassword.getText();
		userDA.insert(username, password);
	}

	private void updateUser() {

		int selectedRowIndex = table.getSelectedRow();
		if (selectedRowIndex != -1) {
			int selectedUserID = (int) table.getModel().getValueAt(selectedRowIndex, 0);

			UpdateUser form = new UpdateUser(selectedUserID);
			form.setVisible(true);

		}
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
