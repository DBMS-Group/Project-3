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

			switch(input)
			{
				case 1:
					System.out.printf("Option 1 chosen.");
					break;
				case 2:
					System.out.printf("Option 2 chosen.");
					break;
				case 3:
					System.out.printf("Option 3 chosen.");
					break;
				default:
					break;
			}
		}
	}

	private static void OptionOne()
	{
		// If the average faculty salary is greater than $50,000 then the salary
		// of the new faculty member will be equal to 90% of the average faculty
		// salary; if the average faculty salary is less than $30,000, then the
		// salary of the new faculty member will be equal to the average faculty
		// salary; otherwise, the salary of the new faculty member will be equal
		// to 80% of the average faculty salary
	}

	private static void OptionTwo()
	{
		// The salary is computed to be equal to the average salary of every faculty
		// member in the university except the faculty members working for a
		// particular department.
	}

	private static void OptionThree()
	{
		// Print the Faculty table.
	}
}