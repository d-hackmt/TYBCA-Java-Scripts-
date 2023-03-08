import java.io.*;
import java.lang.*;
import java.sql.*;

class slip9_a
{
	public static void main(String args[])
	{
		Connection con;
		PreparedStatement p;
		Statement stmt;
		ResultSet rs;
		String sql,ename;
		int ch,sal,eno;

		boolean flag=true;
		String decision;
		int no;


		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://tybcadb.accdb");

			do
			{
				System.out.println("\n ");
				System.out.println("\n  MENU  ");
				System.out.println("\n  1.CREATE TABLE  ");
				System.out.println("\n  2.INSERT INTO TABLE");
				System.out.println("\n  3.DISPLAY FROM TABLE ");
				System.out.println("\n  4.EXIT ");
				System.out.println("\n ENTER YOUR CHOICE ");

				BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
				ch=Integer.parseInt(br.readLine());

				switch(ch)
				{
					case 1:	stmt=con.createStatement();
							sql="create table Emp"+"ENo int,EName carchar(20), Sal int)";
							stmt.executeUpdate(sql);
							System.out.println("TABLE CREATED");
							break;

					case 2:	System.out.println("ENTER THE ENO");
							eno=Integer.parseInt(br.readLine());

							System.out.println("ENTER THE ENAME");
							ename=br.readLine();

							System.out.println("ENTER THE SAL");
							sal=Integer.parseInt(br.readLine());

							sql="insert into Emp values(?,?,?)";
							p=con.prepareStatement(sql);

							p.setInt(1,eno);
							p.setString(2,ename);
							p.setInt(3,sal);

							p.executeUpdate();
							System.out.println("RECORDED INSERTED ");
							break;
					case 3: stmt=con.createStatement();
							sql="select * from Emp";
							rs=stmt.executeQuery(sql);
							while(rs.next())
							{
								System.out.println("\n");
								System.out.println("\t +rs.getInt(1)");
								System.out.println("\t +rs.getString(2)");
								System.out.println("\t +rs.getInt(3)");
							}
							break;
					case 4: System.exit(0);
							break;

					default: System.out.println("INVALID CHOICE ");
							break;
					}

			}while(ch!=4);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}