package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import ManagerFrames.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ProjectManagerPanel {

	JFrame ManagerFrames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectManagerPanel window = new ProjectManagerPanel();
					window.ManagerFrames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjectManagerPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ManagerFrames = new JFrame();
		ManagerFrames.setResizable(false);
		ManagerFrames.setBounds(100, 100, 800, 600);
		ManagerFrames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ManagerFrames.getContentPane().setLayout(null);
		
		JPanel LeftPanel = new JPanel();
		LeftPanel.setLayout(null);
		LeftPanel.setBackground(new Color(233, 246, 255));
		LeftPanel.setBounds(0, 0, 300, 553);
		ManagerFrames.getContentPane().add(LeftPanel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(194, 235, 255));
		panel_1.setBounds(0, 0, 300, 63);
		LeftPanel.add(panel_1);
		
		JLabel label = new JLabel("Project Managment");
		label.setFont(new Font("Calibri Light", Font.PLAIN, 22));
		label.setBounds(64, 13, 173, 37);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Assem Abozaid\\Downloads\\avatar1.png"));
		label_1.setBounds(33, 80, 64, 63);
		LeftPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Welcome");
		label_2.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		label_2.setBounds(167, 100, 72, 20);
		LeftPanel.add(label_2);
		
		JButton btnAddProject = new JButton("Add Project");
		
		btnAddProject.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnAddProject.setFocusPainted(false);
		btnAddProject.setBackground(new Color(194, 235, 255));
		btnAddProject.setBounds(12, 208, 276, 47);
		LeftPanel.add(btnAddProject);
		
		JButton btnMakeAReport = new JButton("Make a Report");
		
		btnMakeAReport.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnMakeAReport.setFocusPainted(false);
		btnMakeAReport.setBackground(new Color(194, 235, 255));
		btnMakeAReport.setBounds(12, 268, 276, 47);
		LeftPanel.add(btnMakeAReport);
		
		JButton btnProjectRatio = new JButton("Project Ratio");
		
		btnProjectRatio.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnProjectRatio.setFocusPainted(false);
		btnProjectRatio.setBackground(new Color(194, 235, 255));
		btnProjectRatio.setBounds(12, 328, 276, 47);
		LeftPanel.add(btnProjectRatio);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.decode("#00386b"));
		desktopPane.setBounds(299, 0, 483, 553);
		ManagerFrames.getContentPane().add(desktopPane);
		AddProject project = new AddProject();
		MakeReport report = new MakeReport();
		ProjectRatio ratio = new ProjectRatio();
		btnAddProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				desktopPane.add(project);
				project.setVisible(true);
				report.setVisible(false);
				ratio.setVisible(false);
			}
		});
		btnMakeAReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				desktopPane.add(report);
				project.setVisible(false);
				report.setVisible(true);
				ratio.setVisible(false);
			}
		});
		btnProjectRatio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				desktopPane.add(ratio);
				project.setVisible(false);
				report.setVisible(false);
				ratio.setVisible(true);
			}
		});
	}

}
