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
			sql="select * from tybcatable";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			while(rs.next())
			{
				cnt++;
			}
			System.out.println("Number of records in tybcatable : "+cnt);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
class slip12_A
{
	public static void main(String args[])
	{
		xyz x=new xyz();

	}
}