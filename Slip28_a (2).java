import java.io.*;
import java.lang.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class xyz extends Frame implements ActionListener
{
	Panel p;
	Label l1;
	TextField t1;
	Button b1,b2;

	Connection conn;
	Statement stmt;
	ResultSet rs;
	String sql;

	int empno=0;

	public xyz()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			conn=DriverManager.getConnection("jdbc:ucanaccess://tybcadb.accdb");

			p = new Panel();

			l1 = new Label("Enter the Emp no: ");
			t1 = new TextField(30);

			b1 = new Button("DISPLAY RECORDS");
			b2 = new Button("CLEAR");

			add(p);

			p.add(l1);
			p.add(t1);

			p.add(b1);
			p.add(b2);

			setSize(400,400);
			setVisible(true);

			b1.addActionListener(this);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void actionPerformed (ActionEvent ae)
	{
		try
		{
			Object ob=ae.getSource();

			if(ob==b1)
			{
				empno = Integer.parseInt(t1.getText());

				sql="select * from emptable where empno="+empno;
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				if(rs.next())
				{
					System.out.println("EMPNO: EMPNAME: EMPDESG:");

					do
					{
						System.out.println(rs.getInt("empno")+"\t"+rs.getString("empname")+"\t"+rs.getString("empdesg"));
					}
					while(rs.next());
					}
				else
				{
					System.out.println("\n Record does not exist...");
				}
			}
			else
			{
				if (ob==b2)
				{
					t1.setText("");
					t1.requestFocus();
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("\n ERROR="+e);
		}
	}
}
class Slip28_a
{
	public static void main(String args[])
	{
		xyz x=new xyz();
	}
}