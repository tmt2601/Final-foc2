package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import da.UnitOfMeasureDA;
import dataobject.UnitOfMeasure;;

public class UpdateUnitOfMeasure extends JFrame {
	private UnitOfMeasureDA unitDA;
	private JTextField txtName;
	private int unitid;

	public UpdateUnitOfMeasure(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		unitid = id;

		unitDA = new UnitOfMeasureDA();

		unitGUI();
		// Điền dữ liệu vào textfield
		UnitOfMeasure b = unitDA.getUnitOfMeasure(unitid);
		txtName.setText(b.getName());

	}

	public void unitGUI() {
		setTitle("Edit Unit Of Measure");
		setBounds(300, 200, 300, 182);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Unit Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 27, 95, 31);
		getContentPane().add(lblNewLabel);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setBounds(128, 24, 122, 34);
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
				updateUnit();
				UpdateUnitOfMeasure.this.dispose();
				AddUnitOfMeasure.getUnitList();
			}
		});
		btnCancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateUnitOfMeasure.this.dispose();
			}
		});
	}

	private void updateUnit() {
		String Name = txtName.getText();
		int id = unitid;
		unitDA.update(Name, id);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUnitOfMeasure form = new UpdateUnitOfMeasure(1);
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
