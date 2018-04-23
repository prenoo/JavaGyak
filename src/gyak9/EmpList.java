package gyak9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class EmpList extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private EmpTM etm;
	private JButton btnBezar;

	public EmpList(JFrame f, EmpTM betm) {
		super(f, "Dolgozók listája", true);
		etm = betm;

		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnBezar = new JButton("Bezár");
		btnBezar.setActionCommand("Bezar");
		btnBezar.setBounds(192, 215, 97, 25);
		contentPanel.add(btnBezar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 458, 194);
		contentPanel.add(scrollPane);

		table = new JTable(etm);
		scrollPane.setViewportView(table);

		TableColumn tc = null;
		for (int i = 0; i < 6; i++) {
			tc = table.getColumnModel().getColumn(i);
			if (i == 0 || i == 1 || i == 5)
				tc.setPreferredWidth(30);
			else {
				tc.setPreferredWidth(100);
			}
		}

		table.setAutoCreateRowSorter(true);
		TableRowSorter<EmpTM> trs = (TableRowSorter<EmpTM>) table.getRowSorter();
		trs.setSortable(0, false);

		this.btnBezar.addActionListener(this);
		
	}

	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Bezar")) {
		      dispose(); 
		      setVisible(false);
		}
		
	}
}
