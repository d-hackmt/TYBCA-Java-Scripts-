import java.io.*;
import java.lang.*;

class xyz extends Thread
{
	String str;
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
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter any String : ");
			str=br.readLine();
			str.toLowerCase();

			System.out.println("Vowel Characters present in String are : ");
			for (i=0;i<str.length();i++)
			{

				if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u')
				{
					System.out.print("\t"+str.charAt(i));
					sleep(200);

				}
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class slip5_a
{
	public static void main(String args [])
	{
		xyz x=new xyz();
	}
}