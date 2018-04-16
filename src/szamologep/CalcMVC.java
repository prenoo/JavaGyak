package szamologep;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CalcMVC extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldNumber;
	private JTextField textFieldRes;
	private JButton btnSzorzas;
	private JButton btnReset;
	private JButton btnBezar;

	private CalcController cc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcMVC frame = new CalcMVC();
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
	public CalcMVC() {
		setTitle("Sz\u00E1mol\u00F3g\u00E9pecske");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSzm = new JLabel("Sz\u00E1m:");
		lblSzm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSzm.setBounds(12, 31, 56, 16);
		contentPane.add(lblSzm);

		textFieldNumber = new JTextField();
		textFieldNumber.setBounds(63, 28, 144, 22);
		contentPane.add(textFieldNumber);
		textFieldNumber.setColumns(10);

		JLabel lblEredmny = new JLabel("Eredm\u00E9ny:");
		lblEredmny.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEredmny.setBounds(12, 80, 116, 16);
		contentPane.add(lblEredmny);

		textFieldRes = new JTextField();
		textFieldRes.setEditable(false);
		textFieldRes.setBounds(91, 77, 116, 22);
		contentPane.add(textFieldRes);
		textFieldRes.setColumns(10);

		btnSzorzas = new JButton("Szorzas");
		btnSzorzas.setBounds(233, 55, 97, 25);
		contentPane.add(btnSzorzas);

		btnReset = new JButton("Reset");
		btnReset.setBounds(31, 136, 97, 25);
		contentPane.add(btnReset);

		btnBezar = new JButton("Bez\u00E1r");
		btnBezar.setActionCommand("Bezar");
		btnBezar.setBounds(140, 136, 97, 25);
		contentPane.add(btnBezar);

		this.cc = new CalcController();

		addListeners();

		this.textFieldRes.setText("1");
	}
	

	public void addListeners() {
		this.btnBezar.addActionListener(this);
		this.btnReset.addActionListener(this);
		this.btnSzorzas.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Bezar")) {
			System.exit(0);
		}

		if (e.getActionCommand().equals("Szorzas")) {
			if (cc.textFieldChecker(textFieldNumber)) {
				cc.calc(this.textFieldNumber, this.textFieldRes);
			}
		}

		if (e.getActionCommand().equals("Reset")) {
			cc.reset(this.textFieldNumber, this.textFieldRes);
		}
	}
	
}