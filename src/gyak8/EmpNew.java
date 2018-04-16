package gyak8;

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
	private JTextField lak;
	private JTextField iq;
	private JButton btnBeszur;
	private JButton btnBezar;
	private JButton btnLeker;
	private JTextField kod;
	private JTextField nev;
	private JTextField szid;

	private int maxKod;

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	private static String mes = "Emp program �zenet";

	private Emp adat;
	private int kilep = 0;
	
//	public static void main(String[] args) {
//		try {
//			EmpNew dialog = new EmpNew(null, 52);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
 
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

		JLabel lblKd = new JLabel("K\u00F3d:");
		lblKd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKd.setBounds(12, 13, 56, 16);
		contentPanel.add(lblKd);

		kod = new JTextField();
		kod.setEditable(false);
		kod.setBounds(60, 10, 182, 22);
		contentPanel.add(kod);
		kod.setColumns(10);
		{
			btnLeker = new JButton("Lek\u00E9r");
			btnLeker.setActionCommand("Leker");
			btnLeker.setBounds(254, 9, 97, 25);
			contentPanel.add(btnLeker);
		}

		JLabel lblNv = new JLabel("N\u00E9v:");
		lblNv.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNv.setBounds(12, 55, 56, 16);
		contentPanel.add(lblNv);

		nev = new JTextField();
		nev.setBounds(60, 52, 182, 22);
		contentPanel.add(nev);
		nev.setColumns(10);

		JLabel lblSzletsiId = new JLabel("Sz\u00FClet\u00E9si id\u0151:");
		lblSzletsiId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSzletsiId.setBounds(12, 102, 88, 16);
		contentPanel.add(lblSzletsiId);

		szid = new JTextField();
		szid.setBounds(113, 99, 129, 22);
		contentPanel.add(szid);
		szid.setColumns(10);

		JLabel lblhhnn = new JLabel("\u00C9\u00C9\u00C9\u00C9.hh.nn");
		lblhhnn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblhhnn.setBounds(254, 102, 97, 16);
		contentPanel.add(lblhhnn);

		JLabel lblLakhely = new JLabel("Lak\u00F3hely:");
		lblLakhely.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLakhely.setBounds(12, 146, 109, 16);
		contentPanel.add(lblLakhely);

		lak = new JTextField();
		lak.setBounds(80, 143, 163, 22);
		contentPanel.add(lak);
		lak.setColumns(10);

		JLabel lblIq = new JLabel("IQ:");
		lblIq.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIq.setBounds(12, 186, 56, 16);
		contentPanel.add(lblIq);

		iq = new JTextField();
		iq.setBounds(80, 183, 163, 22);
		contentPanel.add(iq);
		iq.setColumns(10);

		btnBeszur = new JButton("Besz\u00FAr");
		btnBeszur.setActionCommand("Beszur");
		btnBeszur.setBounds(82, 266, 97, 25);
		contentPanel.add(btnBeszur);

		btnBezar = new JButton("Bez\u00E1r");
		btnBezar.setActionCommand("Bezar");
		btnBezar.setBounds(211, 266, 97, 25);
		contentPanel.add(btnBezar);

		this.btnBeszur.addActionListener(this);
		this.btnBezar.addActionListener(this);
		this.btnLeker.addActionListener(this);

		//this.maxKod = maxKod;
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
		int x = -55;
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
			this.kod.setText("" + (maxKod + 1));

		}

		if (e.getActionCommand().equals("Beszur")) {

			if (!filled(kod))
				kod.setText("" + (maxKod + 1));
			if (!filled(nev))
				showMD("A N�v mez� �res!", 0);
			else if (!filled(szid))
				showMD("A Sz�let�si id� mez� �res!", 0);
			else if (!goodDate(szid))
				showMD("A Sz�let�si id� mez�ben hib�s adat van!", 0);
			else if (!filled(lak))
				showMD("A Lak�hely mez� �res!", 0);
			else if (!filled(iq))
				showMD("Az IQ mez� �res!", 0);
			else if (!goodInt(iq))
				showMD("Az IQ mez�ben hib�s adat van!", 0);
			else {
				adat = new Emp(StoI(RF(kod)), RF(nev), StoD(RF(szid)), RF(lak), StoI(RF(iq)));
				showMD("Adat besz�rva!", 1);
				kilep = 1;
				dispose();
				setVisible(false);
			}
		}

	}
}