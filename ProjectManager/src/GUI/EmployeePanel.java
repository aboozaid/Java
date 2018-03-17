package GUI;
import java.awt.EventQueue;
import GUI.workingHours;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import EmployeeFrames.*;
import projectClasses.Employee;
import projectClasses.Person;
public class EmployeePanel extends Person {

	JFrame EmployeeFrames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePanel window = new EmployeePanel();
					window.EmployeeFrames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		EmployeeFrames = new JFrame();
		EmployeeFrames.setBounds(100, 100, 800, 600);
		EmployeeFrames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EmployeeFrames.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(233, 246, 255));
		panel.setBounds(0, 0, 300, 553);
		EmployeeFrames.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(194, 235, 255));
		panel_1.setBounds(0, 0, 300, 63);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Project Managment");
		label.setFont(new Font("Calibri Light", Font.PLAIN, 22));
		label.setBounds(64, 13, 173, 37);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Assem Abozaid\\Downloads\\avatar1.png"));
		label_1.setBounds(33, 80, 64, 63);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Welcome");
		label_2.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		label_2.setBounds(159, 108, 72, 20);
		panel.add(label_2);
		
		JButton btnViewtasks = new JButton("View Tasks");
		
		btnViewtasks.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnViewtasks.setFocusPainted(false);
		btnViewtasks.setBackground(new Color(194, 235, 255));
		btnViewtasks.setBounds(12, 201, 276, 47);
		panel.add(btnViewtasks);
		
		JButton btnEndTask = new JButton("End Task");
		
		btnEndTask.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnEndTask.setFocusPainted(false);
		btnEndTask.setBackground(new Color(194, 235, 255));
		btnEndTask.setBounds(12, 261, 276, 47);
		panel.add(btnEndTask);
		
		JButton btnCheckTasks = new JButton("Check Tasks");
		
		btnCheckTasks.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnCheckTasks.setFocusPainted(false);
		btnCheckTasks.setBackground(new Color(194, 235, 255));
		btnCheckTasks.setBounds(12, 321, 276, 47);
		panel.add(btnCheckTasks);
		
		JButton btnViewPenalty = new JButton("View Penalty");
		
		btnViewPenalty.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnViewPenalty.setFocusPainted(false);
		btnViewPenalty.setBackground(new Color(194, 235, 255));
		btnViewPenalty.setBounds(12, 381, 276, 47);
		panel.add(btnViewPenalty);
		
		JButton btnCalculateHours = new JButton("Calculate Hours");
		
		btnCalculateHours.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnCalculateHours.setFocusPainted(false);
		btnCalculateHours.setBackground(new Color(194, 235, 255));
		btnCalculateHours.setBounds(12, 441, 276, 47);
		panel.add(btnCalculateHours);
		
		JLabel lblOvermonth = new JLabel("OverMonth:");
		lblOvermonth.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblOvermonth.setBounds(136, 141, 75, 25);
		panel.add(lblOvermonth);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(212, 144, 56, 16);
		panel.add(lblHours);
		
		JButton btnRequestVacation = new JButton("Request Vacation");
		
		btnRequestVacation.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnRequestVacation.setFocusPainted(false);
		btnRequestVacation.setBackground(new Color(194, 235, 255));
		btnRequestVacation.setBounds(12, 499, 276, 47);
		panel.add(btnRequestVacation);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.decode("#00386b"));
		desktopPane.setBounds(299, 0, 483, 553);
		EmployeeFrames.getContentPane().add(desktopPane);
		btnViewtasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTasks task = new ViewTasks();
				desktopPane.add(task);
				task.setVisible(true);
			}
		});
		btnEndTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EndTasks task = new EndTasks();
				desktopPane.add(task);
				task.setVisible(true);
			}
		});
		btnCheckTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckTasks task = new CheckTasks();
				desktopPane.add(task);
				task.setVisible(true);
			}
		});
		btnViewPenalty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPenalty penalty = new ViewPenalty();
				desktopPane.add(penalty);
				penalty.setVisible(true);
			}
		});
		btnCalculateHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee emp = new Employee();
				lblHours.setText(String.valueOf(emp.calcHours(id)));
			}
		});
		btnRequestVacation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReqVacation vacation = new ReqVacation();
				desktopPane.add(vacation);
				vacation.setVisible(true);
			}
		});
		if (EmployeeFrames.EXIT_ON_CLOSE == 1) {
			new workingHours().frame.setVisible(true);
		}
	}

	@Override
	public boolean login(int id, String Password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
