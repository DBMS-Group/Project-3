import java.util.Scanner;

public class GP3_Problem2_Group8
{
	public static void main(String[] args)
	{
		// Declaring the various variables.
		Scanner scan = new Scanner(System.in);
		int input = 0;

		// Welcoming the user.
		System.out.printf("Welcome to project three.\n");

		// Loop until the user chooses to exit the program.
		while(input != 4)
		{
			System.out.printf("Please enter one of the four following options:\n");
			System.out.printf("\tOption 1:\n\t\tInsert new member into Faculty table!\n\t\tAverage salary of member's department.\n\n");
			System.out.printf("\tOption 2:\n\t\tInsert new member into Faculty table!\n\t\tAverage salary excepting particular department.\n\n");
			System.out.printf("\tOption 3:\n\t\tDisplay the Faculty table...\n\n");
			System.out.printf("\tOption 4:\n\t\t!!QUIT!!\n\n");

			// Get the user's input.
			input = scan.nextInt();
			scan.nextLine();

			switch(input)
			{
				case 1:
					OptionOne(scan);
					break;
				case 2:
					OptionTwo(scan);
					break;
				case 3:
					OptionThree();
					break;
				case 4:
					break;
				default:
					System.out.printf("Please enter a valid option!\n");
					break;
			}
		}
	}

	/**
	* Adds a new faculty member to the Faculty table with an average salary based
	* on the average salary of all faculty members.
	**/
	private static void OptionOne(Scanner scan)
	{
		System.out.printf("Option 1 chosen.\n");

		// SQL statement get the average salary of all Faculty.
		float avgSalary = 0f;

		if(avgSalary > 50000)
		{
			// Set the salary equal to 90% of the faculty average salary.

		}
		else if(avgSalary < 30000)
		{
			// Set the salary equal to the faculty average salary.

		}
		else
		{
			// Set the salary equal to 80% of the average salary.

		}

		System.out.println();
	}

	/**
	* Adds a new faculty member to the Faculty table with an average salary based
	* on the average salary of all faculty members outside of a specified department.
	**/
	private static void OptionTwo(Scanner scan)
	{
		// The salary is computed to be equal to the average salary of every faculty
		// member in the university except the faculty members working for a
		// particular department.
		System.out.printf("Option 2 chosen.\n");

		System.out.printf("Please enter the department to exclude: ");
		String department = scan.nextLine();

		// SQL statment to get the average salary of the faculty members not in
		// the given department.
		float avgSalary = 0f;

		// SQL statement to add the faculty member with the average salary to 
		// the Faculty table.
		System.out.println();
	}

	/**
	* Prints the Faculty table.
	**/
	private static void OptionThree()
	{
		System.out.printf("Option 3 chosen.\n");

		// SQL statement to retrieve all the faculty members from the Faculty table.
		System.out.println();
	}

	/**
	* A class representing a faculty member.
	**/
	private class Faculty
	{
		/**
		* The ID of the faculty member.
		**/
		public String id;

		/**
		* The name of the faculty member.
		**/
		public String name;

		/**
		* The department ID of the faculty member.
		**/
		public String deptId;

		/**
		* The salary of the faculty member.
		**/
		public String salary;

		/**
		* Faculty Constructor.
		**/
		public Faculty(String id, String name, String deptId, String salary)
		{
			this.id = id;
			this.name = name;
			this.deptId = deptId;
			this.salary = salary;
		}
	}
}