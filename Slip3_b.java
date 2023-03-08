import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class Slip3_b extends Applet implements ActionListener,Runnable
{
	Thread t;
	Button b1,b2;
	int y=0;
	boolean a=true;

	public void init()
	{
		t=new Thread(this);
	}
	public void start()
	{
		b1=new Button("START");
		b2=new Button("STOP");

		add(b1);
		add(b2);

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
			while(true)
			{
				if(y<=400 && a==true)
				{
					y=y+10;
					repaint();
					t.sleep(100);

					if(y==400)
					{
						a=false;
					}
				}
				else
				{
					if(y>=0 && a==false)
					{
						y=y-10;
						repaint();
						t.sleep(100);

						if(y==0)
						{
							a=true;
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void paint(Graphics g)
	{
		Random r=new Random();
		int r1=r.nextInt(199);
		int g1=r.nextInt(199);
		int b1=r.nextInt(199);

		Color c1=new Color(r1,g1,b1);
		g.setColor(c1);
		g.fillOval(100,y,90,90);

	}
}
