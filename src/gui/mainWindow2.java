package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainWindow2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow2 frame = new mainWindow2();
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
	public mainWindow2() {
		setTitle("Beolvas\u00F3, ki\u00EDr\u00F3 p\u00E9lda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblrjBeValamit = new JLabel("\u00CDrj be valamit!");
		lblrjBeValamit.setBounds(22, 25, 189, 16);
		contentPane.add(lblrjBeValamit);
		
		textField = new JTextField();
		textField.setBounds(22, 56, 318, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnKiir = new JButton("Ki\u00EDr");
		btnKiir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				JOptionPane.showMessageDialog(mainWindow2.this, "Az beírt adat: " + s);
				
			}
		});
		
		btnKiir.setBounds(77, 89, 97, 25);
		contentPane.add(btnKiir);
		
		JButton btnBezar = new JButton("Bez\u00E1r");
		btnBezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnBezar.setBounds(186, 89, 97, 25);
		contentPane.add(btnBezar);
	}
}