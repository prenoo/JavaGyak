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
import javax.swing.JCheckBox;
import java.awt.Font;

public class EmpDel extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private EmpTM etm;
	private JButton btnTorol;
	private JCheckBox jcb;
	private boolean md = false;

	public EmpDel(JFrame f, EmpTM betm) {
		super(f, "Dolgozók listája", true);
		etm = betm;

		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnTorol = new JButton("Töröl");
		btnTorol.setActionCommand("Torol");
		btnTorol.setBounds(192, 215, 97, 25);
		contentPanel.add(btnTorol);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 458, 165);
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

		jcb = new JCheckBox("Több rekord is törölhető egyszerre");
		jcb.setActionCommand("jcb");
		jcb.setFont(new Font("Tahoma", Font.BOLD, 13));
		jcb.setBounds(12, 189, 458, 25);
		contentPanel.add(jcb);
		TableRowSorter<EmpTM> trs = (TableRowSorter<EmpTM>) table.getRowSorter();
		trs.setSortable(0, false);

		this.btnTorol.addActionListener(this);
		this.jcb.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Torol")) {
			int db = 0, jel = 0, x = 0;
			for (x = 0; x < etm.getRowCount(); x++)
				if ((Boolean) etm.getValueAt(x, 0)) {
					db++;
					jel = x;
				}
			if (db == 0)
				BC.showMD("Nincs kijelölve a törlendő rekord!", 0);
			if (!md) {
				if (db > 1)
					BC.showMD("Több rekord van kijelölve!\nEgyszerre csak egy rekord törölhető!", 0);
				if (db == 1) {
					etm.removeRow(jel);
					BC.showMD("A rekord törölve!", 1);
				}
			} else {
				for (int i = 0; i < etm.getRowCount(); i++)
					if ((Boolean) etm.getValueAt(i, 0)) {
						etm.removeRow(i);
						i--;
					}
				BC.showMD("Rekord(ok) törölve!", 1);
			}
		}

		if (e.getActionCommand().equals("jcb")) {
			md = jcb.isSelected();
		}

	}
}
