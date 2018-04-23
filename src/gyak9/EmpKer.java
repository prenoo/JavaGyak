package gyak9;

public class EmpKer {

	public static boolean KeyCheck(String mezo, String key) {

		boolean vi = false;
		Character fc = ' ';
		String fs = "";
		if (mezo.equals("kod")) {
			if (key.substring(0, 1).equals("="))
				key = key.substring(1, key.length());
			vi = goodStoInt(key);
		}

		if (mezo.equals("nev")) {
			fs = key.substring(0, 1);
			if (Character.isLetter(key.charAt(0)) || fs.equals(" "))
				vi = true;
		}

		if (mezo.equals("lak")) {
			if (Character.isLetter(key.charAt(0)))
				vi = true;
		}

		if (mezo.equals("iq")) {
			fs = key.substring(0, 1);
			fc = key.charAt(0);
			if (fs.equals("<") || fs.equals(">") || fs.equals("=")) {
				if (key.length() > 1 && goodStoInt(key.substring(1, key.length())))
					vi = true;
				else
					vi = false;
			}
			if (Character.isDigit(fc) && key.indexOf("..") > 0) {
				int x = key.indexOf("..");
				String k1 = key.substring(0, x);
				String k2 = key.substring(x + 2, key.length());
				if (goodStoInt(k1) && goodStoInt(k2))
					vi = true;
				else
					vi = false;
			}
		}
		return vi;
	}

	public static EmpTM Select(EmpTM etm, String mezo, String key) {
		Object emptmn[] = { "Jel", "Kód", "Név", "Szülidő", "Lakóhely", "IQ" };
		EmpTM kertm = new EmpTM(emptmn, 0);
		String k = "", k1 = "", k2 = "";
		int x = 0;

		if (mezo.equals("kod") && key.substring(0, 1).equals("="))
			key = key.substring(1, key.length());
		if (mezo.equals("iq"))
			k = key.substring(1, key.length());
		if (mezo.equals("iq") && key.indexOf("..") > 0) {
			x = key.indexOf("..");
			k1 = key.substring(0, x);
			k2 = key.substring(x + 2, key.length());
		}

		for (int i = 0; i < etm.getRowCount(); i++) {
			if (mezo.equals("kod") && key.equals(etm.getValueAt(i, 1).toString()))
				Pack(etm, kertm, i);
			if (mezo.equals("nev") && etm.getValueAt(i, 2).toString().indexOf(key) >= 0)
				Pack(etm, kertm, i);
			if (mezo.equals("lak") && key.equals(etm.getValueAt(i, 4).toString()))
				Pack(etm, kertm, i);
			if (mezo.equals("iq") && key.substring(0, 1).equals("=") && k.equals(etm.getValueAt(i, 5).toString()))
				Pack(etm, kertm, i);
			if (mezo.equals("iq") && key.substring(0, 1).equals(">")
					&& BC.StoI(k) < BC.StoI(etm.getValueAt(i, 5).toString()))
				Pack(etm, kertm, i);
			if (mezo.equals("iq") && key.substring(0, 1).equals("<")
					&& BC.StoI(k) > BC.StoI(etm.getValueAt(i, 5).toString()))
				Pack(etm, kertm, i);
			if (mezo.equals("iq") && key.indexOf("..") > 0) {
				String s = etm.getValueAt(i, 5).toString();
				if (BC.StoI(k1) < BC.StoI(s) && BC.StoI(k2) > BC.StoI(s))
					Pack(etm, kertm, i);
			}
		} // == for ciklus vége
		return kertm;
	}

	public static void Pack(EmpTM etm, EmpTM kertm, int row) {
		kertm.addRow(new Object[] { new Boolean(false), BC.StoI(etm.getValueAt(row, 1).toString()),
				etm.getValueAt(row, 2).toString(), etm.getValueAt(row, 3).toString(), etm.getValueAt(row, 4).toString(),
				BC.StoI(etm.getValueAt(row, 5).toString()) });
	}

	public static boolean goodStoInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}