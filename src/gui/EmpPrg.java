package gui;

import java.util.ArrayList;

public class EmpPrg {
	private static ArrayList<Emp> emp = new ArrayList<Emp>();

	public static void main(String[] args) {
		emp.add(new Emp("Kis Béla", 250000));
		emp.add(new Emp("Jó Zoli", 325000));
		emp.add(new Emp("Só Béla Peti", 99000));
		emp.add(new Emp("Béla Tomi", 420000));

		Emp.print(emp);
		Emp.sortNev(emp);
		Emp.sortFiz(emp);
		Emp.search(emp, "Kis Béla");
		Emp.searchFirstName(emp, "Béla");
	}
}