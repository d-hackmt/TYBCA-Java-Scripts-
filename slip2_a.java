import java.io.*;
import java.lang.*;
import java.util.*;

class one extends Thread
{
	char c;

	public one()
	{
		super();
		start();
	}

	public void run()
	{
		try
		{
			for(c = 'A'; c <= 'Z'; c++)
			{
				System.out.println("\n The Alphabets are: "+c);
				sleep(2000);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


}
class slip2_a
{
	public static void main(String args[])
	{
		one o1=new one();
	}
}