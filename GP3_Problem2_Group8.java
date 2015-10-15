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
		}
	}
}