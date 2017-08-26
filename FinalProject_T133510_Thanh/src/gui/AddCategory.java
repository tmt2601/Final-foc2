package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import da.CategoryDA;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCategory extends JFrame {
	private static JTable table;
	private JTextField txtCategory;
	private static CategoryDA categoryDA;

	public AddCategory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Category");
		setBounds(200, 150, 454, 355);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 418, 192);
		getContentPane().add(scrollPane);
		categoryDA = new CategoryDA();
		DefaultTableModel model = categoryDA.getCategories();

		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Category Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 118, 34);
		getContentPane().add(lblNewLabel);

		txtCategory = new JTextField();
		txtCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCategory.setBounds(138, 11, 143, 34);
		getContentPane().add(txtCategory);
		txtCategory.setColumns(10);

		JButton btnAddBrand = new JButton("Add Category");
		btnAddBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddBrand.setBounds(291, 10, 137, 34);
		getContentPane().add(btnAddBrand);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(61, 271, 117, 34);
		getContentPane().add(btnEdit);

		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancle.setBounds(256, 271, 117, 34);
		getContentPane().add(btnCancle);

		// ActionListener
		btnAddBrand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addCategory();
				getCateList();
				txtCategory.setText(null);
			}
		});
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				editCategory();
			}
		});
		btnCancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddCategory.this.dispose();
			}
		});

	}

	public static void getCateList() {
		categoryDA = new CategoryDA();
		DefaultTableModel model = categoryDA.getCategories();
		table.setModel(model);
	}

	private void addCategory() {
		String Name = txtCategory.getText();
		categoryDA.insert(Name);
	}

	private void editCategory() {
		// Lấy số thứ tự của dòng đang được chọn
		int selectedRowIndex = table.getSelectedRow();
		if (selectedRowIndex != -1) { // Nếu có dòng được chọn (không có chọn dòng nào thì trả về -1
			// Lấy giá trị của một cột nào đó trong dòng được chọn (trường hợp này là lấy
			// cột 0, chứa productid)
			int selectedBrandID = (int) table.getModel().getValueAt(selectedRowIndex, 0);
			// Hiển thị giao diện update cho sản phẩm có mã được chọn
			UpdateCategory form = new UpdateCategory(selectedBrandID);
			form.setVisible(true);
			// TODO: tìm hiểu cách hiển thị danh sách sản phẩm sau khi cập nhật
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCategory form = new AddCategory();
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
