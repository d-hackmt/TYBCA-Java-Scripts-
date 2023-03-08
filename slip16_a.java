import java.io.*;
import java.lang.*;

class xyz extends Thread
{
	int i=0;
	int start=0;
	int end=0;

	public xyz(int x, int y)
	{
		super();

		start=x;
		end=y;

		start();
	}

	public void run()
	{
		try
		{
			for (i=start;i<=end;i++)
			{
				System.out.println("\n"+i);
				sleep(200);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class slip16_a
{
	public static void main(String args[])
	{
		int a=0;
		int b=0;

		a=Integer.parseInt(args[0]);
		b=Integer.parseInt(args[1]);

		xyz x=new xyz(a,b);
	}
}