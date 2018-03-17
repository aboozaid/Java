package ManagerFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import projectClasses.Project;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProject extends JInternalFrame {
	private JTextField NameField;
	private JTextField TaskNumField;
	private JTextField LeaderIDField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProject frame = new AddProject();
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
	public AddProject() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		NameField = new JTextField();
		NameField.setBounds(143, 29, 196, 31);
		getContentPane().add(NameField);
		NameField.setColumns(10);
		
		TaskNumField = new JTextField();
		TaskNumField.setColumns(10);
		TaskNumField.setBounds(143, 85, 196, 31);
		getContentPane().add(TaskNumField);
		
		LeaderIDField = new JTextField();
		LeaderIDField.setColumns(10);
		LeaderIDField.setBounds(143, 144, 196, 31);
		getContentPane().add(LeaderIDField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Project proj = new Project();
				proj.setProjName(NameField.getText());
				proj.setTotalTasks(Integer.parseInt(TaskNumField.getText()));
				proj.setLeaderId(Integer.parseInt(LeaderIDField.getText()));
				proj.AddProject();
			}
		});
		btnSubmit.setBounds(143, 273, 185, 59);
		getContentPane().add(btnSubmit);
		
		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setBounds(48, 36, 77, 16);
		getContentPane().add(lblProjectName);
		
		JLabel lblTasksNumber = new JLabel("Tasks Number");
		lblTasksNumber.setBounds(49, 92, 82, 16);
		getContentPane().add(lblTasksNumber);
		
		JLabel lblLeaderid = new JLabel("LeaderID");
		lblLeaderid.setBounds(75, 151, 56, 16);
		getContentPane().add(lblLeaderid);

	}

}
