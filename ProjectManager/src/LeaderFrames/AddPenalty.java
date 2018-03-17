package LeaderFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import projectClasses.Penalities;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPenalty extends JInternalFrame {
	private JTextField EmployeeIDField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPenalty frame = new AddPenalty();
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
	public AddPenalty() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		EmployeeIDField = new JTextField();
		EmployeeIDField.setBounds(88, 29, 198, 31);
		getContentPane().add(EmployeeIDField);
		EmployeeIDField.setColumns(10);
		
		JLabel lblEmployeeid = new JLabel("EmployeeID");
		lblEmployeeid.setBounds(12, 36, 77, 16);
		getContentPane().add(lblEmployeeid);
		
		JTextArea ReasonField = new JTextArea();
		ReasonField.setBounds(12, 79, 410, 162);
		getContentPane().add(ReasonField);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Penalities pen = new Penalities();
				pen.setEmployeeID(Integer.parseInt(EmployeeIDField.getText()));
				pen.setReason(ReasonField.getText());
				pen.addPen();
			}
		});
		btnNewButton.setBounds(162, 304, 140, 49);
		getContentPane().add(btnNewButton);

	}

}
