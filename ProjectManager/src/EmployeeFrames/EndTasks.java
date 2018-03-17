package EmployeeFrames;

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

public class EndTasks extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndTasks frame = new EndTasks();
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
	public EndTasks() {
		setClosable(true);
		setBounds(100, 100, 447, 378);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(100, 50, 190, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTaskNum = new JLabel("Task Num");
		lblTaskNum.setBounds(31, 57, 57, 16);
		getContentPane().add(lblTaskNum);
		
		JButton btnFinished = new JButton("Finished");
		
		btnFinished.setBounds(149, 290, 140, 39);
		getContentPane().add(btnFinished);
		
		JTextArea txtrDetails = new JTextArea();
		txtrDetails.setText("Details");
		txtrDetails.setBounds(31, 101, 370, 174);
		getContentPane().add(txtrDetails);
		btnFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Task tsk = new Task();
				tsk = (Task)tsk.GetEmployeeTask(Integer.parseInt(textField.getText()));
				tsk.setWriteTask(txtrDetails.getText());
				Employee em = new Employee();
				em.writeTask(tsk);
			}
		});
	}
}
