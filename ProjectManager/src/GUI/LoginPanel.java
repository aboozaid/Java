package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javafx.scene.layout.Background;
import java.awt.Label;
import java.awt.Component;
import javax.swing.Box;
import java.awt.ComponentOrientation;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import projectClasses.*;
import java.awt.Toolkit;

public class LoginPanel {

	public JFrame LoginFram;
	private JTextField IDField;
	private JPasswordField PasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel window = new LoginPanel();
					window.LoginFram.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LoginFram = new JFrame();
		LoginFram.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Assem Abozaid\\Downloads\\avatar2.png"));
		LoginFram.getContentPane().setBackground(Color.decode("#144e83"));
		LoginFram.setBounds(100, 100, 450, 300);;
		LoginFram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFram.getContentPane().setLayout(null);
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBounds(0, 0, 432, 49);
		LoginFram.getContentPane().add(TitlePanel);
		TitlePanel.setLayout(null);
		
		JLabel TitleLabel = new JLabel("Project Manager Login System");
		TitleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		TitleLabel.setForeground(Color.WHITE);
		TitleLabel.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		TitleLabel.setBounds(0, 0, 432, 49);
		TitlePanel.setBackground(Color.decode("#00386b"));
		TitlePanel.add(TitleLabel);

		IDField = new JTextField();
		IDField.setToolTipText("");
		IDField.setBounds(147, 82, 218, 30);
		LoginFram.getContentPane().add(IDField);
		IDField.setColumns(10);
		
		JButton LoginButtom = new JButton("Login");
		LoginButtom.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		LoginButtom.setBackground(Color.decode("#5686a9"));
		LoginButtom.setForeground(Color.decode("#edf7ff"));
		
		
		PasswordField = new JPasswordField();
		PasswordField.setToolTipText("");
		PasswordField.setBounds(147, 129, 218, 30);
		LoginFram.getContentPane().add(PasswordField);
		LoginButtom.setBounds(158, 199, 181, 41);
		LoginFram.getContentPane().add(LoginButtom);
		
		JLabel IDLabel = new JLabel("Your ID");
		IDLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		IDLabel.setForeground(Color.decode("#edf7ff"));
		IDLabel.setBounds(73, 94, 56, 16);
		LoginFram.getContentPane().add(IDLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		PasswordLabel.setForeground(Color.decode("#edf7ff"));
		PasswordLabel.setBounds(73, 141, 62, 16);
		LoginFram.getContentPane().add(PasswordLabel);
		LoginButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!IDField.getText().isEmpty() && !PasswordField.getText().isEmpty()) {
					Ilogin x = null;
					if (Integer.parseInt(IDField.getText())/10000==10) {
						x = new Admin();
						if (x.login(Integer.parseInt(IDField.getText()), PasswordField.getText()))
							{
							LoginFram.setVisible(false);
							new AdminPanel().AdminFrame.setVisible(true);
							}
					}
					else if (Integer.parseInt(IDField.getText())/10000==20)  {
						x = new ProjectManger();
						if (x.login(Integer.parseInt(IDField.getText()), PasswordField.getText())) {
							LoginFram.setVisible(false);
							new ProjectManagerPanel().ManagerFrames.setVisible(true);
						}
					}
					else if (Integer.parseInt(IDField.getText())/10000==30)  {
						x = new Leader();
						if (x.login(Integer.parseInt(IDField.getText()), PasswordField.getText())) {
							LoginFram.setVisible(false);
							new LeaderPanel().LeaderFrames.setVisible(true);}	
					}
					else if (Integer.parseInt(IDField.getText())/10000==40)  {
						x = new Employee();
						if (x.login(Integer.parseInt(IDField.getText()), PasswordField.getText())) {
							LoginFram.setVisible(false);
							new workingHours().frame.setVisible(true);
							}
					}
					else {
						JOptionPane.showMessageDialog(null, "Your ID or Password are wrong");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter your account");
				}
				
			}
		});
	}
}
