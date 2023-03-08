 import java.io.*;
 import java.lang.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.applet.*;
 import java.util.*;

 public class Slip5b extends Applet implements ActionListener , Runnable
{
	Thread t;
	Button b1,b2;
	Boolean red, green, yellow;

	public void init()
	{
		t = new Thread(this);

	}
	public void start()
	{
		b1= new Button("START SIGNAL");
		b2= new Button("STOP SIGNAL");

		red = true;

		add(b1);
		add(b2);

		setSize(400,400);
		setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object ob = ae.getSource();

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
			while(true)
			{
				if(red==true)
				{
					red=false;
					yellow=true;
					green=false;
				}
				else
				{
					if(yellow==true)
					{
						yellow=false;
						green=true;
						red=false;
					}
					else
					{
						if(green==true)
						{
							green=false;
							red=true;
							yellow=false;
						}
					}
				}
				repaint();
				t.sleep(700);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

public void paint(Graphics g)
{
	if(red==true)
	{
		g.setColor(Color.RED);
		g.fillOval(100,100,70,70);
	}
	else
	{
		if(yellow==true)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(100,200,70,70);
		}
		else
		{
				if(green==true)
				{
					g.setColor(Color.GREEN);
					g.fillOval(100,300,70,70);
				}
			}
		}
	}
}