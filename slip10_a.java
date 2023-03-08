import java.io.*;
import java.lang.*;

class xyz extends Thread
{
	int i=0;
	public xyz()
	{
		super();

		start();
	}

	public void run()
	{
		try
		{
			for (i=1;i<=20;i++)
			{
				System.out.println(i+"\n : Hello World");
				sleep(2000);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class slip10_a
{
	public static void main(String args [])
	{
		xyz x=new xyz();
	}
}