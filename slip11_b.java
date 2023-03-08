import java.io.*;
import java.lang.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


class xyz extends Frame implements ActionListener
{
	Connection con;
	Statement stmt;
	String sql;
	ResultSet rs;
	int rno=0;
	Panel p;
	Button b1,b2;
	Label l1;
	TextField t1;
	int i;

	public xyz()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://tybcadb.accdb");

			p=new Panel();

			l1=new Label("Enter Roll No :");


			t1=new TextField(30);


			b1=new Button("INSERT");
			b2=new Button("CLEAR");

			add(p);
			p.add(l1);
			p.add(t1);


			p.add(b1);
			p.add(b2);

			setSize(400,400);
			setVisible(true);

			b1.addActionListener(this);
			b2.addActionListener(this);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Object ob=ae.getSource();

			rno=Integer.parseInt(t1.getText());

			if(ob==b1)
			{

				sql="select * from tybcatable where rollno="+rno;
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

			else
			{
				if(ob==b2)
				{
					t1.setText("");
					t1.requestFocus();

				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error="+e);
		}
	}

}
class slip11_b
{
	public static void main(String args[])
	{
		xyz x = new xyz();

	}
}
