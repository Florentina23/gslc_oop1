package oop_gslc_campus_database;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		ArrayList<String> nameList=new ArrayList<String>();
		ArrayList<Integer> yearList=new ArrayList<Integer>();
		ArrayList<Double> gpaList=new ArrayList<Double>();
		
		double totalGPA=0;
		int menu=-1;
		do {
			if(nameList.isEmpty())
				System.out.println("There is no student data to display");
			else
			{
				System.out.println("No | Name        | Year | GPA ");
				System.out.println("==============================");
				for(int i=0; i<nameList.size(); i++)
				{
					System.out.printf("%d | %s | %d | %.2f%n ", i+1, nameList.get(i), yearList.get(i), gpaList.get(i));
				}
				System.out.println("==============================");
			}
			
			System.out.println("1. Add Student data");
			System.out.println("2. Remove Student data");
			System.out.println("3. Search Student data");
			System.out.println("4. Average Student GPA");
			System.out.println("5. Exit");
			System.out.println("Choose: ");
			menu=scan.nextInt();
			scan.nextLine();
			
			switch (menu)
			{
			case 1:
				String name;
				int year;
				double gpa;
				System.out.println("Enter new student name: ");
				name=scan.nextLine();
				while(name.length()<3 || name.length()>12)
				{
					System.out.println("Student name must have minimum 3 characters and maximum 12 characters"); 
					System.out.println("Enter new student name: ");
					name=scan.nextLine();
				}
				nameList.add(name); 
				
				System.out.println("Enter new student year: ");
				year=scan.nextInt();
				while(year<2000 || year>2022)
				{
					System.out.println("Student year can only be between 2000 and 2022");
					System.out.println("Enter new student year: ");
					year=scan.nextInt();
				}
				yearList.add(year);
				
				System.out.println("Enter new student gpa: ");
				gpa=scan.nextDouble();
				while(gpa<0.0 || gpa>4.0)
				{
					System.out.println("Student GPA can only be between 0.0 and 4.0.");
					System.out.println("Enter new student gpa: ");
					gpa=scan.nextDouble();
				}
				gpaList.add(gpa);
				totalGPA=totalGPA+gpa;
				
				System.out.println("Press enter to continue.. ");
				break;
				
			case 2:
				int remove;
				if(nameList.isEmpty())
					System.out.println("There is no student data to delete");
				else
				{
					System.out.println("Enter the data number to be deleted: ");
					remove=scan.nextInt();
					if(remove>=1 && remove<=nameList.size())
					{
						nameList.remove(remove-1);
						yearList.remove(remove-1);
						gpaList.remove(remove-1);
						System.out.println("The student data has been deleted");
						if(nameList.isEmpty())
							System.out.println("There is no student data to display");
						else
						{
							System.out.println("No | Name        | Year | GPA ");
							System.out.println("==============================");
							for(int i=0; i<nameList.size(); i++)
							{
								System.out.printf("%d | %s | %d | %.2f%n ", i+1, nameList.get(i), yearList.get(i), gpaList.get(i));
							}
							System.out.println("==============================");
						}
						System.out.println("Press enter to continue.. ");
						totalGPA=totalGPA-gpaList.get(remove-1);
					}
					else System.out.println("There is no student data in that data number");
				}
				break;
				
			case 3:
				String search;
				if(nameList.isEmpty())
					System.out.println("There is no student data");
				else
				{
					System.out.println("Enter student name to be search: ");
					search=scan.nextLine();
					if(nameList.contains(search))
					{
						int index=nameList.indexOf(search);
						System.out.println("Student data is available: ");
						System.out.println("Name: "+nameList.get(index));
						System.out.println("Year: "+yearList.get(index));
						System.out.printf("GPA: %.2f%n", gpaList.get(index));
						System.out.println();
						System.out.println("Press enter to continue.. ");
					}
					else
						System.out.println("Student data not found");	
				}
				break;
				
			case 4:
				double average=0;
				average=totalGPA/nameList.size();
				System.out.printf("Average GPA of %d students: %f", nameList.size(), average);
				System.out.println();
				System.out.println("Press enter to continue.. ");
				break;
				
			}
		} while(menu!=5);
		scan.close();

	}

}