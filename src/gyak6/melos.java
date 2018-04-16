package gyak6;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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

public class melos extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnBezar;
	private JButton btnLista;
	private JButton btnBetoltes;
	private JComboBox comboBoxForras;
	private JTextField textFieldFileName;
	private JTextField textFieldDataNumber;

	private String forras = "Válasszon!";
	private String elem[] = { "Válasszon!", "Helyi .dat fájl", "Helyi .xml fájl", "Helyi .csv fájl", "SQLite DB",
			"Web: JSON fájl" };
	private String mes = "Emp program üzenet";
	private File fbe;
	private EmpTM etm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					melos frame = new melos();
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
	public melos() {
		setTitle("Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 525);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnBetoltes = new JButton("Betöltés");
		btnBetoltes.setToolTipText("Adatok betöltése.");
		btnBetoltes.setActionCommand("Betoltes");
		btnBetoltes.setBounds(28, 34, 97, 25);
		contentPane.add(btnBetoltes);

		btnLista = new JButton("Lista");
		btnLista.setBounds(28, 68, 97, 25);
		contentPane.add(btnLista);

		btnBezar = new JButton("Bezár");
		btnBezar.setActionCommand("Bezar");
		btnBezar.setBounds(624, 440, 97, 25);
		contentPane.add(btnBezar);

		JLabel lblForrs = new JLabel("Forrás");
		lblForrs.setBounds(148, 38, 97, 16);
		contentPane.add(lblForrs);

		JLabel lblAdatokSzma = new JLabel("Adatok száma:");
		lblAdatokSzma.setBackground(Color.WHITE);
		lblAdatokSzma.setBounds(148, 72, 97, 16);
		contentPane.add(lblAdatokSzma);

		comboBoxForras = new JComboBox();

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

		addListeners();

		Object emptmn[] = { "Jel", "Kód", "Név", "Szülidõ", "Lakóhely", "IQ" };
		etm = new EmpTM(emptmn, 0);
	}

	public void addListeners() {
		this.btnBezar.addActionListener(this);
		this.btnBetoltes.addActionListener(this);
		this.btnLista.addActionListener(this);
		this.comboBoxForras.addActionListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Bezar")) {
			System.exit(0);
		}

		if (e.getActionCommand().equals("Betoltes")) {
			if (forras.equals("Válasszon!")) {
				JOptionPane.showMessageDialog(null, "Elõszõr válassza ki a forrást!", mes, 0);
			}

			if (forras.equals("Helyi .csv fájl")) {
				FileDialog fd = new FileDialog(new melos(), "Fájl kiválasztása", FileDialog.LOAD);

				fd.setFile("*.csv");
				fd.show();

				if (fd.getFile() != null) {
					fbe = new File(fd.getDirectory(), fd.getFile());
					String befnev = fd.getFile();
					this.textFieldFileName.setText(befnev);
				}
			}
		}

		if (e.getActionCommand().equals("Lista")) {
			EmpList el = new EmpList(melos.this, etm);
			el.setVisible(true);
		}

		if (e.getActionCommand().equals("comboBoxChanged")) {
			forras = (String) this.comboBoxForras.getSelectedItem();
			this.textFieldFileName.setText(forras);
			this.textFieldDataNumber.setText("4");

		}

	}
}
