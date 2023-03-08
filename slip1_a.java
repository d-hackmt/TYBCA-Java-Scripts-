import java.io.*;
import java.lang.*;
import java.util.*;

class one extends Thread
{
	int i=0;

	public one()
	{
		super();
		i=0;
		start();
	}

	public void run()
	{
		try
		{

			for(i=0;i<=20;i++)
			{
				System.out.println("\n The Numbers are: "+i);
				sleep(2000);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


}
class slip1_a
{
	public static void main(String args[])
	{
		one o1=new one();
	}
}