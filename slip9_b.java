import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class slip9_b extends Applet implements ActionListener , Runnable
{
	Thread t;
	Button b1,b2;
	Label l1,l2;
	int x=0;
	int cnt=1;

	public void init()
	{
		t=new Thread(this);
	}
	public void start()
	{
		b1=new Button("Start");
		b2=new Button("Stop");

		l1=new Label("Car1");
		l2=new Label("Car2");

		add(b1);
		add(b2);

		add(l1);
		add(l2);

		setSize(400,400);
		setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			t.start();
		}
		else
		{
			if(ae.getSource()==b2)
			{
				t.stop();
			}
		}
	}
	public void run()
	{
		try
		{
			while(x<=400)
			{

				x=x+10;
				l1.setBounds(x,100,50,50);
				l2.setBounds(x,200,50,50);
				t.sleep(400);

				if(x==400 && cnt==1)
				{

					x=0;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}