package gyak2;

public class Emp {
	private String nev;
	private int fiz;
	
	public Emp(String nev, int fiz) {
		this.nev = nev;
		this.fiz = fiz;
	}
	
	public String getNev() {	
		return nev;
	}
	
	public int getFiz() {
		return fiz;
	}

	@Override
	public String toString() {
		return nev + ", " + fiz;
	}
	
	public static void print(Emp[] emp) {
		System.out.println();
		for (int i = 0; i < emp.length; i++) {
			System.out.println(emp[i]);
		}
	}
	
	public static void sortNev(Emp[] t) {
		for (int i = 0; i < t.length-1; i++) {
			for (int j = i+1; j < t.length; j++) {
				if(t[i].nev.compareTo(t[j].nev) > 0) {
					Emp e = t[i];
					t[i] = t[j];
					t[j] = e;
				}
			}
		}
		print(t);
	}
	
	public static void sortFiz(Emp[] t) {
		for (int i = 0; i < t.length-1; i++) {
			for (int j = i+1; j < t.length; j++) {
				if(t[i].fiz > t[j].fiz) {
					Emp e = t[i];
					t[i] = t[j];
					t[j] = e;
				}
			}
		}
		print(t);
	}
	
	public static void search(Emp[] t, String nev) {
		int db = 0;
		for (int i = 0; i < t.length; i++) {
			if(t[i].nev.equals(nev)) {
				System.out.println("Talalt: " + t[i].toString());
				db++;
			}
		}
		if (db == 0)
			System.out.println("Nem volt ilyen nev: " + nev);
	}
}