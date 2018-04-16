package gyak3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

	public String toString() {
		return nev + ": " + fiz;
	}

	public static void print(ArrayList<Emp> emp) {
		System.out.println("");
		
		for (Emp e : emp)
			System.out.println(e);
	}

	public static void sortNev(ArrayList<Emp> emp) {
		Collections.sort(emp, new Comparator<Emp>() {
			public int compare(Emp e1, Emp e2) {
				return e1.nev.compareTo(e2.nev);
			}
		});
		print(emp);
	}

	public static void sortFiz(ArrayList<Emp> emp) {
		Collections.sort(emp, new Comparator<Emp>() {
			public int compare(Emp e1, Emp e2) {
				return e1.fiz - e2.fiz;
			}
		});
		print(emp);
	}

	public static void search(ArrayList<Emp> emp, String s) {
		boolean b = false;
		
		for (Emp e : emp) {
			if (e.nev.contains(s))
				b = true;
		}
		
		System.out.println("");
		
		if (b)
			System.out.println(s + ": létezik");
		else
			System.out.println(s + ": nem létezik");
	}

	public static void searchFirstName(ArrayList<Emp> emp, String s) {
		System.out.println("");
		
		for (Emp e : emp) {
			boolean b = false;
			String[] n = e.nev.split(" ");
			
			for (int j = 1; j < n.length; j++) {
				if (n[j].equals(s))
					b = true;
			}
			
			if (b)
				System.out.println(s + ": " + e.nev);
		}
	}
}