import java.io.*;
import java.net.*;
import java.lang.*;

class tcp2server
{
	public static void main(String a[])throws IOException
	{
		ServerSocket ss=new ServerSocket(1234);
		//Opens the socket

		Socket s=ss.accept();

		PrintStream dos=new PrintStream(s.getOutputStream());
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
        BufferedReader inn=new BufferedReader(new InputStreamReader(System.in)); 

		while(true)
		{
			System.out.println("enter the msg to send: ");

			//Reads the input
			String str=in.readLine();
			dos.println(str);

			//Checks for end of message
			if(str.equals("end"))
			{
				//Closes the socket
				ss.close();
				break;
			}

			String str1=inn.readLine();
			System.out.println("msg received"+str1);

			if(str1.equals("end"))
			{
				ss.close();
				break;
			}
		}
	}
}
