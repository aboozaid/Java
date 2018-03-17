package LeaderFrames;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projectClasses.Report;

public class Reports extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
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
	public Reports() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 410, 363);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"EmployeeID", "Report"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		addRowsTable();

	}
	public void addRowsTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowdata[] = new Object[2];
		Report rp = new Report();
		ArrayList<Report> reports = new ArrayList<>();
		reports = rp.getReports();
		for (Report x : reports) {
			rowdata[0] = x.getEmpID();
			rowdata[1] = x.getRCause();
			model.addRow(rowdata);
		}
	}

}
