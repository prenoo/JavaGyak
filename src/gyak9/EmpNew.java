package gyak9;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpNew extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLakohely;
	private JTextField textFieldIQ;
	private JButton btnBeszur;
	private JButton btnBezar;
	private JButton btnLeker;
	private JTextField textFieldKod;
	private JTextField textFieldNev;
	private JTextField textFieldSzulIdo;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	private String mes = "Emp program üzenet";

	private int maxKod;
	private int kilep;
	private Emp adat;

	/**
	 * Create the dialog.
	 */
	public EmpNew(JFrame f, int maxKod) {
		super(f, true);
		setTitle("\u00DAj dolgoz\u00F3 felvitele");

		setBounds(100, 100, 383, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblKd = new JLabel("Kód:");
		lblKd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKd.setBounds(12, 13, 56, 16);
		contentPanel.add(lblKd);

		textFieldKod = new JTextField();
		textFieldKod.setEditable(false);
		textFieldKod.setBounds(60, 10, 182, 22);
		contentPanel.add(textFieldKod);
		textFieldKod.setColumns(10);
		{
			btnLeker = new JButton("Lekér");
			btnLeker.setActionCommand("Leker");
			btnLeker.setBounds(254, 9, 97, 25);
			contentPanel.add(btnLeker);
		}

		JLabel lblNv = new JLabel("Név:");
		lblNv.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNv.setBounds(12, 55, 56, 16);
		contentPanel.add(lblNv);

		textFieldNev = new JTextField();
		textFieldNev.setBounds(60, 52, 182, 22);
		contentPanel.add(textFieldNev);
		textFieldNev.setColumns(10);

		JLabel lblSzletsiId = new JLabel("Születési idő:");
		lblSzletsiId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSzletsiId.setBounds(12, 102, 88, 16);
		contentPanel.add(lblSzletsiId);

		textFieldSzulIdo = new JTextField();
		textFieldSzulIdo.setBounds(113, 99, 129, 22);
		contentPanel.add(textFieldSzulIdo);
		textFieldSzulIdo.setColumns(10);

		JLabel lblhhnn = new JLabel("éééé.hh.nn");
		lblhhnn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblhhnn.setBounds(254, 102, 97, 16);
		contentPanel.add(lblhhnn);

		JLabel lblLakhely = new JLabel("Lakóhely:");
		lblLakhely.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLakhely.setBounds(12, 146, 109, 16);
		contentPanel.add(lblLakhely);

		textFieldLakohely = new JTextField();
		textFieldLakohely.setBounds(80, 143, 163, 22);
		contentPanel.add(textFieldLakohely);
		textFieldLakohely.setColumns(10);

		JLabel lblIq = new JLabel("IQ:");
		lblIq.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIq.setBounds(12, 186, 56, 16);
		contentPanel.add(lblIq);

		textFieldIQ = new JTextField();
		textFieldIQ.setBounds(80, 183, 163, 22);
		contentPanel.add(textFieldIQ);
		textFieldIQ.setColumns(10);

		btnBeszur = new JButton("Beszúr");
		btnBeszur.setActionCommand("Beszur");
		btnBeszur.setBounds(82, 266, 97, 25);
		contentPanel.add(btnBeszur);

		btnBezar = new JButton("Bezár");
		btnBezar.setActionCommand("Bezar");
		btnBezar.setBounds(211, 266, 97, 25);
		contentPanel.add(btnBezar);

		this.btnBeszur.addActionListener(this);
		this.btnBezar.addActionListener(this);
		this.btnLeker.addActionListener(this);

		this.maxKod = maxKod;
	}

	public String RF(JTextField a) {
		return a.getText().toString();
	}

	public boolean filled(JTextField a) {
		String s = RF(a);
		if (s.length() > 0)
			return true;
		else
			return false;
	}

	public boolean goodDate(JTextField a) {
		String s = RF(a);
		Date testDate = null;
		try {
			testDate = sdf.parse(s);
		} catch (ParseException e) {
			return false;
		}
		if (sdf.format(testDate).equals(s))
			return true;
		else
			return false;
	}

	public boolean goodInt(JTextField a) {
		String s = RF(a);
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void showMD(String s, int i) {
		JOptionPane.showMessageDialog(null, s, mes, i);
	}

	public Date StoD(String s) {
		Date testDate = null, vid = null;
		try {
			testDate = sdf.parse(s);
		} catch (ParseException e) {
			return vid;
		}
		if (!sdf.format(testDate).equals(s)) {
			return vid;
		}
		return testDate;
	}

	public int StoI(String s) {
		int x = -49;
		x = Integer.parseInt(s);
		return x;
	}

	public Emp getEmp() {
		return adat;
	}

	public int KiLep() {
		return kilep;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Bezar")) {
			dispose();
			setVisible(false);
		}

		if (e.getActionCommand().equals("Leker")) {
			this.textFieldKod.setText("" + (maxKod + 1));
		}

		if (e.getActionCommand().equals("Beszur")) {
			if (!filled(this.textFieldKod))
				this.textFieldKod.setText("" + (maxKod + 1));
			if (!filled(this.textFieldNev))
				showMD("A Név mező üres!", 0);
			else if (!filled(this.textFieldSzulIdo))
				showMD("A Születési idő mező üres!", 0);
			else if (!goodDate(this.textFieldSzulIdo))
				showMD("A Születési idő mezőben hibás adat van!", 0);
			else if (!filled(this.textFieldLakohely))
				showMD("A Lakóhely mező üres!", 0);
			else if (!filled(this.textFieldIQ))
				showMD("Az IQ mező üres!", 0);
			else if (!goodInt(this.textFieldIQ))
				showMD("Az IQ mezőben hibás adat van!", 0);
			else {
				adat = new Emp(StoI(RF(this.textFieldKod)), RF(this.textFieldNev), StoD(RF(this.textFieldSzulIdo)),
						RF(this.textFieldLakohely), StoI(RF(this.textFieldIQ)));
				showMD("Adat beszúrva!", 1);
				kilep = 1;
				dispose();
				setVisible(false);
			}

		}

	}
}