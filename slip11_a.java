import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class slip11_a extends Applet implements ActionListener,Runnable
{
	Thread t;
	Button b1,b2;
	int i=0;
	public void init()
	{
		t=new Thread(this);

		b1=new Button("START");
		b2=new Button("STOP");

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
			for(i=1;i<=20;i++)
			{
				System.out.println(i+"\n : Hello WOrld");
				t.sleep(700);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in System"+e);
		}
	}
}