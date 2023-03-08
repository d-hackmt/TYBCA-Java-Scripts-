import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class slip1a extends Applet implements Runnable
{
	Thread t;
	String a="TYBCA";
	int state;
	boolean flag;

	public void init()
	{
		setBackground(Color.PINK);
		setForeground(Color.BLUE);

	}
	public void start()
	{
		t=new Thread(this);
		flag=true;
		t.start();
	}
	public void run()
	{
		char ch;

		try
		{
			while(true)
			{
				repaint();
				t.sleep(500);
				ch=a.charAt(0);
				a=a.substring(1,a.length());
				a+=ch;

			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void stop()
	{
		flag=false;
		Thread t=null;
	}
	public void paint(Graphics g)
	{
		Font b=new Font("Times New Roman",Font.BOLD,60);
		g.setFont(b);
		g.drawString(a,15,70);
	}
}