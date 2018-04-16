package gui;

import java.util.ArrayList;

public class EmpPrg {
	private static ArrayList<Emp> emp = new ArrayList<Emp>();

	public static void main(String[] args) {
		emp.add(new Emp("Kis B�la", 250000));
		emp.add(new Emp("J� Zoli", 325000));
		emp.add(new Emp("S� B�la Peti", 99000));
		emp.add(new Emp("B�la Tomi", 420000));

		Emp.print(emp);
		Emp.sortNev(emp);
		Emp.sortFiz(emp);
		Emp.search(emp, "Kis B�la");
		Emp.searchFirstName(emp, "B�la");
	}
}