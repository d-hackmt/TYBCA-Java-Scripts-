import java.io.*;
import java.lang.*;
import java.sql.*;

class abc
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;

	int ch = 0;
	int empno = 0;
	String enm;
	int sal = 0;
	String des;
	int i = 0;

	public abc()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://empdb.accdb");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void display()
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("MENU: ");
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Search");
			System.out.println("5. Display");
			System.out.println("6. Exit");

			System.out.println("Enter your choice :");
			ch=Integer.parseInt(br.readLine());

			switch(ch)
			{
				case 1:

					System.out.println("Enter Emp No :");
					empno=Integer.parseInt(br.readLine());

					System.out.println("Enter Emp Name :");
					enm=(br.readLine());

					System.out.println("Enter Salary :");
					sal=Integer.parseInt(br.readLine());

					System.out.println("Enter Designation :");
					des=(br.readLine());

					sql="insert into emp (eno,ename,salary,desig) values("+empno+",'"+enm+"',"+sal+",'"+des+"')";
					stmt=con.createStatement();
					i=stmt.executeUpdate(sql);

					if(i>0)
					{
						System.out.println("\n Data Inserted Successfully");
					}
					else
					{
						System.out.println("\n Data not Inserted");
					}

					break;
				case 2:

					System.out.println("Enter Emp Name :");
					enm=(br.readLine());

					System.out.println("Enter Salary :");
					sal=Integer.parseInt(br.readLine());

					System.out.println("Enter the designation :");
					des=(br.readLine());

					sql="update emp set ename='"+enm+"', salary="+sal+", desig='"+des+"' where eno="+empno;
					stmt=con.createStatement();
					i=stmt.executeUpdate(sql);

					if(i>0)
					{
						System.out.println("\n Data Updated properly");
					}
					else
					{
						System.out.println("\n Data not Updated properly");
					}
					break;

				case 3:

					System.out.println("Enter EmpNo :");
					empno=Integer.parseInt(br.readLine());

					sql="delete * from emp where eno="+empno;
					stmt=con.createStatement();
					i=stmt.executeUpdate(sql);

					if(i>0)
					{
						System.out.println("\n Data deleted properly");
					}
					else
					{
						System.out.println("\n Data not deleted properly");
					}
					break;

				case 4:

					sql="select * from emp";
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);

					do
					{
							System.out.println("\t"+rs.getInt("eno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("salary")+"\t"+rs.getString("desig"));
					}while(rs.next());
					break;

				case 5:

					sql="select * from emp";
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);

					if(rs.next())
					{
						System.out.println("\n EMPNO \t ENAME \t SALALRY \t DESIGNATION");

						do
						{
							System.out.println("\t"+rs.getInt("eno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("salary")+"\t"+rs.getString("desig"));
						}while(rs.next());
					}
					else
					{
						System.out.println("No data found");
					}
					break;

				case 6:
					break;


				default:
							System.out.println("Invalid Choice");
							break;

			}

		}
		catch(Exception e)
		{

		}
	}
}

class slip24_B
{
	public static void main(String args[])
	{
		abc a = new abc();
		a.display();
	}
}