package szamologep;

import javax.swing.*;

public class CalcController {
	private static String clm = "Calc program message";
	CalcModel cm = new CalcModel();

	public boolean textFieldChecker(JTextField jtf) {
		String s = readJTF(jtf);
		if (s.length() == 0) {
			showMD("Nincs beírva adat!", 0);
			return false;
		} else if (goodInt(s))
			return true;
		else {
			showMD("A beírt adat nem alakítható egész számmá!", 0);
			return false;
		}
	}

	public String readJTF(JTextField a) {
		return a.getText().toString();
	}

	public void calc(JTextField a, JTextField b) {
		int av = StoI(readJTF(a));
		int bv = StoI(readJTF(b));
		cm.operation(av, bv);
		int x = cm.getValue();
		b.setText(Integer.toString(x));
	}

	public void reset(JTextField a, JTextField b) {
		cm.reset();
		a.setText("");
		int x = cm.getValue();
		b.setText(Integer.toString(x));
	}

	public boolean goodInt(String s) {
		int x;
		try {
			x = Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public int StoI(String s) {
		return Integer.parseInt(s);
	}

	public void showMD(String s, int i) {
		JOptionPane.showMessageDialog(null, s, clm, i);
	}
}