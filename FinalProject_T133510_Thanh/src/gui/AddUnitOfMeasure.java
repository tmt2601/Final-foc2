package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import da.UnitOfMeasureDA;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUnitOfMeasure extends JFrame {
	private static JTable table;
	private JTextField txtUnit;
	private static UnitOfMeasureDA unitDA;

	public AddUnitOfMeasure() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Unit Of Measure");
		setBounds(200, 150, 454, 355);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 418, 192);
		getContentPane().add(scrollPane);
		unitDA = new UnitOfMeasureDA();
		DefaultTableModel model = unitDA.getUnitOfMeasure();

		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Unit Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 97, 34);
		getContentPane().add(lblNewLabel);

		txtUnit = new JTextField();
		txtUnit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUnit.setBounds(102, 11, 199, 34);
		getContentPane().add(txtUnit);
		txtUnit.setColumns(10);

		JButton btnAddBrand = new JButton("Add Unit");
		btnAddBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddBrand.setBounds(311, 10, 117, 34);
		getContentPane().add(btnAddBrand);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(61, 271, 117, 34);
		getContentPane().add(btnUpdate);

		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancle.setBounds(256, 271, 117, 34);
		getContentPane().add(btnCancle);

		// ActionListener
		btnAddBrand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addUnit();
				getUnitList();
				txtUnit.setText(null);
			}
		});
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateUnit();
			}
		});
		btnCancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddUnitOfMeasure.this.dispose();
			}
		});

	}

	public static void getUnitList() {
		unitDA = new UnitOfMeasureDA();
		DefaultTableModel model = unitDA.getUnitOfMeasure();
		table.setModel(model);
	}

	private void addUnit() {
		String uName = txtUnit.getText();
		unitDA.insert(uName);
	}

	private void updateUnit() {
		// Lấy số thứ tự của dòng đang được chọn
		int selectedRowIndex = table.getSelectedRow();
		if (selectedRowIndex != -1) { // Nếu có dòng được chọn (không có chọn dòng nào thì trả về -1
			// Lấy giá trị của một cột nào đó trong dòng được chọn (trường hợp này là lấy
			// cột 0, chứa productid)
			int selectedUnitID = (int) table.getModel().getValueAt(selectedRowIndex, 0);
			// Hiển thị giao diện update cho sản phẩm có mã được chọn
			UpdateUnitOfMeasure form = new UpdateUnitOfMeasure(selectedUnitID);
			form.setVisible(true);
			// TODO: tìm hiểu cách hiển thị danh sách sản phẩm sau khi cập nhật
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUnitOfMeasure frame = new AddUnitOfMeasure();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
