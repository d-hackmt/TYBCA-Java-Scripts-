import java.io.*;
import java.lang.*;


class one extends Thread
{
	int i=0;
	int startno=0;
	int endno=0;

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
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n Enter the start number: ");
			startno=Integer.parseInt(br.readLine());

			System.out.println("\n Enter the end number: ");
			endno=Integer.parseInt(br.readLine());

			for(i=startno;i<=endno;i++)
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
class slip3_a
{
	public static void main(String args[])
	{
		one o1=new one();
	}
}