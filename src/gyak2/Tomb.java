package gyak2;

public class Tomb {
	
	private static String[] nev = new String[4];
	private static int[] fiz = new int[4];
	
	public static void main(String[] args) {
		nev[0] = "Horvath Bela";
		fiz[0] = 88000;
		nev[1] = "Nagy Attila";
		fiz[1] = 260000;
		nev[2] = "Kiss Zoltan";
		fiz[2] = 130000;
		nev[3] = "Elek Zoltan";
		fiz[3] = 660000;
		
		print();
		sortNev();
		System.out.println("\nNév alapján rendezve");
		print();
		sortFiz();
		System.out.println("\nFizetés alapján rendezve");
		print();
		
		search("Horvath Bela");
		search("Hosszu Katinka");
		searchFirstName("Zoltan");
	}
	
	private static void sortNev() {
		for (int i = 0; i < 3; i++) {
			for (int j = i+1; j < 4; j++) {
				if(nev[i].compareTo(nev[j]) >=0) {
					String s = nev[i];
					nev[i] = nev[j];
					nev[j] = s;
					int f = fiz[i];
					fiz[i] = fiz[j];
					fiz[j] = f;
				}
			}
		}
	}
	
	private static void sortFiz() {
		for (int i = 0; i < fiz.length-1; i++) {
			for (int j = i+1; j < (fiz.length); j++) {
				if(fiz[i] >= fiz[j]) {
					String s = nev[i];
					nev[i] = nev[j];
					nev[j] = s;
					int fizu = fiz[i];
					fiz[i] = fiz[j];
					fiz[j] = fizu;
				}		
			}
		}		
	}
	
	private static void print() {
		for (int i = 0; i < fiz.length; i++) {
			System.out.println(nev[i] + ", " + fiz[i]);
		}
	}
	
	private static void search(String str) {
		int db = 0;
		for (int i = 0; i < nev.length; i++) {
			if(nev[i].equals(str)) {
				System.out.println("Talalt: " + nev[i] + ", " + fiz[i]);
				db++;
			}
		}
		if (db == 0)
			System.out.println("Nem volt ilyen nev: " + str);
	}
	
	private static void searchFirstName(String str) {
		int db = 0;
		for (int i = 0; i < nev.length; i++) {
			if(nev[i].contains(str)) {
				System.out.println("Talalt " + str + ":"  + nev[i] + ", " + fiz[i]);
				db++;
			}
		}
		if (db == 0)
			System.out.println("\nNem volt ilyen nev: " + str);
	}
}
