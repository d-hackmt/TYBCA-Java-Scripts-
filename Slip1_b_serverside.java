/*
	Chatbot code

	SERVER SIDE CODE
*/

import java.io.*;
import java.lang.*;
import java.net.*;

class Slip1_b_serverside
{

	public static void main(String args[]) throws  IOException
	{
		String str1;
		String str2;

		try
		{
			ServerSocket ss=new ServerSocket(2222);
			Socket s=ss.accept();

			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);

			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n Hello Im ZXC ServerSide");

			str1=dis.readUTF();

			System.out.println("\n ABC says.. "+str1);

			System.out.println("\n ZXC... please send a msg");
			str2=br.readLine();

			dos.writeUTF(str2);
			System.out.println("\n Msg sent to client");


		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
