import java.io.*;
import java.lang.*;
import java.sql.*;

class xyz
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;
	int cnt=0;

	public xyz()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://tybcadb.accdb");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void disp()
	{
		try
		{


			sql="select * from tybcatable";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			if(rs.next())
			{
				System.out.println("\t ROLLNO\t NAME \t MARKS");

				do
				{
					System.out.println("\t"+rs.getInt("rollno")+"\t"+rs.getString("name")+"\t"+rs.getInt("marks"));
					cnt++;
				}while(rs.next());
				System.out.println("\n Total Number of records : "+cnt);
			}
			else
			{
				System.out.println("Data not found");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class slip12_a
{
	public static void main(String args[])
	{
		xyz x = new xyz();
		x.disp();
	}
}
