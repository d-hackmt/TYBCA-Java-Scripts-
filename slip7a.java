import java.io.*;
import java.lang.*;

public class slip7a
{
	public static void main(String args[])
	{
		int num=0;
		int i=0;
		int cnt=0;
		int rem,temp=0;

		for(i=1;i<=1000;i++)
		{
			temp=i;
			num=0;

			while(temp!=0)
			{
				rem=temp%10;
				num=num+rem*rem*rem;
				temp=temp/10;
			}
			if(i==num)
			{
				if(cnt==0)
				{
					System.out.println("Armstrong Numbers Between 1 to 1000");
				}
				System.out.println(i+" ");
				cnt++;
			}
		}
		if(cnt==0)
		{
				System.out.println("There is no Armstrong Number between 1 to 1000nt");

		}
	}
}