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

import da.ProductDA;
import da.WarehouseDA;

public class WarehouseList extends JFrame {
	private static JTable table;
	private static WarehouseDA warehouseDA;

	public WarehouseList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Warehouse List");
		setBounds(200, 150, 553, 355);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 520, 237);
		getContentPane().add(scrollPane);
		warehouseDA = new WarehouseDA();
		DefaultTableModel model = warehouseDA.getWarehouses();
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(10, 11, 148, 34);
		getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(200, 11, 148, 34);
		getContentPane().add(btnUpdate);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancle.setBounds(399, 11, 131, 34);
		getContentPane().add(btnCancle);
		
		// ActionListener
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addWarehouse();
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnCancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				WarehouseList.this.dispose();
			}
		});
	}
	public static void getWHList() {
		warehouseDA = new WarehouseDA();
		DefaultTableModel model = warehouseDA.getWarehouses();
		table.setModel(model);
	}

	private void updateProduct() {
		// Lấy số thứ tự của dòng đang được chọn
		int selectedRowIndex = table.getSelectedRow();
		if (selectedRowIndex != -1) { // Nếu có dòng được chọn (không có chọn dòng nào thì trả về -1
			// Lấy giá trị của một cột nào đó trong dòng được chọn (trường hợp này là lấy
			// cột 0, chứa productid)
			int selectedProductID = (int) table.getModel().getValueAt(selectedRowIndex, 0);
			// Hiển thị giao diện update cho sản phẩm có mã được chọn
			UpdateWarehouse form = new UpdateWarehouse(selectedProductID);
			form.setVisible(true);
			// TODO: tìm hiểu cách hiển thị danh sách sản phẩm sau khi cập nhật
		}
	}

	private void addWarehouse() {
		AddWarehouse form = new AddWarehouse();
		form.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarehouseList form = new WarehouseList();
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
