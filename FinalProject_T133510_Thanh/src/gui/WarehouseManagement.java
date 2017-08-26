/**
 * 
 */
package gui;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Minh Thanh
 *
 */
public class WarehouseManagement extends JFrame {
	public WarehouseManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Warehouse Management - Thanh");
		setBounds(100, 100, 452, 335);
		getContentPane().setLayout(null);

		JButton btnProduct = new JButton("Product");
		btnProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProduct.setBounds(25, 23, 161, 47);
		getContentPane().add(btnProduct);
		
		JButton btnCategory = new JButton("Category");
		btnCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCategory.setBounds(25, 92, 161, 47);
		getContentPane().add(btnCategory);
		
		JButton btnBrand = new JButton("Brand");
		btnBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBrand.setBounds(25, 159, 161, 47);
		getContentPane().add(btnBrand);
		
		JButton btnUnitOfMeasure = new JButton("Unit Of Measure");
		btnUnitOfMeasure.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUnitOfMeasure.setBounds(25, 226, 161, 47);
		getContentPane().add(btnUnitOfMeasure);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInventory.setBounds(257, 23, 161, 47);
		getContentPane().add(btnInventory);
		
		JButton btnWarehouse = new JButton("Warehouse");
		btnWarehouse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnWarehouse.setBounds(257, 92, 161, 47);
		getContentPane().add(btnWarehouse);
		
		JButton btnUser = new JButton("User");
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUser.setBounds(257, 159, 161, 47);
		getContentPane().add(btnUser);
		
		// ActionListener
		btnProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProductList form = new ProductList();
				form.setVisible(true);
			}
		});
		btnCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddCategory form = new AddCategory();
				form.setVisible(true);
			}
		});
		btnBrand.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddBrand form = new AddBrand();
				form.setVisible(true);
			}
		});
		btnUnitOfMeasure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddUnitOfMeasure form = new AddUnitOfMeasure();
				form.setVisible(true);
			}
		});
		btnWarehouse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				WarehouseList form = new WarehouseList();
				form.setVisible(true);
			}
		});
		btnUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddUser form = new AddUser();
				form.setVisible(true);
			}
		});
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarehouseManagement form = new WarehouseManagement();
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
