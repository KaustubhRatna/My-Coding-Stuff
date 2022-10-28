import java.io.*;
import java.net.*;
import java.lang.*;

class tcp2client
{
	public static void main(String a[])throws IOException
	{
		//Creates object for socket
		Socket s=new Socket("127.0.0.1",1234);
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
		//DataInputStream in=new DataInputStream(s.getInputStream());
        BufferedReader inn=new BufferedReader(new InputStreamReader(System.in)); 
		//DataInputStream inn=new DataInputStream(System.in);
		PrintStream dos=new PrintStream(s.getOutputStream());

		while(true)
		{
			//Reads the input from the input device
            String str=in.readLine();
            System.out.println("msg received:"+str);
            
            //Checks for end of message
			if(str.equals("end"))
			{
				//Closes the socket
				s.close();
				break;
			}

			System.out.println("enter the msg to send: ");

			//Reads the message to send
			
            String str1=inn.readLine();
            dos.println(str1);

			//Checks for end of message

			if(str1.equals("end"))
			{
				//Closes the socket
				s.close();
				break;
			}
		}
	}

}
