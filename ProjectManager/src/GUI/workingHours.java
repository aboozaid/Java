package GUI;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import projectClasses.FileManger;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class workingHours {

	public JFrame frame;
	private JTextField txtHours;
	private JTextField txtMins;
	private JTextField textField2_empId;
	private JLabel lblEmployeeId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					workingHours window = new workingHours();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public workingHours() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(Color.decode("#144e83"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtHours = new JTextField();
		txtHours.setText("hours");
		txtHours.setBounds(148, 56, 79, 29);
		frame.getContentPane().add(txtHours);
		txtHours.setColumns(10);
		
		JLabel lblEntryTime = new JLabel("Entry Time");
		lblEntryTime.setBackground(Color.WHITE);
		lblEntryTime.setBounds(51, 62, 73, 16);
		frame.getContentPane().add(lblEntryTime);
		
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.setBounds(160, 196, 133, 29);
		frame.getContentPane().add(btnSubmit);
		
		txtMins = new JTextField();
		txtMins.setText("mins");
		txtMins.setBounds(243, 56, 79, 29);
		frame.getContentPane().add(txtMins);
		txtMins.setColumns(10);
		
		textField2_empId = new JTextField();
		textField2_empId.setText("Employee ID");
		textField2_empId.setBounds(148, 98, 174, 22);
		frame.getContentPane().add(textField2_empId);
		textField2_empId.setColumns(10);
		
		lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBackground(Color.WHITE);
		lblEmployeeId.setBounds(41, 101, 83, 16);
		frame.getContentPane().add(lblEmployeeId);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int hour = 0, min=0, calc = 0;
				int EmpId = 0;
				if (lblEntryTime.getText().equals("Entry Time")) {
					hour = Integer.parseInt(txtHours.getText());
					min = Integer.parseInt(txtMins.getText());
					EmpId = Integer.parseInt(textField2_empId.getText());
					frame.setVisible(false);
					new EmployeePanel().EmployeeFrames.setVisible(true);
					lblEntryTime.setName("Exit Time");
				}
				else if (lblEntryTime.getText().equals("Exit Time")) {
					String word;
					FileManger fm = new FileManger();
					calc = (Integer.parseInt(txtHours.getText())+hour) + ((Integer.parseInt(txtMins.getText())+min)/60);
					word = String.valueOf(calc) + "#" + String.valueOf(EmpId);
					fm.write(word, "Hours.txt", true);
					lblEntryTime.setText("Entry Time");
				}
			}
		});
	}
}
