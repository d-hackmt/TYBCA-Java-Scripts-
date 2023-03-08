/*Write a java jdbc program to display the record of student with the attributes roll no
and name on the command prompt (Use Statement Interface)*/

import java.io.*;
import java.lang.*;
import java.sql.*;

class abc
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	int rno=0;
	String sql;


	public abc()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("ucanaccess:jdbc://tybca.accdb");
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
			System.out.println("\n Enter the rollno: ");
			rno=Integer.parseInt(br.readLine());

			sql="select * from tybcatable where rollno"+rno;
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			if(rs.next())
			{
				System.out.println("\n ROLLNO \t NAME ");
				do
				{
					System.out.println("\t"+rs.getInt("rollno")+"\t"+rs.getString("name"));
				}while(rs.next());
			}
			else
			{
				System.out.println("\n No Record Found.");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
class slip6_b
{
	public static void main(String args[])
	{
		abc a=new abc();
		a.display();
	}
}
