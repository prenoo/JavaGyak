package tipper;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class TipperGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldTipp;
	private JTextField textFieldInfo;
	private JButton btnTippelek;
	private JButton btnReset;
	private JButton btnBezar;
	
	private Tipper tipp;
	private int rndNum; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipperGUI frame = new TipperGUI();
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
	public TipperGUI() {
		setTitle("Tippel\u0151s, kital\u00E1l\u00F3s");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAProgramGenerl = new JLabel("A program gener\u00E1l egy v\u00E9letlen sz\u00E1mot a 0-100 tartom\u00E1nyban.");
		lblAProgramGenerl.setBounds(22, 31, 481, 25);
		lblAProgramGenerl.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblAProgramGenerl);
		
		JLabel lblEztKellKitallnod = new JLabel("Ezt kell kital\u00E1lnod. Tippelj \u00E9s kapsz inf\u00F3t a tippedr\u0151l.");
		lblEztKellKitallnod.setBounds(22, 58, 440, 25);
		lblEztKellKitallnod.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblEztKellKitallnod);
		
		textFieldTipp = new JTextField();
		textFieldTipp.setBounds(67, 110, 116, 22);
		contentPane.add(textFieldTipp);
		textFieldTipp.setColumns(10);
		
		JLabel lblTipp = new JLabel("Tipp:");
		lblTipp.setBounds(22, 113, 56, 16);
		lblTipp.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblTipp);
		
		JLabel lblInf = new JLabel("Inf\u00F3:");
		lblInf.setBounds(22, 172, 56, 16);
		lblInf.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblInf);
		
		textFieldInfo = new JTextField();
		textFieldInfo.setBounds(67, 169, 330, 22);
		contentPane.add(textFieldInfo);
		textFieldInfo.setColumns(10);
		
		btnBezar = new JButton("Bez\u00E1r");
		btnBezar.setBounds(178, 224, 97, 25);
		btnBezar.setActionCommand("bezar");
		contentPane.add(btnBezar);
		
		btnTippelek = new JButton("Tippelek");
		btnTippelek.setBounds(208, 109, 97, 25);
		contentPane.add(btnTippelek);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(317, 109, 97, 25);
		contentPane.add(btnReset);
		
		this.btnBezar.addActionListener(this);
		this.btnReset.addActionListener(this);
		this.btnTippelek.addActionListener(this);
		
		this.tipp = new Tipper();
		rndNum = tipp.randomNumber();
		tipp.setRndNum(rndNum);
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("bezar")) {
			System.exit(0);
		}
		
		if (e.getActionCommand().equals("Tippelek")) {
			String text = this.textFieldTipp.getText();

			if (text.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Üres a tipp mezõ!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				try {
					int number = Integer.parseInt(text);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Ez nem szám!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// System.out.println(rndNum);

				if (tipp.check(text)) {
					this.textFieldInfo.setText(tipp.evaluate(text));
				}
			}
		}
		
		
		if(e.getActionCommand().equals("Reset")) {
			rndNum = tipp.randomNumber();
			tipp.setRndNum(rndNum);
			tipp.setDb(0);
			tipp.resetAll();
			
			this.textFieldInfo.setText("");
			this.textFieldTipp.setText("");
		}	
	}
	
}