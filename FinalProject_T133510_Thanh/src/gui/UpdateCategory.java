package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import da.CategoryDA;
import dataobject.Category;

public class UpdateCategory extends JFrame {
	private CategoryDA categoryDA;
	private JTextField txtName;
	private int categoryid;

	public UpdateCategory(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		categoryid = id;

		categoryDA = new CategoryDA();

		unitGUI();
		// Điền dữ liệu vào textfield
		Category c = categoryDA.getCategory(categoryid);
		txtName.setText(c.getName());

	}

	public void unitGUI() {
		setTitle("Edit Category");
		setBounds(300, 200, 300, 182);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Category Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 27, 122, 31);
		getContentPane().add(lblNewLabel);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setBounds(155, 24, 95, 34);
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
				UpdateCategory();
				UpdateCategory.this.dispose();
				AddCategory.getCateList();
			}
		});
		btnCancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateCategory.this.dispose();
			}
		});
	}

	private void UpdateCategory() {
		String Name = txtName.getText();
		int id = categoryid;
		categoryDA.update(Name, id);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCategory form = new UpdateCategory(1);
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
