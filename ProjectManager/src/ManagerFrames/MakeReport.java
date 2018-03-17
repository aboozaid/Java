package ManagerFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import projectClasses.Report;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MakeReport extends JInternalFrame {
	private JTextField EmployeeID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeReport frame = new MakeReport();
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
	public MakeReport() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		JLabel lblReportContent = new JLabel("Report Content");
		lblReportContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportContent.setBounds(95, 13, 239, 28);
		getContentPane().add(lblReportContent);
		
		JTextArea ReasonArea = new JTextArea();
		ReasonArea.setBounds(12, 62, 410, 173);
		getContentPane().add(ReasonArea);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report rep = new Report();
				rep.setRCause(ReasonArea.getText());
				rep.setEmpID(Integer.parseInt(EmployeeID.getText()));
				rep.addReport();
			}
		});
		btnSubmit.setBounds(106, 300, 228, 42);
		getContentPane().add(btnSubmit);
		
		EmployeeID = new JTextField();
		EmployeeID.setBounds(85, 248, 149, 28);
		getContentPane().add(EmployeeID);
		EmployeeID.setColumns(10);
		
		JLabel lblEmployeeid = new JLabel("EmployeeID");
		lblEmployeeid.setBounds(12, 254, 75, 16);
		getContentPane().add(lblEmployeeid);

	}
}
