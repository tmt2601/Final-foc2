/**
 * 
 */
package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import da.WHConnection;

/**
 * @author Minh Thanh
 *
 */
public class Login extends JFrame implements ActionListener {
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnLogin;
	private JButton btnCancle;
	private WHConnection whconnection;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login");
		setBounds(700, 300, 363, 302);
		getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(132, 22, 95, 40);
		getContentPane().add(lblLogin);

		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(33, 103, 80, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(33, 144, 80, 14);
		getContentPane().add(lblNewLabel_1);

		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUser.setBounds(151, 96, 164, 30);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPass.setBounds(151, 137, 164, 30);
		getContentPane().add(txtPass);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(68, 192, 89, 35);
		getContentPane().add(btnLogin);
		btnLogin.addActionListener(this);

		btnCancle = new JButton("Cancle");
		btnCancle.setBounds(199, 192, 89, 35);
		getContentPane().add(btnCancle);
		btnCancle.addActionListener(this);

	}

	protected Connection connect() {
		String url = "jdbc:sqlite:foc2warehouse.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnLogin) {

			String username = txtUser.getText();
			String password = txtPass.getText();

			if (txtUser.getText().equals("") || txtPass.getText().equals("")) {
				JOptionPane.showMessageDialog(Login.this, "Username and password must not empty.", "Invalid",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				ResultSet res = connect().createStatement()
						.executeQuery(String.format("select * from User where username = '%s' and password = '%s'",
								txtUser.getText(), new String(txtPass.getPassword())));
				if (res != null) {
					if (res.next()) {
						if (res.getString("Password").equals(new String(txtPass.getPassword()))) {
							JOptionPane.showMessageDialog(Login.this, "You has been login successful.",
									"login successfuly", JOptionPane.INFORMATION_MESSAGE);

							WarehouseManagement form = new WarehouseManagement();
							form.setVisible(true);
							Login.this.dispose();

						} else {
							JOptionPane.showMessageDialog(Login.this, "Password is match case.", "Login failed",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(Login.this, "Wrong username or password.", "Login failed",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		} else if (e.getSource() == btnCancle) {
			Login.this.dispose();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login form = new Login();
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
