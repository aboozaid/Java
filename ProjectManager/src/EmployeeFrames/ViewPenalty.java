package EmployeeFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projectClasses.Penalities;
import projectClasses.Task;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewPenalty extends JInternalFrame {
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPenalty frame = new ViewPenalty();
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
	public ViewPenalty() {
		setClosable(true);
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 48, 410, 328);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"EmployeeID", "Penalty"
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
		
		textField = new JTextField();
		textField.setBounds(28, 13, 135, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addRowTable();
			}
		});
		btnLoad.setBounds(247, 12, 97, 25);
		getContentPane().add(btnLoad);
	}
	public void addRowTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowdata[] = new Object[2];
		Penalities pen = new Penalities();
		ArrayList<Penalities> pens = new ArrayList<>();
		pens = pen.viewPen(Integer.parseInt(textField.getText()));
		for(Penalities x : pens) {
			rowdata[0] = x.getEmployeeID();
			rowdata[1] = x.getReason();
			model.addRow(rowdata);
		}
	}
}
