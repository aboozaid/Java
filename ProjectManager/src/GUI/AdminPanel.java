package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JDesktopPane;
import AdminFrames.*;
public class AdminPanel {

	JFrame AdminFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.AdminFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AdminFrame = new JFrame();
		AdminFrame.setResizable(false);
		AdminFrame.setBounds(100, 100, 800, 600);
		AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminFrame.getContentPane().setLayout(null);
		
		JPanel LeftPanel = new JPanel();
		LeftPanel.setBounds(0, 0, 300, 553);
		AdminFrame.getContentPane().add(LeftPanel);
		LeftPanel.setBackground(Color.decode("#e9f6ff"));
		LeftPanel.setLayout(null);
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBounds(0, 0, 300, 63);
		LeftPanel.add(TitlePanel);
		TitlePanel.setBackground(Color.decode("#c2ebff"));
		TitlePanel.setLayout(null);
		
		JLabel LeftTitle = new JLabel("Project Managment");
		LeftTitle.setFont(new Font("Calibri Light", Font.PLAIN, 22));
		LeftTitle.setBounds(64, 13, 173, 37);
		TitlePanel.add(LeftTitle);
		
		JLabel AvatarPhoto = new JLabel("");
		AvatarPhoto.setIcon(new ImageIcon("C:\\Users\\Assem Abozaid\\Downloads\\avatar1.png"));
		AvatarPhoto.setBounds(33, 80, 64, 63);
		LeftPanel.add(AvatarPhoto);
		
		JLabel WelcomeLabel = new JLabel("Welcome");
		WelcomeLabel.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		WelcomeLabel.setBounds(151, 104, 72, 20);
		LeftPanel.add(WelcomeLabel);
		
		JButton ViewButton = new JButton("View Projects");
		ViewButton.setFocusPainted(false);
		ViewButton.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		ViewButton.setBackground(Color.decode("#c2ebff"));
		
		ViewButton.setBounds(12, 208, 276, 47);
		LeftPanel.add(ViewButton);
		
		JButton AddButton = new JButton("Add Users");
		
		AddButton.setFocusPainted(false);
		AddButton.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		AddButton.setBackground(Color.decode("#c2ebff"));
		AddButton.setBounds(12, 268, 276, 47);
		LeftPanel.add(AddButton);
		
		JButton ManageUsers = new JButton("Update/Delete Users");
		ManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ManageUsers.setFocusPainted(false);
		ManageUsers.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		ManageUsers.setBackground(Color.decode("#c2ebff"));
		ManageUsers.setBounds(12, 328, 276, 47);
		LeftPanel.add(ManageUsers);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.decode("#00386b"));
		desktopPane.setBounds(299, 0, 483, 553);
		AdminFrame.getContentPane().add(desktopPane);
		ViewProjects view = new ViewProjects();
		AddUsers user = new AddUsers();
		ManageUsers manage = new ManageUsers();
		ViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desktopPane.add(view);
				view.setVisible(true);
				user.setVisible(false);
				manage.setVisible(false);
			}
		});
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				desktopPane.add(user);
				view.setVisible(false);
				user.setVisible(true);
				manage.setVisible(false);
				
			}
		});
		ManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				desktopPane.add(manage);
				view.setVisible(false);
				user.setVisible(false);
				manage.setVisible(true);
			}
		});
	}
}
