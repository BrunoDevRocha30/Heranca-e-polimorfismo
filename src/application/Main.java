package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("");
			System.out.print("Enter the name of the employee #" + (i+1) + " ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Enter the number of hours ");
			Integer hour = sc.nextInt();
			System.out.print("Enter the value per hour ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Is this employee outsourced (y/n)? ");
			char c = sc.next().charAt(0);
			if(c == 'y') {
				System.out.println("Set the additional charge for this employee: ");
				Double additionalCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hour, valuePerHour, additionalCharge));
			}else {
				list.add(new Employee(name, hour, valuePerHour));
			}
		}
			
			System.out.println("");
			System.out.println("PAYMENTS:");
			for(Employee x : list) {
				System.out.println(x.getName() + " - $" + String.format("%.2f", x.payment()));
			}
		sc.close();
	}

}
