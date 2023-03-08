//Write a Multithreading program in java to display the numbers between 1 to 100
//continuously in a TextField by clicking on button.


import java.io.*;
import java.lang.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class slip7_b extends Applet implements ActionListener, Runnable
{
	Thread t;
	Button b1,b2;
	TextArea ta;
	int i=0;

	public void init()
	{
		t=new Thread(this);
		b1=new Button("Start");
		b2=new Button("Stop");

	}
	public void start()
	{


		ta=new TextArea(30,30);


		add(b1);
		add(b2);

		add(ta);

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


			for(i=1;i<=100;i++)
			{
				ta.append("\t \n The Numbers are: "+i);
				t.sleep(500);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}