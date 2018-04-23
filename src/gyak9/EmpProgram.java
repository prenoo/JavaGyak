package gyak9;

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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;

public class EmpProgram extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnBezar;
	private JButton btnLista;
	private JButton btnBetoltes;
	private JComboBox comboBoxForras;
	private JTextField textFieldFileName;
	private JTextField textFieldDataNumber;
	private String kerkif = "kod";

	private String forras = "Válasszon!";
	private String elem[] = { "Válasszon!", "Helyi .dat fájl", "Helyi .xml fájl", "Helyi .csv fájl", "SQLite DB",
			"Web: JSON fájl" };
	private String mes = "Emp program üzenet";
	private File fbe;
	private EmpTM etm;
	private JButton btnujAdat;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	private JButton btnModositas;
	private JButton btnTorles;
	private JButton btnKiiras;
	private JComboBox jcbc;
	private JTextField textFieldkifnev;
	private EmpTM kertm;


	private String cel = "Válasszon!";
	String elem2[] = { "Válasszon!", ">>> Forrás", "Helyi .dat fájl", "Helyi .xml fájl", "Helyi .csv fájl",
			"Helyi .json fájl", "Helyi .pdf fájl", "SQLite DB" };
	private JTextField textFieldKulcs;
	private JButton btnKereses;
	private JRadioButton rdbtnKod;
	private JRadioButton rdbtnNev;
	private JRadioButton rdbtnLakhely;
	private JRadioButton rdbtnIq;

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
		setTitle("Melós nyilvántartó");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 350);
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
		btnBezar.setBounds(587, 265, 97, 25);
		contentPane.add(btnBezar);

		JLabel lblForrs = new JLabel("Forr\u00E1s");
		lblForrs.setBounds(148, 38, 97, 16);
		contentPane.add(lblForrs);

		JLabel lblAdatokSzma = new JLabel("Adatok sz\u00E1ma:");
		lblAdatokSzma.setBackground(Color.WHITE);
		lblAdatokSzma.setBounds(148, 72, 97, 16);
		contentPane.add(lblAdatokSzma);

		comboBoxForras = new JComboBox();
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

		textFieldDataNumber = new JTextField();
		textFieldDataNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldDataNumber.setText("0");
		textFieldDataNumber.setBounds(242, 69, 184, 22);
		contentPane.add(textFieldDataNumber);
		textFieldDataNumber.setColumns(10);

		btnujAdat = new JButton("Új adat");
		btnujAdat.setActionCommand("ujAdat");
		btnujAdat.setBounds(28, 106, 97, 25);
		contentPane.add(btnujAdat);

		btnModositas = new JButton("Módosítás");
		btnModositas.setActionCommand("Modositas");
		btnModositas.setBounds(28, 144, 97, 25);
		contentPane.add(btnModositas);

		btnTorles = new JButton("Törlés");
		btnTorles.setActionCommand("Torles");
		btnTorles.setBounds(28, 182, 97, 25);
		contentPane.add(btnTorles);

		btnKiiras = new JButton("Kiírás");
		btnKiiras.setActionCommand("Kiiras");
		btnKiiras.setBounds(28, 220, 97, 25);
		contentPane.add(btnKiiras);

		JLabel lblCl = new JLabel("Cél:");
		lblCl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCl.setBounds(148, 224, 56, 16);
		contentPane.add(lblCl);

		jcbc = new JComboBox();
		jcbc.setActionCommand("comboBoxChangedGoal");
		jcbc.setBounds(242, 221, 184, 22);

		for (String s : elem2)
			jcbc.addItem(s);

		contentPane.add(jcbc);

		textFieldkifnev = new JTextField();
		textFieldkifnev.setBounds(455, 221, 229, 22);
		contentPane.add(textFieldkifnev);
		textFieldkifnev.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(148, 101, 536, 112);
		contentPane.add(panel);
		panel.setLayout(null);

		rdbtnNev = new JRadioButton("Név");
		rdbtnNev.setActionCommand("jrbNev");
		rdbtnNev.setBounds(68, 9, 56, 25);
		panel.add(rdbtnNev);

		rdbtnKod = new JRadioButton("Kód");
		rdbtnKod.setActionCommand("jrbKod");
		rdbtnKod.setBounds(8, 9, 56, 25);
		panel.add(rdbtnKod);

		rdbtnLakhely = new JRadioButton("Lakhely");
		rdbtnLakhely.setActionCommand("jrbLakhely");
		rdbtnLakhely.setBounds(137, 9, 83, 25);
		panel.add(rdbtnLakhely);

		rdbtnIq = new JRadioButton("IQ");
		rdbtnIq.setActionCommand("jrbIQ");
		rdbtnIq.setBounds(224, 9, 83, 25);
		panel.add(rdbtnIq);

		JLabel lblX = new JLabel("X=");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setBounds(18, 43, 56, 16);
		panel.add(lblX);

		textFieldKulcs = new JTextField();
		textFieldKulcs.setBounds(48, 43, 116, 22);
		panel.add(textFieldKulcs);
		textFieldKulcs.setColumns(10);

		btnKereses = new JButton("Keresés");
		btnKereses.setActionCommand("Kereses");
		btnKereses.setBounds(176, 43, 97, 25);
		panel.add(btnKereses);

		addListeners();

		// tablazat: oszlopok letrehozasa, 0 sor
		Object emptmn[] = { "Jel", "Kód", "Név", "Szülidő", "Lakóhely", "IQ" };
		etm = new EmpTM(emptmn, 0);

		ButtonGroup bg = new ButtonGroup();
		bg.add(this.rdbtnIq);
		bg.add(this.rdbtnNev);
		bg.add(this.rdbtnLakhely);
		bg.add(this.rdbtnKod);
	}

	public void SMD(String s) {
		JOptionPane.showMessageDialog(null, s, mes, 0);
	}

	public void addListeners() {
		this.btnBezar.addActionListener(this);
		this.btnBetoltes.addActionListener(this);
		this.btnLista.addActionListener(this);
		this.comboBoxForras.addActionListener(this);
		this.btnujAdat.addActionListener(this);
		this.jcbc.addActionListener(this);
		this.btnKiiras.addActionListener(this);
		this.btnModositas.addActionListener(this);
		this.btnTorles.addActionListener(this);
		this.btnKereses.addActionListener(this);

		this.rdbtnIq.addActionListener(this);
		this.rdbtnNev.addActionListener(this);
		this.rdbtnLakhely.addActionListener(this);
		this.rdbtnKod.addActionListener(this);
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
					textFieldDataNumber.setText("" + etm.getRowCount());
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

			if (etm.getRowCount() == 0)
				kodv = 49;
			else
				kodv = (int) etm.getValueAt(etm.getRowCount() - 1, 1);
			EmpNew en = new EmpNew(EmpProgram.this, kodv);
			en.setVisible(true);
			int kilep = en.KiLep();
			if (kilep == 1) {
				Emp newEmp = en.getEmp();
				Date d = newEmp.getSzulido();
				String ddd = sdf.format(d).toString();
				etm.addRow(new Object[] { new Boolean(false), newEmp.getKod(), newEmp.getNev(), ddd,
						newEmp.getLakohely(), newEmp.getIq() });
				this.textFieldDataNumber.setText("" + etm.getRowCount());
			}

		}

		if (e.getActionCommand().equals("comboBoxChangedGoal")) {
			cel = (String) jcbc.getSelectedItem();
		}

		if (e.getActionCommand().equals("Kiiras")) {
			if (cel.equals("Válasszon!"))
				SMD("Először válassza ki a Cél-t!");
			else if (etm.getRowCount() == 0)
				SMD("Nincs kiírható adat");
			else if (cel.equals("Helyi .csv fájl")) {
				if (this.textFieldkifnev.getText().length() == 0)
					SMD("Nincs megadva a cél fájl neve!");
				else {
					FileManager.CsvWriter(this.textFieldkifnev.getText().toString(), etm);
				}
			}
		}

		if (e.getActionCommand().equals("Modositas")) {
			if (etm.getRowCount() == 0)
				BC.showMD("Nincs módosítható adat!", 0);
			else {
				EmpMod em = new EmpMod(EmpProgram.this, etm);
				em.setVisible(true);
			}
		}

		if (e.getActionCommand().equals("Torles")) {
			if (etm.getRowCount() == 0)
				BC.showMD("Nincs törölhető adat!", 0);
			else {
				EmpDel ed = new EmpDel(EmpProgram.this, etm);
				ed.setVisible(true);
				this.textFieldDataNumber.setText("" + etm.getRowCount());
			}
		}

		if (e.getActionCommand().equals("Kereses")) {
			if (BC.RF(this.textFieldDataNumber).equals("0")) BC.showMD("Nincs betöltött adat!", 0);
			else if (!BC.filled(this.textFieldKulcs)) BC.showMD("A keresőkulcs (X=) nincs megadva!", 0);
			else if (!EmpKer.KeyCheck(kerkif, BC.RF(this.textFieldKulcs))) BC.showMD("A keresőkulcs hibásan van megadva!", 0);
			else {
			   kertm = EmpKer.Select(etm, kerkif, BC.RF(this.textFieldKulcs));
			   EmpKerP ek = new EmpKerP(EmpProgram.this, kertm, kerkif, BC.RF(this.textFieldKulcs));
			   ek.setVisible(true);
			}

		}


	

	if(e.getActionCommand().equals("jrbKod"))

	{
		if (this.rdbtnKod.isSelected())
			kerkif = "kod";
	}

	if(e.getActionCommand().equals("jrbNev"))
	{
		if (this.rdbtnNev.isSelected())
			kerkif = "nev";
	}

	if(e.getActionCommand().equals("jrbLakhely"))
	{
		if (this.rdbtnLakhely.isSelected())
			kerkif = "lak";
	}

	if(e.getActionCommand().equals("jrbIQ"))
	{
		if (this.rdbtnIq.isSelected())
			kerkif = "iq";
	}

}}
