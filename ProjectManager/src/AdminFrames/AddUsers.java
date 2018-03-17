package AdminFrames;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import javafx.scene.control.PasswordField;
import projectClasses.*;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUsers extends JInternalFrame {
	private JTextField IDField;
	private JPasswordField passwordField;
	private JTextField NameField;
	private JTextField PosField;
	private JTextField AgeField;
	private JButton SubmitBtn;
	private JLabel IDLabel;
	private JLabel pwLabel;
	private JLabel NameLabel;
	private JLabel PosLabel;
	private JLabel AgeLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUsers frame = new AddUsers();
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
	public AddUsers() {
		setBorder(null);
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		setBackground(Color.decode("#c2ebff"));
		
		IDField = new JTextField();
		IDField.setBounds(160, 44, 188, 28);
		getContentPane().add(IDField);
		IDField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 80, 188, 28);
		getContentPane().add(passwordField);
		
		NameField = new JTextField();
		NameField.setBounds(160, 121, 188, 28);
		getContentPane().add(NameField);
		NameField.setColumns(10);
		
		PosField = new JTextField();
		PosField.setBounds(160, 162, 188, 28);
		getContentPane().add(PosField);
		PosField.setColumns(10);
		
		AgeField = new JTextField();
		AgeField.setBounds(160, 203, 188, 28);
		getContentPane().add(AgeField);
		AgeField.setColumns(10);
		
		SubmitBtn = new JButton("Submit");
		SubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyException x = new MyException();
				if (PosField.getText().equals("employee")) {
					Employee emp = new Employee();
					emp.setId(Integer.parseInt(IDField.getText()));
					emp.setPassword(passwordField.getText());
					emp.setName(NameField.getText());
					emp.setPosition(PosField.getText());
					emp.setAge(Integer.parseInt(AgeField.getText()));
					if (x.filesExists("Employee.bin"))
						emp.AddEmployee();
					else
						JOptionPane.showMessageDialog(null, "Unable to create an account");
				}
				else if (PosField.getText().equals("leader")) {
					Leader lead = new Leader(Integer.parseInt(IDField.getText()),passwordField.getText(),NameField.getText(),PosField.getText(),Integer.parseInt(AgeField.getText()));
						if(x.filesExists("Leader.bin"))
							lead.addLeader();
				}
				else if (PosField.getText().equals("project manager")) {
					ProjectManger pm = new ProjectManger();
					pm.setId(Integer.parseInt(IDField.getText()));
					pm.setPassword(passwordField.getText());
					pm.setName(NameField.getText());
					pm.setPosition(PosField.getText());
					pm.setAge(Integer.parseInt(AgeField.getText()));
					if (x.filesExists("PM.bin"))
						pm.AddProjectManager();
					else
						JOptionPane.showMessageDialog(null, "Unable to create an account");
				}
			}
		});
		SubmitBtn.setBounds(123, 299, 175, 51);
		getContentPane().add(SubmitBtn);
		
		IDLabel = new JLabel("ID");
		IDLabel.setBounds(77, 50, 56, 16);
		getContentPane().add(IDLabel);
		
		pwLabel = new JLabel("Password");
		pwLabel.setBounds(77, 86, 56, 16);
		getContentPane().add(pwLabel);
		
		NameLabel = new JLabel("Name");
		NameLabel.setBounds(77, 127, 56, 16);
		getContentPane().add(NameLabel);
		
		PosLabel = new JLabel("Position");
		PosLabel.setBounds(77, 168, 56, 16);
		getContentPane().add(PosLabel);
		
		AgeLabel = new JLabel("Age");
		AgeLabel.setBounds(77, 209, 56, 16);
		getContentPane().add(AgeLabel);

	}

}
