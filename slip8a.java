import java.io.*;
import java.lang.*;
import java.sql.*;

class xyz
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql,nm;

	int i;

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

					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					System.out.print("\n enter name: ");
					nm=br.readLine();


					sql="delete * FROM tybca where name like '"+nm+"%' ";
					stmt=con.createStatement();
					i=stmt.executeUpdate(sql);

					if(i>0)
					{
						System.out.println("\n Data deleted");
					}
					else
					{
						System.out.println("\n Error");
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
			sql="select * from tybca ";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			if(rs.next())
			{
				System.out.println("\n ROLL NO \t NAME \t MARKS");
				do
				{
					System.out.println("\t"+rs.getInt("roll")+"\t"+rs.getString("name")+"\t"+rs.getInt("marks"));
				}while(rs.next());
			}
			else
			{
				System.out.println("\n DATA NOT FOUND ");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
class slip8a
{
	public static void main(String args[])
	{
		xyz x=new xyz();
		x.delete();
		x.display();
	}

}
