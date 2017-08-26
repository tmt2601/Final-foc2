/**
 * 
 */
package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import da.ProductDA;

/**
 * @author US
 *
 */
public class ProductList extends JFrame {
	private JPanel getContentPane;
	private static JTable table;
	private static ProductDA productDA;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnCancle;

	public ProductList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("List");
		setBounds(200, 150, 800, 496);
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getContentPane);
		productDA = new ProductDA();
		DefaultTableModel model = productDA.getProducts();
		getContentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 57, 759, 389);
		getContentPane.add(scrollPane);
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(15, 11, 119, 35);
		getContentPane.add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(149, 11, 122, 35);
		getContentPane.add(btnUpdate);
		
		btnCancle = new JButton("Cancle");
		btnCancle.setBounds(652, 11, 122, 35);
		getContentPane.add(btnCancle);
		
		// Add ActionListener
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateProduct();
			}
		});
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addProduct();
			}
		});
		btnCancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProductList.this.dispose();
			}
		});
	}

	public static void getProductList() {
		productDA = new ProductDA();
		DefaultTableModel model = productDA.getProducts();
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
			UpdateProduct updateGUI = new UpdateProduct(selectedProductID);
			updateGUI.setVisible(true);
			// TODO: tìm hiểu cách hiển thị danh sách sản phẩm sau khi cập nhật
		}
	}

	private void addProduct() {
		AddProduct addGui = new AddProduct();
		addGui.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList form = new ProductList();
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
