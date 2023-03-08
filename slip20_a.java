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
	int rn;
	int i;

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

	public void insert()
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter Roll no:");
			rn=Integer.parseInt(br.readLine());

			System.out.println("Enter New Name:");
			name=br.readLine();


			sql="update tybcatable set name='"+name+"' where rollno="+rn;
			stmt=con.createStatement();
			i=stmt.executeUpdate(sql);

			if(i>0)
			{
				System.out.println("Data updated");
			}
			else
			{
				System.out.println("Data not updates");
			}


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

class slip20_a
{
	public static void main(String args[])
	{
		xyz x = new xyz();
		x.insert();
		x.disp();
	}
}
