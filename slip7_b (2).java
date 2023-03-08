import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class slip7_b extends Applet implements ActionListener,Runnable
{
	Thread t;
	TextField tf;
	Button b;
	int i;

	public void init()
	{
		t= new Thread(this);
	}
	public void start()
	{
		tf= new TextField(30);
		b= new Button ("DISPLAY");

		add(tf);
		add(b);

		setSize(400,400);
		setVisible(true);

		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
			t.start();
		}
	}
	public void run()
	{
		try
		{
			for(i=1;i<=100;i++)
			{
				tf.setText(""+i);
 				t.sleep(700);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}








