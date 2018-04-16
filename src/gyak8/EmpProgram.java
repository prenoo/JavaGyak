package gyak8;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EmpProgram extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnBezar;
	private JButton btnLista;
	private JButton btnBetoltes;
	private JComboBox comboBoxForras;
	private JTextField textFieldFileName;
	private JTextField fdb;

	private String forras = "Válasszon!";
	private String elem[] = { "Válasszon!", "Helyi .dat fájl", "Helyi .xml fájl", "Helyi .csv fájl", "SQLite DB",
			"Web: JSON fájl" };
	private String mes = "Emp program üzenet";
	private File fbe;
	private EmpTM etm;
	private JButton ujadat;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

	private JTextField kifnev;

	private String cel = "Válasszon!";
	private JComboBox jcbc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpProgram frame = new EmpProgram();
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
	public EmpProgram() {
		setTitle("Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 525);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnBetoltes = new JButton("Bet\u00F6lt\u00E9s");
		btnBetoltes.setToolTipText("Adatok bet\u00F6lt\u00E9se.");
		btnBetoltes.setActionCommand("Betoltes");
		btnBetoltes.setBounds(28, 34, 97, 25);
		contentPane.add(btnBetoltes);

		btnLista = new JButton("Lista");
		btnLista.setBounds(28, 68, 97, 25);
		contentPane.add(btnLista);

		btnBezar = new JButton("Bez\u00E1r");
		btnBezar.setActionCommand("Bezar");
		btnBezar.setBounds(624, 440, 97, 25);
		contentPane.add(btnBezar);

		JLabel lblForrs = new JLabel("Forr\u00E1s");
		lblForrs.setBounds(148, 38, 97, 16);
		contentPane.add(lblForrs);

		JLabel lblAdatokSzma = new JLabel("Adatok sz\u00E1ma:");
		lblAdatokSzma.setBackground(Color.WHITE);
		lblAdatokSzma.setBounds(148, 72, 97, 16);
		contentPane.add(lblAdatokSzma);

		comboBoxForras = new JComboBox();
		comboBoxForras.setToolTipText("");
		// comboBoxForras.setModel(new DefaultComboBoxModel(new String[]
		// {"V\u00E1lasszon!", "Helyi .dat f\u00E1jl", "Helyi .xml f\u00E1jl",
		// "Helyi
		// .csv f\u00E1jl", "SQLite DB,", "Web: JSON f\u00E1jl"}));
		for (String s : elem)
			this.comboBoxForras.addItem(s);

		comboBoxForras.setBounds(242, 35, 184, 22);
		contentPane.add(comboBoxForras);

		textFieldFileName = new JTextField();
		textFieldFileName.setEditable(false);
		textFieldFileName.setBounds(455, 35, 229, 22);
		contentPane.add(textFieldFileName);
		textFieldFileName.setColumns(10);

		fdb = new JTextField();
		fdb.setHorizontalAlignment(SwingConstants.RIGHT);
		fdb.setText("0");
		fdb.setBounds(242, 69, 184, 22);
		contentPane.add(fdb);
		fdb.setColumns(10);

		ujadat = new JButton("Új adat");
		ujadat.setActionCommand("ujAdat");
		ujadat.setBounds(28, 106, 97, 25);
		contentPane.add(ujadat);

		JButton modosit = new JButton("Módosítás");
		modosit.setActionCommand("ujAdat");
		modosit.setBounds(28, 142, 97, 25);
		contentPane.add(modosit);

		JButton torol = new JButton("Törlés");
		torol.setActionCommand("ujAdat");
		torol.setBounds(28, 178, 97, 25);
		contentPane.add(torol);

		JButton kiir = new JButton("Kiírás");
		kiir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cel.equals("Válasszon!"))
					SMD("Először válassza ki a Cél-t!");
				else if (etm.getRowCount() == 0)
					SMD("Nincs kiírható adat");
				else if (cel.equals("Helyi .csv fájl")) {
					if (kifnev.getText().length() == 0)
						SMD("Nincs megadva a cél fájl neve!");
					else {
						FileManager.CsvWriter(kifnev.getText().toString(), etm);
					}
				}
			}
		});
		
		kiir.setActionCommand("ujAdat");
		kiir.setBounds(28, 214, 97, 25);
		contentPane.add(kiir);

		JLabel lblCl = new JLabel("Cél:");
		lblCl.setBounds(180, 219, 46, 14);
		contentPane.add(lblCl);




		kifnev = new JTextField();
		kifnev.setBounds(455, 216, 229, 20);
		contentPane.add(kifnev);
		kifnev.setColumns(10);
		
		jcbc = new JComboBox();
		jcbc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String elem2[] = {"Válasszon!",">>> Forrás","Helyi .dat fájl",
				          "Helyi .xml fájl","Helyi .csv fájl","Helyi .json fájl",
				                                   "Helyi .pdf fájl","SQLite DB"};
				JComboBox jcbc = new JComboBox();
				for (String s: elem2) jcbc.addItem(s);
				jcbc.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent arg0) {
				    cel = (String)jcbc.getSelectedItem();
				  }
				});



			}
		});
		jcbc.setBounds(242, 216, 184, 20);
		contentPane.add(jcbc);

		addListeners();

		// tablazat: oszlopok letrehozasa, 0 sor
		Object emptmn[] = { "Jel", "Kód", "Név", "Szülidő", "Lakóhely", "IQ" };
		etm = new EmpTM(emptmn, 0);

	}

	public void addListeners() {
		this.btnBezar.addActionListener(this);
		this.btnBetoltes.addActionListener(this);
		this.btnLista.addActionListener(this);
		this.comboBoxForras.addActionListener(this);
		this.ujadat.addActionListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Bezar")) {
			System.exit(0);
		}

		if (e.getActionCommand().equals("Betoltes")) {
			if (forras.equals("Válasszon!")) {
				JOptionPane.showMessageDialog(null, "Először válassza ki a Forrás-t!", mes, 0);
			}

			if (forras.equals("Helyi .csv fájl")) {
				FileDialog fd = new FileDialog(new EmpProgram(), "Fájl kiválasztása", FileDialog.LOAD);

				fd.setFile("*.csv");
				fd.show();

				if (fd.getFile() != null) {
					fbe = new File(fd.getDirectory(), fd.getFile());
					String befnev = fd.getFile();
					this.textFieldFileName.setText(befnev);
					FileManager.CsvReader(fbe, etm);
					fdb.setText("" + etm.getRowCount());
				}
			}

		}

		if (e.getActionCommand().equals("Lista")) {
			EmpList el = new EmpList(EmpProgram.this, etm);
			el.setVisible(true);

		}

		if (e.getActionCommand().equals("comboBoxChanged")) {
			forras = (String) this.comboBoxForras.getSelectedItem();
			this.textFieldFileName.setText(forras);
			// this.textFieldDataNumber.setText("4");
		}

		if (e.getActionCommand().equals("ujAdat")) {
			int kodv = 0;
			EmpNew en = new EmpNew(EmpProgram.this, kodv);
			en.setVisible(true);

			if (etm.getRowCount() == 0)
				kodv = 20;
			else
				kodv = (int) etm.getValueAt(etm.getRowCount() - 1, 1);

			int kilep = en.KiLep();
			if (kilep == 1) {
				Emp newEmp = en.getEmp();
				Date d = newEmp.getSzulido();
				String ddd = sdf.format(d).toString();
				etm.addRow(new Object[] { new Boolean(false), newEmp.getKod(), newEmp.getNev(), ddd,
						newEmp.getLakohely(), newEmp.getIq() });
				fdb.setText("" + etm.getRowCount());
			}
		}

	}

	public void SMD(String s) {
		JOptionPane.showMessageDialog(null, s, mes, 0);
	}

}
