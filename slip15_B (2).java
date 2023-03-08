import java.io.*;
import java.lang.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class xyz extends JFrame implements ActionListener
{
	JPanel p;
	JButton b1,b2;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	Connection con;
	ResultSet rs;
	PreparedStatement pstmt;
	int i;
	int rno, per;
	String sname, gender, sclass;

	public xyz()
	{

		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection("jdbc:ucanaccess://tybcadb.accdb");

			p=new JPanel();

			l1=new JLabel("Enter Roll no :");
			l2=new JLabel("Enter Student Name ");
			l3=new JLabel("Enter Percentage");
			l4=new JLabel("Enter Gender");
			l5=new JLabel("Enter Class");

			t1=new JTextField(10);
			t2=new JTextField(10);
			t3=new JTextField(10);
			t4=new JTextField(10);
			t5=new JTextField(10);

			b1=new JButton("DISPLAY");
			b2=new JButton("CLEAR");


			add(p);

			p.add(l1);
			p.add(t1);

			p.add(l2);
			p.add(t2);

			p.add(l3);
			p.add(t3);

			p.add(l4);
			p.add(t4);

			p.add(l5);
			p.add(t5);

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
	public void actionPerformed (ActionEvent ae)
	{
		try
		{

			rno=Integer.parseInt(t1.getText());
			sname=t2.getText();
			per=Integer.parseInt(t3.getText());
			gender=t4.getText();
			sclass=t5.getText();

			if(ae.getSource()==b1)
			{
				pstmt=con.prepareStatement("insert into student(rno,sname,per,gender,class) values(?,?,?,?,?)");

				pstmt.setInt(1,rno);
				pstmt.setString(2,sname);
				pstmt.setInt(3,per);
				pstmt.setString(4,gender);
				pstmt.setString(5,sclass);

				i=pstmt.executeUpdate();


				if(i>0)
				{
					System.out.println("Data inserted");
				}
				else
				{
					System.out.println("Data not inserted");
				}

				pstmt=con.prepareStatement("select * from student");
				rs=pstmt.executeQuery();


				if(rs.next())
				{
					System.out.println("\t RNO\t SNAME \t PER \t GENDER\tCLASS");

					do
					{
						System.out.println("\t"+rs.getInt("rno")+"\t"+rs.getString("sname")+"\t"+rs.getInt("per")+"\t"+rs.getString("gender")+"\t"+rs.getString("class")+"\t");
					}while(rs.next());
				}
				else
				{
					System.out.println("Data not found");
				}

			}
			else
			{
				if(ae.getSource()==b2)
				{
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t1.requestFocus();
				}
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}


class slip15_B
{
	public static void main(String args[])
	{
		xyz x=new xyz();



	}
}