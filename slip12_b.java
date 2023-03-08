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
	String name;
	int rno=0;
	int marks=0;
	Panel p;
	Button b1,b2;
	Label l1,l2,l3;
	TextField t1,t2,t3;
	int i;

	public xyz()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://tybcadb.accdb");

			p=new Panel();

			l1=new Label("Enter Roll No :");
			l2=new Label("Enter Name :");
			l3=new Label("Enter Marks :");

			t1=new TextField(30);
			t2=new TextField(30);
			t3=new TextField(30);

			b1=new Button("INSERT");
			b2=new Button("CLEAR");

			add(p);
			p.add(l1);
			p.add(t1);

			p.add(l2);
			p.add(t2);

			p.add(l3);
			p.add(t3);

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
			name=t2.getText();
			marks=Integer.parseInt(t3.getText());

			if(ob==b1)
			{
				sql="insert into tybcatable(rollno,name,marks) values("+rno+",'"+name+"',"+marks+")";
				stmt=con.createStatement();
				i=stmt.executeUpdate(sql);


				if(i>0)
				{
					System.out.println("Data inserted");
				}
				else
				{
					System.out.println("Data not inserted");
				}

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

			else
			{
				if(ob==b2)
				{
					t1.setText("");
					t2.setText("");
					t3.setText("");
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
class slip12_b
{
	public static void main(String args[])
	{
		xyz x = new xyz();

	}
}
