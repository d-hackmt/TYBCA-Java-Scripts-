import java.io.*;
import java.lang.*;
import java.sql.*;

class xyz
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;
	String name;

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
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter Name:");
			name=br.readLine();

			sql="select * from tybcatable where name='"+name+"'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			if(rs.next())
			{
				System.out.println("\t ROLLNO\t NAME \t MARKS");

				do
				{
					System.out.println("\t"+rs.getInt("rollno")+"\t"+rs.getString("name")+"\t"+rs.getInt("marks"));
				}while(rs.next());
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

class slip14_b
{
	public static void main(String args[])
	{
		xyz x = new xyz();
		x.disp();
	}
}
