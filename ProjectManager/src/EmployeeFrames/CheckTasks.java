package EmployeeFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projectClasses.Task;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CheckTasks extends JInternalFrame {
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckTasks frame = new CheckTasks();
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
	public CheckTasks() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 56, 410, 320);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TaskName", "TaskNum", "ProjectName", "EmployeeID"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setPreferredWidth(81);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(99);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(34, 21, 146, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addRowTable();
			}
		});
		btnLoad.setBounds(275, 20, 97, 25);
		getContentPane().add(btnLoad);
	}
	public void addRowTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowdata[] = new Object[4];
		Task tsk = new Task();
		ArrayList<Task> tsks = new ArrayList<>();
		tsks = tsk.ViewFinishedTasks(Integer.parseInt(textField.getText()));
		for(Task x : tsks) {
			rowdata[0] = x.getTaskName();
			rowdata[1] = x.getTaskNo();
			rowdata[2] = x.getProjName();
			rowdata[3] = x.getEmployeeID();
			model.addRow(rowdata);
		}
	}
}
