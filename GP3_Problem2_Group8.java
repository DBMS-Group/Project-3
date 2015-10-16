import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;

public class GP3_Problem2_Group8
{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
	static final String DB_URL = "jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu";

	// The database connection.
	static Connection conn;

	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		// Declaring the various variables.
		Scanner scan = new Scanner(System.in);
		int input = 0;

		// The username and password for the database.
		String user = "";
		String password = "";

		// Getting the username.
		System.out.printf("Please enter the username for the database: ");
		user = scan.nextLine();

		// Getting the password.
		System.out.printf("Please enter the password for the database: ");
		password = scan.nextLine();

		System.out.printf("\nConnecting...\n\n");

		// Registering the JDBC driver.
		Class.forName(JDBC_DRIVER);

		// Creating the database connection.
		conn = DriverManager.getConnection(DB_URL, user, password);

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
					AddNewOne(scan);
					break;
				case 2:
					AddNewTwo(scan);
					break;
				case 3:
					PrintTable();
					break;
				case 4:
					break;
				default:
					System.out.printf("Please enter a valid option!\n");
					break;
			}
		}

		conn.close();
	}

	/**
	* Adds a new faculty member to the Faculty table with an average salary based
	* on the average salary of all faculty members.
	**/
	private static void AddNewOne(Scanner scan) throws SQLException
	{
		System.out.printf("Option 1 chosen.\n");

		// Gets a new faculty member.
		Faculty newMember = GetNewFacultyMember(scan);

		// The results of the SQL statement.
		float avgSalary = 0.0f;

		if(avgSalary > 50000)
		{
			// Set the salary equal to 90% of the faculty average salary.
			newMember.salary = String.valueOf(avgSalary * 0.9);
		}
		else if(avgSalary < 30000)
		{
			// Set the salary equal to the faculty average salary.
			newMember.salary = String.valueOf(avgSalary);
		}
		else
		{
			// Set the salary equal to 80% of the average salary.
			newMember.salary = String.valueOf(avgSalary * 0.8);
		}

		System.out.println();
	}

	/**
	* Adds a new faculty member to the Faculty table with an average salary based
	* on the average salary of all faculty members outside of a specified department.
	**/
	private static void AddNewTwo(Scanner scan)
	{
		// The salary is computed to be equal to the average salary of every faculty
		// member in the university except the faculty members working for a
		// particular department.
		System.out.printf("Option 2 chosen.\n");

		System.out.printf("Please enter the department to exclude: ");
		String department = scan.nextLine();

		// Gets a new faculty member.
		Faculty newMember = GetNewFacultyMember(scan);

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
	private static void PrintTable() throws SQLException
	{
		// The list of faculty members.
		ArrayList<Faculty> facultyMembers = new ArrayList<Faculty>();

		// SQL statement for getting all the faculty members.
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM Faculty";
		ResultSet result = stmt.executeQuery(sql);

		// Iterate over the results and initialize the faculty member objects.
		while(result.next())
		{
			Faculty newMember = new Faculty();
			newMember.id = String.valueOf(result.getInt("fid"));
			newMember.name = result.getString("fname");
			newMember.deptId = String.valueOf(result.getInt("deptId"));
			newMember.salary = String.valueOf(result.getFloat("salary"));

			// Add the faculty member to the list.
			facultyMembers.add(newMember);
		}

		// Printing the faculty members.
		PrintTheFaculty(facultyMembers);

		// Closing the statement.
		stmt.close();
	}

	/**
	* Prints the passed faculty members.
	**/
	private static void PrintTheFaculty(ArrayList<Faculty> facultyMembers)
	{
		System.out.printf("ID\t\tName\t\tDepartment ID\tSalary\n");

		// Iterate over the faculty members and print their field values.
		for(Faculty member : facultyMembers)
		{
			System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", 
				member.id,
				member.name,
				member.deptId,
				member.salary
			);
		}

		System.out.printf("\n");
	}

	/**
	* Gets a new faculty member.
	**/
	private static Faculty GetNewFacultyMember(Scanner scan)
	{
		Faculty tempFaculty = new Faculty();

		System.out.printf("Please enter the following:\n");

		// Get the faculty member's ID.
		System.out.printf("\tEnter the ID: ");
		tempFaculty.id = scan.nextLine();

		// Get the faculty member's name.
		System.out.printf("\tEnter the name: ");
		tempFaculty.name = scan.nextLine();

		// Get the faculty member's department ID.
		System.out.printf("\tEnter the department: ");
		tempFaculty.deptId = scan.nextLine();

		return tempFaculty;
	}

	/**
	* A class representing a faculty member.
	**/
	private static class Faculty
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
	}
}