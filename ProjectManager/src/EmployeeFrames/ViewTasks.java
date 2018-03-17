package EmployeeFrames;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projectClasses.Task;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewTasks extends JInternalFrame {
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTasks frame = new ViewTasks();
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
	public ViewTasks() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 47, 410, 329);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Task Name", "Description", "Project Name", "TaskNum"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(137);
		table.getColumnModel().getColumn(1).setPreferredWidth(171);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(94);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(31, 12, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addRowTable();
			}
		});
		btnLoad.setBounds(231, 11, 97, 25);
		getContentPane().add(btnLoad);
		
	}
	public void addRowTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowdata[] = new Object[4];
		Task tsk = new Task();
		ArrayList<Task> tsks = new ArrayList<>();
		tsks = tsk.ViewTasks(Integer.parseInt(textField.getText()));
		for(Task x : tsks) {
			rowdata[0] = x.getTaskName();
			rowdata[1] = x.getDescription();
			rowdata[2] = x.getProjName();
			rowdata[3] = x.getTaskNo();
			model.addRow(rowdata);
		}
	}
}
