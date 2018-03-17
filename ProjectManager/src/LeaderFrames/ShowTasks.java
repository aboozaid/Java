package LeaderFrames;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import projectClasses.Task;

public class ShowTasks extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowTasks frame = new ShowTasks();
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
	public ShowTasks() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(101, 13, 177, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(325, 12, 97, 25);
		getContentPane().add(btnLoad);
		
		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setBounds(12, 16, 77, 16);
		getContentPane().add(lblProjectName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 45, 400, 331);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Details", "Task Name", "Task Num", "EmployeeID"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(107);
		table.getColumnModel().getColumn(1).setPreferredWidth(133);
		table.getColumnModel().getColumn(2).setPreferredWidth(98);
		table.getColumnModel().getColumn(3).setPreferredWidth(134);
		scrollPane.setViewportView(table);
		addRowTable();
	}
	public void addRowTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowdata[] = new Object[3];
		Task tsk = new Task();
		ArrayList<Task> tsks = new ArrayList<>();
		tsks = tsk.ViewCompletedTasks(textField.getText());
		for(Task x : tsks) {
			rowdata[0] = x.getTaskName();
			rowdata[1] = x.getTaskNo();
			rowdata[2] = x.getEmployeeID();
			model.addRow(rowdata);
		}
	}
}
