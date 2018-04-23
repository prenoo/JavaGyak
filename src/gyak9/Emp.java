package gyak9;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {
	private static final long serialVersionUID = 1L;
	private int kod;
	private String nev;
	private Date szulido;
	private String lakohely;
	private int iq;

	public Emp(int kod, String nev, Date szulido, String lakohely, int iq) {
		this.kod = kod;
		this.nev = nev;
		this.szulido = szulido;
		this.lakohely = lakohely;
		this.iq = iq;
	}

	public int getKod() {
		return kod;
	}

	public String getNev() {
		return nev;
	}

	public Date getSzulido() {
		return szulido;
	}

	public String getLakohely() {
		return lakohely;
	}

	public int getIq() {
		return iq;
	}

}
