package LeaderFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import projectClasses.Employee;
import projectClasses.Task;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTasks extends JInternalFrame {
	private JTextField NameField;
	private JTextField ProjectNameField;
	private JTextField TaskNumField;
	private JTextField EmployeeIDField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTasks frame = new AddTasks();
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
	public AddTasks() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		NameField = new JTextField();
		NameField.setBounds(156, 27, 202, 30);
		getContentPane().add(NameField);
		NameField.setColumns(10);
		
		ProjectNameField = new JTextField();
		ProjectNameField.setColumns(10);
		ProjectNameField.setBounds(156, 70, 202, 30);
		getContentPane().add(ProjectNameField);
		
		TaskNumField = new JTextField();
		TaskNumField.setColumns(10);
		TaskNumField.setBounds(156, 113, 202, 30);
		getContentPane().add(TaskNumField);
		
		EmployeeIDField = new JTextField();
		EmployeeIDField.setColumns(10);
		EmployeeIDField.setBounds(156, 156, 202, 30);
		getContentPane().add(EmployeeIDField);
		
		JLabel lblTaskName = new JLabel("Task Name");
		lblTaskName.setBounds(66, 34, 64, 16);
		getContentPane().add(lblTaskName);
		
		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setBounds(66, 77, 80, 16);
		getContentPane().add(lblProjectName);
		
		JLabel lblTaskNum = new JLabel("Task Num");
		lblTaskNum.setBounds(80, 120, 64, 16);
		getContentPane().add(lblTaskNum);
		
		JLabel lblEmployeeid = new JLabel("EmployeeID");
		lblEmployeeid.setBounds(77, 163, 67, 16);
		getContentPane().add(lblEmployeeid);
		
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.setBounds(122, 330, 202, 46);
		getContentPane().add(btnSubmit);
		
		JTextArea TaskEx = new JTextArea();
		TaskEx.setBounds(12, 209, 410, 108);
		getContentPane().add(TaskEx);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Task tsk = new Task();
				tsk.setTaskName(NameField.getText());
				tsk.setProjName(ProjectNameField.getText());
				tsk.setTaskNo(Integer.parseInt(TaskNumField.getText()));
				tsk.setEmployeeID(Integer.parseInt(EmployeeIDField.getText()));
				tsk.setDescription(TaskEx.getText());
				tsk.AddTask();
			}
		});
	}

}
