package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import da.BrandDA;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBrand extends JFrame {
	private static JTable table;
	private JTextField txtBrand;
	private static BrandDA brandDA;

	public AddBrand() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Brand");
		setBounds(200, 150, 454, 355);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 418, 192);
		getContentPane().add(scrollPane);
		brandDA = new BrandDA();
		DefaultTableModel model = brandDA.getBrands();

		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Brand Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 97, 34);
		getContentPane().add(lblNewLabel);

		txtBrand = new JTextField();
		txtBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBrand.setBounds(102, 11, 199, 34);
		getContentPane().add(txtBrand);
		txtBrand.setColumns(10);

		JButton btnAddBrand = new JButton("Add Brand");
		btnAddBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddBrand.setBounds(311, 10, 117, 34);
		getContentPane().add(btnAddBrand);

		JButton btnEdit = new JButton("Update");
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
				addBrand();
				getBrandList();
				txtBrand.setText(null);
			}
		});
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				editBrand();
			}
		});
		btnCancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddBrand.this.dispose();
			}
		});

	}

	public static void getBrandList() {
		brandDA = new BrandDA();
		DefaultTableModel model = brandDA.getBrands();
		table.setModel(model);
	}

	private void addBrand() {
		String bName = txtBrand.getText();
		brandDA.insert(bName);
	}

	private void editBrand() {
		// Lấy số thứ tự của dòng đang được chọn
		int selectedRowIndex = table.getSelectedRow();
		if (selectedRowIndex != -1) { // Nếu có dòng được chọn (không có chọn dòng nào thì trả về -1
			// Lấy giá trị của một cột nào đó trong dòng được chọn (trường hợp này là lấy
			// cột 0, chứa productid)
			int selectedBrandID = (int) table.getModel().getValueAt(selectedRowIndex, 0);
			// Hiển thị giao diện update cho sản phẩm có mã được chọn
			UpdateBrand form = new UpdateBrand(selectedBrandID);
			form.setVisible(true);
			// TODO: tìm hiểu cách hiển thị danh sách sản phẩm sau khi cập nhật
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBrand form = new AddBrand();
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
