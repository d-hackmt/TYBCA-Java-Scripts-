import java.io.*;
import java.lang.*;
import java.sql.*;

class xyz
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	int i=0;
	int rollno;
	String sql;
	String nm;

	public xyz()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://tybca.accdb");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void delete()
	{
		try
		{

			sql="delete * from tybca where nm like 'S%'";

			stmt=con.createStatement();
			i=stmt.executeUpdate(sql);

			if(i>0)
			{
				System.out.println("Data deleted..");
			}
			else
			{
				System.out.println("Data does not deleted..");
			}
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
			sql="select * from tybca";

			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			if(rs.next())
			{
				System.out.println("\n ROLL NO \t NAME \t MARKS");
				do
				{
					System.out.println(rs.getInt("rollno")+"\t"+rs.getString("nm")+"\t"+rs.getInt("marks"));
				}while(rs.next());
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
class slip4_a
{
	public static void main(String args[])
	{
		xyz x=new xyz();
		x.delete();
		x.display();
	}
}