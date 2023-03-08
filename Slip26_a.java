import java.io.*;
import java.lang.*;
import java.sql.*;

class xyz
{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public xyz()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			conn=DriverManager.getConnection("jdbc:ucanaccess://tybcadb.accdb");
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
			pstmt = conn.prepareStatement("select * from tybcatable");

			rs = pstmt.executeQuery();

			if(rs.next())
			{
				System.out.println("CID: CNAME: ADDR:");

				do
				{
					System.out.println(rs.getInt("cid")+"\t"+rs.getString("cname")+"\t"+rs.getString("addr"));
				}
				while(rs.next());
			}
			else
			{
				System.out.println("\n Record does not exist...");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
class Slip26_a
{
	public static void main(String args[])
	{
		xyz x=new xyz();
		x.display();
	}
}