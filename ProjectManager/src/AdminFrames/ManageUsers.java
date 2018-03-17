package AdminFrames;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import projectClasses.*;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageUsers extends JInternalFrame {
	private JTextField IDField1;
	private JTextField IDField2;
	private JTextField PasswordField;
	private JTextField NameField;
	private JTextField PosField;
	private JTextField AgeField;
	private JLabel lblId;
	private JLabel lblPassword;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JLabel lblAge;
	private JLabel lblId_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUsers frame = new ManageUsers();
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
	public ManageUsers() {
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		setBackground(Color.decode("#c2ebff"));
		
		IDField1 = new JTextField();
		IDField1.setBounds(50, 13, 180, 24);
		getContentPane().add(IDField1);
		IDField1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyException x = new MyException();
				if (x.checkIdPosition(Integer.parseInt(IDField1.getText()))) {
					ProjectManger pm = new ProjectManger();
					pm = (ProjectManger) pm.getProjectManger(Integer.parseInt(IDField1.getText()));
					IDField2.setText(String.valueOf(pm.getId()));
					PasswordField.setText(pm.getPassword());
					NameField.setText(pm.getName());
					PosField.setText(pm.getPosition());
					AgeField.setText(String.valueOf(pm.getAge()));
				}
				else if (x.checkIdPosition(Integer.parseInt(IDField1.getText()))) {
					Leader lead = new Leader();
					lead = (Leader) lead.getLeader(Integer.parseInt(IDField1.getText()));
					IDField2.setText(String.valueOf(lead.getId()));
					PasswordField.setText(lead.getPassword());
					NameField.setText(lead.getName());
					PosField.setText(lead.getPosition());
					AgeField.setText(String.valueOf(lead.getAge()));
				}
				else if (x.checkIdPosition(Integer.parseInt(IDField1.getText()))) {
					Employee emp = new Employee();
					emp = (Employee) emp.getEmployee(Integer.parseInt(IDField1.getText()));
					IDField2.setText(String.valueOf(emp.getId()));
					PasswordField.setText(emp.getPassword());
					NameField.setText(emp.getName());
					PosField.setText(emp.getPosition());
					AgeField.setText(String.valueOf(emp.getAge()));
				}
			}
		});
		btnSearch.setBounds(329, 13, 97, 25);
		getContentPane().add(btnSearch);
		
		IDField2 = new JTextField();
		IDField2.setBounds(127, 70, 180, 22);
		getContentPane().add(IDField2);
		IDField2.setColumns(10);
		
		PasswordField = new JTextField();
		PasswordField.setColumns(10);
		PasswordField.setBounds(127, 105, 180, 22);
		getContentPane().add(PasswordField);
		
		NameField = new JTextField();
		NameField.setColumns(10);
		NameField.setBounds(127, 144, 180, 22);
		getContentPane().add(NameField);
		
		PosField = new JTextField();
		PosField.setColumns(10);
		PosField.setBounds(127, 179, 180, 22);
		getContentPane().add(PosField);
		
		AgeField = new JTextField();
		AgeField.setColumns(10);
		AgeField.setBounds(127, 214, 180, 22);
		getContentPane().add(AgeField);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyException x = new MyException();
				if (x.checkIdPosition(Integer.parseInt(IDField2.getText()))) {
					ProjectManger pm = new ProjectManger();
					pm.setId(Integer.parseInt(IDField2.getText()));
					pm.setPassword(PasswordField.getText());
					pm.setName(NameField.getName());
					pm.setPosition(PosField.getText());
					pm.setAge(Integer.parseInt(AgeField.getText()));
					pm.UpdatPM(Integer.parseInt(IDField1.getText()), pm);
				}
				else if (x.checkIdPosition(Integer.parseInt(IDField2.getText()))) {
					Leader lead = new Leader();
					lead.setId(Integer.parseInt(IDField2.getText()));
					lead.setPassword(PasswordField.getText());
					lead.setName(NameField.getName());
					lead.setPosition(PosField.getText());
					lead.setAge(Integer.parseInt(AgeField.getText()));
					lead.UpdatLeader(Integer.parseInt(IDField1.getText()), lead);
				}
				else if (x.checkIdPosition(Integer.parseInt(IDField2.getText()))) {
					Employee emp = new Employee();
					emp.setId(Integer.parseInt(IDField2.getText()));
					emp.setPassword(PasswordField.getText());
					emp.setName(NameField.getName());
					emp.setPosition(PosField.getText());
					emp.setAge(Integer.parseInt(AgeField.getText()));
					emp.UpdatEmployee(Integer.parseInt(IDField1.getText()), emp);
				}
			}
		});
		btnUpdate.setBounds(50, 308, 114, 42);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyException x = new MyException();
				if (x.checkIdPosition(Integer.parseInt(IDField1.getText()))) {
					Employee emp = new Employee();
					emp.deleteEmployee(Integer.parseInt(IDField1.getText()));
				}
				else if (x.checkIdPosition(Integer.parseInt(IDField1.getText()))) {
					Leader lead = new Leader();
					lead.deleteLeader(Integer.parseInt(IDField1.getText()));
				}
				else if (x.checkIdPosition(Integer.parseInt(IDField1.getText()))) {
					ProjectManger pm = new ProjectManger();
					pm.deleteProjectManager(Integer.parseInt(IDField1.getText()));
				}
			}
		});
		btnDelete.setBounds(268, 308, 114, 42);
		getContentPane().add(btnDelete);
		
		lblId = new JLabel("ID");
		lblId.setBounds(86, 73, 19, 16);
		getContentPane().add(lblId);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 108, 65, 16);
		getContentPane().add(lblPassword);
		
		lblName = new JLabel("Name");
		lblName.setBounds(72, 147, 33, 16);
		getContentPane().add(lblName);
		
		lblNewLabel = new JLabel("Position");
		lblNewLabel.setBounds(61, 182, 44, 16);
		getContentPane().add(lblNewLabel);
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(83, 217, 22, 16);
		getContentPane().add(lblAge);
		
		lblId_1 = new JLabel("ID");
		lblId_1.setBounds(24, 17, 19, 16);
		getContentPane().add(lblId_1);

	}

}
