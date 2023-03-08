import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class Slip30_b extends Applet implements ActionListener,Runnable
{
	Thread t;
	Button b1,b2;
	int x=0;
	Label l1,l2;

	public void init()
	{
		t=new Thread(this);

		l1=new Label("CAR 1");
		l2=new Label("CAR 2");

		b1=new Button("MOVE");
		b2=new Button("STOP");

		add(l1);
		add(l2);
		add(b1);
		add(b2);

		setSize(400,400);
		setVisible(true);
	}

	public void start()
	{

		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae)
	{
		Object ob=ae.getSource();
		if(ob==b1)
		{
			t.start();
		}
		else
		{
			if(ob==b2)
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
				l1.setBounds(x,100,90,90);
				l2.setBounds(x,200,90,90);

				t.sleep(100);
				if(x==400)
				{
					x=0;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in System"+e);
		}
	}
}