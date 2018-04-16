package gyak8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintStream;

import javax.swing.JOptionPane;

public class FileManager {
	private static String mes = "Emp program �zenet";

	public static void CsvReader(File fnev, EmpTM etm) {
		String kod = "", nev = "", szido = "", lakh = "", iq = "", s = "";

		try {
			FileInputStream f = new FileInputStream(fnev);
			LineNumberReader in = new LineNumberReader(new InputStreamReader(f));

			s = in.readLine(); // === mez�nevek az els� sorban
			s = in.readLine(); // === adatsor
			while (s != null) {
				String[] splitS = s.split(";");
				kod = splitS[0];
				nev = splitS[1];
				szido = splitS[2];
				lakh = splitS[3];
				iq = splitS[4];

				etm.addRow(new Object[] { new Boolean(false), StoI(kod), nev, szido, lakh, StoI(iq) });
				s = in.readLine();
			}
			in.close();
			JOptionPane.showMessageDialog(null, "Adatok beolvasva!", mes, 1);
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "CsvReader: " + ioe.getMessage(), mes, 0);
		}
	}

	public static int StoI(String s) {
		int x = -55;
		x = Integer.parseInt(s);
		return x;
	}

	public static void CsvWriter(String fnev, EmpTM etm) {
		  try {
		    PrintStream out = new PrintStream(new FileOutputStream(fnev));
		    out.println("Kód;Név;Szülidő;Lakóhely;IQ");
		    int rdb = etm.getRowCount();
		    int cdb = etm.getColumnCount();
		    for (int i=0; i < rdb; i++) { 
		      for (int j=1; j < cdb-1; j++) {
		        out.print(""+etm.getValueAt(i,j)+";"); 
		      }
		      out.println(""+etm.getValueAt(i, cdb-1)); 
		    }
		    out.close();
		    JOptionPane.showMessageDialog(null, "Adatok kiírva!", mes, 1);
		  } catch (IOException ioe) {
		    JOptionPane.showMessageDialog(null, "CsvWriter: "+
		                                      ioe.getMessage(), mes, 0);
		  }
		}


}