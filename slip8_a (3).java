import java.io.*;
import java.lang.*;
import java.sql.*;

class slip8_a
{
	public static void main(String args[])
	{
		Connection con;
		Statement stmt;
		ResultSet rs;
		String sql;

		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://tybcadb.accdb");

			sql="select * from emp where ename like'A%'";
			stmt=con.createStatement();
			rs=stmt.executeQuery("sql");
			System.out.println("\t eno \t ename \t sal");

			while(rs.next())
			{
				System.out.println("\n"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}