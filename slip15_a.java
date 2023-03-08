import java.io.*;
import java.lang.*;

class xyz extends Thread
{
	char ch;
	public xyz()
	{
		super();

		start();
	}

	public void run()
	{
		try
		{
			for (ch='a';ch<='z';ch++)
			{
				System.out.println("\t"+ch);
				sleep(2000);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class slip15_a
{
	public static void main(String args [])
	{
		xyz x=new xyz();
	}
}