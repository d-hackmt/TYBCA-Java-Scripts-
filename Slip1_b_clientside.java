/*
	Chatbot code

	CLIENT SIDE CODE
*/

import java.io.*;
import java.lang.*;
import java.net.*;

class Slip1_b_clientside
{
	public static void main(String args[]) throws  IOException
	{
		String str1;
		String str2;

		try
		{
			Socket s=new Socket("localhost",2222);

			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);

			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\n Hello I'm ABC Client Side ");
			System.out.println("\n Enter any msg: \t");
			str1=br.readLine();

			dos.writeUTF(str1);

			System.out.println("\n Msg Sent To Server");

			str2=dis.readUTF();
			System.out.println("\n Msg Sent To Server: \t"+str2);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}