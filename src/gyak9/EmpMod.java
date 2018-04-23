package gyak9;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class EmpMod extends JDialog implements ActionListener, ListSelectionListener {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private EmpTM etm;
	private JButton btnBezar;
	private JTextField textFieldNev;
	private JTextField textFieldSzid;
	private JTextField textFieldLakh;
	private JTextField textFieldIQ;
	private JButton btnModosit;

	public EmpMod(JFrame f, EmpTM betm) {
		super(f, "Dolgozók listája", true);
		setTitle("Dolgozók módosítása");
		etm = betm;

		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnBezar = new JButton("Bezár");
		btnBezar.setActionCommand("Bezar");
		btnBezar.setBounds(260, 221, 97, 25);
		contentPanel.add(btnBezar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 458, 160);
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

		textFieldNev = new JTextField();
		textFieldNev.setBounds(47, 186, 116, 22);
		contentPanel.add(textFieldNev);
		textFieldNev.setColumns(10);

		textFieldSzid = new JTextField();
		textFieldSzid.setBounds(175, 186, 78, 22);
		contentPanel.add(textFieldSzid);
		textFieldSzid.setColumns(10);

		textFieldLakh = new JTextField();
		textFieldLakh.setBounds(265, 186, 116, 22);
		contentPanel.add(textFieldLakh);
		textFieldLakh.setColumns(10);

		textFieldIQ = new JTextField();
		textFieldIQ.setBounds(393, 186, 77, 22);
		contentPanel.add(textFieldIQ);
		textFieldIQ.setColumns(10);

		btnModosit = new JButton("Módosít");
		btnModosit.setActionCommand("Modosit");
		btnModosit.setBounds(151, 221, 97, 25);
		contentPanel.add(btnModosit);
		TableRowSorter<EmpTM> trs = (TableRowSorter<EmpTM>) table.getRowSorter();
		trs.setSortable(0, false);

		
		
		this.btnBezar.addActionListener(this);
		this.btnModosit.addActionListener(this);
		table.getSelectionModel().addListSelectionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Bezar")) {
			dispose();
			setVisible(false);
		}

		if (e.getActionCommand().equals("Modosit")) {
			
			
			if (!BC.filled(this.textFieldNev) && !BC.filled(this.textFieldSzid) && !BC.filled(this.textFieldLakh)
					&& !BC.filled(this.textFieldIQ))
				BC.showMD("Egyetlen módosító adat sincs beírva!", 0);
			else if (BC.filled(this.textFieldSzid) && !BC.goodDate(this.textFieldSzid))
				BC.showMD("A Születési idő mezőben hibás adat van!", 0);
			else if (BC.filled(this.textFieldIQ) && !BC.goodInt(this.textFieldIQ))
				BC.showMD("Az IQ mezőben hibás adat van!", 0);
			else {
				int db = 0, jel = 0, x = 0;
				for (x = 0; x < etm.getRowCount(); x++)
					if ((Boolean) etm.getValueAt(x, 0)) {
						db++;
						jel = x;
					}
				if (db == 0)
					BC.showMD("Nincs kijelölve a módosítandó rekord!", 0);
				if (db > 1)
					BC.showMD("Több rekord van kijelölve!\nEgyszerre csak egy rekord módosítható!", 0);
				if (db == 1) {
					if (BC.filled(this.textFieldNev))
						etm.setValueAt(BC.RF(this.textFieldNev), jel, 2);
					if (BC.filled(this.textFieldSzid))
						etm.setValueAt(BC.RF(this.textFieldSzid), jel, 3);
					if (BC.filled(this.textFieldLakh))
						etm.setValueAt(BC.RF(this.textFieldLakh), jel, 4);
					if (BC.filled(this.textFieldIQ))
						etm.setValueAt(BC.RF(this.textFieldIQ), jel, 5);
					BC.showMD("A rekord módosítva!", 1);
					BC.DF(this.textFieldNev);
					BC.DF(this.textFieldSzid);
					BC.DF(this.textFieldLakh);
					BC.DF(this.textFieldIQ);
					etm.setValueAt(new Boolean(false), jel, 0);
				}
			}
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
        if(!table.getSelectionModel().isSelectionEmpty()) {
			 int row = table.getSelectedRow();
	         
	         this.textFieldNev.setText(table.getModel().getValueAt(row, 2).toString());
		     this.textFieldSzid.setText(table.getModel().getValueAt(row, 3).toString());
		     this.textFieldLakh.setText(table.getModel().getValueAt(row, 4).toString());
		     this.textFieldIQ.setText(table.getModel().getValueAt(row, 5).toString());
        }
	}
}
