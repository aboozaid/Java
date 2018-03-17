package AdminFrames;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projectClasses.MyException;
import projectClasses.Project;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class ViewProjects extends JInternalFrame {
	private JTable ProjectsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProjects frame = new ViewProjects();
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
	public ViewProjects() {
		setRequestFocusEnabled(false);
		setBorder(null);
		setClosable(true);
		setMinimumSize(new Dimension(0, 0));
		setPreferredSize(new Dimension(0, 0));
		setBounds(100, 100, 450, 425);
		setBackground(Color.decode("#00386b"));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(12, 13, 410, 363);
		scrollPane.setBackground(Color.decode("#c2ebff"));
		getContentPane().add(scrollPane);
		
		ProjectsTable = new JTable();
		ProjectsTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Name", "TasksNum", "LeaderID"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		ProjectsTable.getColumnModel().getColumn(0).setPreferredWidth(119);
		ProjectsTable.getColumnModel().getColumn(1).setPreferredWidth(107);
		ProjectsTable.getColumnModel().getColumn(2).setPreferredWidth(113);
		DefaultTableModel d = new DefaultTableModel();
		scrollPane.setViewportView(ProjectsTable);
		MyException x = new MyException();
		if(x.filesExists("Project.bin"))
			addRowTable();
		else
			JOptionPane.showMessageDialog(null, "There is no project to show");
	}
	public void addRowTable() {
		DefaultTableModel model = (DefaultTableModel)ProjectsTable.getModel();
		Object rowdata[] = new Object[4];
		Project proj = new Project();
		ArrayList<Project> projects = new ArrayList<>();
		projects = proj.ViewProject();
		for (Project x : projects) {
			rowdata[0] = x.getProjName();
			rowdata[1] = x.getTotalTasks();
			rowdata[2] = x.getLeaderId();
			model.addRow(rowdata);
		}
	}
}
