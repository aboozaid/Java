package GUI;
import java.awt.EventQueue;

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
import LeaderFrames.*;
public class LeaderPanel {

	JFrame LeaderFrames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaderPanel window = new LeaderPanel();
					window.LeaderFrames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LeaderPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LeaderFrames = new JFrame();
		LeaderFrames.setBounds(100, 100, 800, 600);
		LeaderFrames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LeaderFrames.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(233, 246, 255));
		panel.setBounds(0, 0, 300, 553);
		LeaderFrames.getContentPane().add(panel);
		
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
		label_2.setBounds(167, 99, 72, 20);
		panel.add(label_2);
		
		JButton btnAddTask = new JButton("Add Task");
		
		btnAddTask.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnAddTask.setFocusPainted(false);
		btnAddTask.setBackground(new Color(194, 235, 255));
		btnAddTask.setBounds(12, 208, 276, 47);
		panel.add(btnAddTask);
		
		JButton btnShowTasks = new JButton("Show Tasks");
		
		btnShowTasks.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnShowTasks.setFocusPainted(false);
		btnShowTasks.setBackground(new Color(194, 235, 255));
		btnShowTasks.setBounds(12, 268, 276, 47);
		panel.add(btnShowTasks);
		
		JButton btnViewReports = new JButton("View Reports");
		
		btnViewReports.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnViewReports.setFocusPainted(false);
		btnViewReports.setBackground(new Color(194, 235, 255));
		btnViewReports.setBounds(12, 328, 276, 47);
		panel.add(btnViewReports);
		
		JButton btnAddPenalty = new JButton("Add Penalty");
		
		btnAddPenalty.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnAddPenalty.setFocusPainted(false);
		btnAddPenalty.setBackground(new Color(194, 235, 255));
		btnAddPenalty.setBounds(12, 388, 276, 47);
		panel.add(btnAddPenalty);
		
		JButton btnAddVacation = new JButton("Add Vacation");
		
		btnAddVacation.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnAddVacation.setFocusPainted(false);
		btnAddVacation.setBackground(new Color(194, 235, 255));
		btnAddVacation.setBounds(12, 448, 276, 47);
		panel.add(btnAddVacation);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.decode("#00386b"));
		desktopPane.setBounds(299, 0, 483, 553);
		LeaderFrames.getContentPane().add(desktopPane);
		AddTasks task = new AddTasks();
		ShowTasks show = new ShowTasks();
		Reports report = new Reports();
		AddPenalty penalty = new AddPenalty();
		AddVacation vacation = new AddVacation();
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				desktopPane.add(task);
				task.setVisible(true);
				show.setVisible(false);
				report.setVisible(false);
				penalty.setVisible(false);
				vacation.setVisible(false);
			}
		});
		btnShowTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				desktopPane.add(show);
				task.setVisible(false);
				show.setVisible(true);
				report.setVisible(false);
				penalty.setVisible(false);
				vacation.setVisible(false);
			}
		});
		btnViewReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				desktopPane.add(report);
				task.setVisible(false);
				show.setVisible(false);
				report.setVisible(true);
				penalty.setVisible(false);
				vacation.setVisible(false);
			}
		});
		btnAddPenalty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				desktopPane.add(penalty);
				task.setVisible(false);
				show.setVisible(false);
				report.setVisible(false);
				penalty.setVisible(true);
				vacation.setVisible(false);
			}
		});
		btnAddVacation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				desktopPane.add(vacation);
				task.setVisible(false);
				show.setVisible(false);
				report.setVisible(false);
				penalty.setVisible(false);
				vacation.setVisible(true);
			}
		});
	}

}
