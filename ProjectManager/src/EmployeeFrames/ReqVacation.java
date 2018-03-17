package EmployeeFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import projectClasses.*;

public class ReqVacation extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReqVacation frame = new ReqVacation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReqVacation() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(128, 25, 172, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 77, 172, 39);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 129, 172, 39);
		getContentPane().add(textField_2);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(46, 36, 70, 16);
		getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(46, 88, 70, 16);
		getContentPane().add(lblEndDate);
		
		JLabel lblEmployeeid = new JLabel("EmployeeID");
		lblEmployeeid.setBounds(46, 140, 70, 16);
		getContentPane().add(lblEmployeeid);
		
		JButton btnRequest = new JButton("Request");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vacation req = new Vacation();
				req.setSD(Integer.parseInt(textField.getText()));
				req.setED(Integer.parseInt(textField_1.getText()));
				req.setEmployeeId(Integer.parseInt(textField_2.getText()));
				req.addRequestVacation();
			}
		});
		btnRequest.setBounds(135, 330, 165, 46);
		getContentPane().add(btnRequest);
		
		JTextArea txtrYourExecuse = new JTextArea();
		txtrYourExecuse.setText("your execuse");
		txtrYourExecuse.setBounds(12, 178, 410, 135);
		getContentPane().add(txtrYourExecuse);

	}
}
