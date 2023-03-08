/* Write a java program to blink button on the Frame continuously */

import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class slip6_a extends Applet implements ActionListener,Runnable
{
	Thread t;
	Button b1,b2;

	public void init()
	{
		t=new Thread(this);
	}
	public void start()
	{
		b1=new Button("Start");
		b2=new Button("Stop");

		add(b1);
		add(b2);

		setSize(400,400);
		setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
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
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void run()
	{
		try
		{
			while(true)
			{
				b1.setVisible(true);
				t.sleep(500);

				b2.setVisible(false);
				t.sleep(500);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}