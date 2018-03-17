package LeaderFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import projectClasses.Task;
import projectClasses.Vacation;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddVacation extends JInternalFrame {
	private JTable table;
	private JTextField txtEmployeeid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVacation frame = new AddVacation();
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
	public AddVacation() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 410, 284);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Start Date", "End Date", "Reason", "EmployeeID"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		txtEmployeeid = new JTextField();
		txtEmployeeid.setText("EmployeeID");
		txtEmployeeid.setBounds(22, 310, 163, 22);
		getContentPane().add(txtEmployeeid);
		txtEmployeeid.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vacation vac = new Vacation();
				vac.loadFromRequestFile();
				for(Vacation x : vac.ReqVac) {
					if (txtEmployeeid.getText().equals(String.valueOf(x.getEmployeeId()))) {
						vac.addVacation();
					}
				}
			}
		});
		btnNewButton_1.setBounds(249, 310, 97, 25);
		getContentPane().add(btnNewButton_1);
		addRowTable();
	}
	public void addRowTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowdata[] = new Object[4];
		Vacation vac = new Vacation();
		vac.loadFromRequestFile();
		for(Vacation x : vac.ReqVac) {
			rowdata[0] = x.getSD();
			rowdata[1] = x.getED();
			rowdata[2] = x.getReason();
			rowdata[3] = x.getEmployeeId();
			model.addRow(rowdata);
		}
	}
}
