package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import da.BrandDA;
import da.CategoryDA;
import da.ProductDA;
import da.UnitOfMeasureDA;
import dataobject.Brand;
import dataobject.Category;
import dataobject.UnitOfMeasure;

/**
 * 
 */

/**
 * @author US
 *
 */
public class AddProduct extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtProductCode;
	private JTextField txtUnitPrice;
	private JTextField txtDescription;

	private ProductDA productDA;
	private CategoryDA categoryDA;
	private BrandDA brandDA;
	private UnitOfMeasureDA unitDA;

	private JButton btnAdd;
	private JButton btnCancle;
	private JComboBox<Category> cmbCategory;
	private JComboBox<Brand> cmbBrand;
	private JComboBox<UnitOfMeasure> cmbUnitOfMeasure;

	public AddProduct() {

		productDA = new ProductDA();
		categoryDA = new CategoryDA();
		brandDA = new BrandDA();
		unitDA = new UnitOfMeasureDA();

		unitGUI();
	}

	private void unitGUI() {
		setResizable(false);
		setTitle("Add Product - TMT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 350, 405);
		getContentPane().setLayout(null);

		JLabel lblProductCode = new JLabel("Product Code");
		lblProductCode.setBounds(10, 28, 128, 14);
		getContentPane().add(lblProductCode);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 64, 128, 14);
		getContentPane().add(lblName);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(10, 100, 128, 14);
		getContentPane().add(lblCategory);

		JLabel lblUnitOfMeasure = new JLabel("Unit Of Measure");
		lblUnitOfMeasure.setBounds(10, 169, 128, 14);
		getContentPane().add(lblUnitOfMeasure);

		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(10, 134, 128, 14);
		getContentPane().add(lblBrand);

		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setBounds(10, 206, 128, 14);
		getContentPane().add(lblUnitPrice);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 242, 128, 14);
		getContentPane().add(lblDescription);

		txtProductCode = new JTextField();
		txtProductCode.setColumns(10);
		txtProductCode.setBounds(149, 25, 170, 20);
		getContentPane().add(txtProductCode);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(149, 61, 170, 20);
		getContentPane().add(txtName);

		cmbCategory = new JComboBox();
		cmbCategory.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Category cat = (Category) cmbCategory.getSelectedItem();
			}
		});
		Vector<Category> categoryList = categoryDA.getCategory();
		cmbCategory.setModel(new DefaultComboBoxModel(categoryList));
		cmbCategory.setBounds(148, 97, 171, 20);
		getContentPane().add(cmbCategory);

		cmbUnitOfMeasure = new JComboBox();
		cmbUnitOfMeasure.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				UnitOfMeasure unt = (UnitOfMeasure) cmbUnitOfMeasure.getSelectedItem();
			}
		});
		Vector<UnitOfMeasure> unitofmeasureList = unitDA.getUnitOfMeasures();
		cmbUnitOfMeasure.setModel(new DefaultComboBoxModel(unitofmeasureList));

		cmbUnitOfMeasure.setBounds(148, 166, 171, 20);
		getContentPane().add(cmbUnitOfMeasure);

		cmbBrand = new JComboBox();
		cmbBrand.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Brand bra = (Brand) cmbBrand.getSelectedItem();
			}
		});
		Vector<Brand> brandList = brandDA.getBrand();
		cmbBrand.setModel(new DefaultComboBoxModel(brandList));
		cmbBrand.setBounds(148, 131, 171, 20);
		getContentPane().add(cmbBrand);

		txtUnitPrice = new JTextField();
		txtUnitPrice.setBounds(149, 203, 170, 20);
		getContentPane().add(txtUnitPrice);
		txtUnitPrice.setColumns(10);

		txtDescription = new JTextField();
		txtDescription.setBounds(149, 239, 170, 76);
		getContentPane().add(txtDescription);
		txtDescription.setColumns(10);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(60, 326, 89, 23);
		getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);

		btnCancle = new JButton("Cancle");
		btnCancle.setBounds(174, 326, 89, 23);
		getContentPane().add(btnCancle);
		btnCancle.addActionListener(this);
	}

	/**
	 * @param args
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnAdd) {
			addProduct();
			AddProduct.this.dispose();
			ProductList.getProductList();
		} else if (e.getSource() == btnCancle) {
			AddProduct.this.dispose();
		}
	}

	private void addProduct() {
		String pCode = txtProductCode.getText();
		String pName = txtName.getText();
		Category selectedCate = (Category) cmbCategory.getSelectedItem();
		int categoryid = selectedCate.getId();
		Brand selectedBrand = (Brand) cmbBrand.getSelectedItem();
		int brandid = selectedBrand.getId();
		UnitOfMeasure selectedUnit = (UnitOfMeasure) cmbUnitOfMeasure.getSelectedItem();
		int unitofmeasureid = selectedUnit.getId();
		double pPrice = Double.parseDouble(txtUnitPrice.getText());
		String pDescription = txtDescription.getText();

		productDA.insert(pCode, pName, categoryid, brandid, unitofmeasureid, pPrice, pDescription);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct form = new AddProduct();
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
