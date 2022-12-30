package src;
import java.io.*;
import java.net.*;

public class Client {
	
	public static void main(String[] args) throws IOException{
		
		Socket s = new Socket("localhost", 5000);
		
		System.out.println("client port is : " + s.getLocalPort());
		System.out.println("server port is : " + s.getPort());
		
		DataOutputStream send = new DataOutputStream(s.getOutputStream());
		BufferedReader read = new BufferedReader( new InputStreamReader(System.in));
		
		String str = "";
		
		while(!str.equals("stop")) {
			
			System.out.println("Enter what you want to send");
			str = read.readLine();
			send.writeUTF(str);
		}
		
		s.close();
		read.close();
		send.close();
	}
}
