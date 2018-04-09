package gyak2;

public class EmpPrg {

	private static Emp[] emp = new Emp[4];
	
	public static void main(String[] args) {
		
		emp[0] = new Emp("Kiss Bela", 130000);
		emp[1] = new Emp("Hosszu Katinka", 500000);
		emp[2] = new Emp("Vincze David", 999999);
		emp[3] = new Emp("Darth Vader", 300000);
		
		Emp.print(emp);
		
		System.out.println();
		
		Emp.sortNev(emp);
		Emp.sortFiz(emp);
		
		System.out.println();
		Emp.search(emp, "Darth Vader");
		Emp.search(emp, "Darth Vodor");

	}

}
