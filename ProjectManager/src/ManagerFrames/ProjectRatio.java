package ManagerFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import projectClasses.ProjectManger;
import projectClasses.Task;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectRatio extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectRatio frame = new ProjectRatio();
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
	public ProjectRatio() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(29, 83, 194, 36);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setBounds(29, 54, 77, 16);
		getContentPane().add(lblProjectName);
		
		JButton btnRatio = new JButton("Ratio");
		
		btnRatio.setBounds(269, 89, 97, 25);
		getContentPane().add(btnRatio);
		
		JLabel lblProjectRatio = new JLabel("Project Ratio");
		lblProjectRatio.setBounds(47, 208, 77, 25);
		getContentPane().add(lblProjectRatio);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(149, 209, 194, 25);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		btnRatio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Task tsk = new Task();
				textField_1.setText(String.valueOf(tsk.viewPrecentage(textField.getText()) + "%"));
			}
		});
	}

}
