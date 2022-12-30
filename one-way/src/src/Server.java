package src;
import java.io.*;
import java.net.*;

public class Server{
	
	public static void main() throws IOException{
		
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("Server is listening at port" + ss.getLocalPort());
		Socket s = ss.accept();
		System.out.println("client is connected at port " + s.getPort() + "server communicatio port " + s.getLocalPort());
		
		DataInputStream rc = new DataInputStream(s.getInputStream());
		
		String str = "";
		
		while(!str.equals("stop")) {
			
			str = rc.readUTF();
			System.out.println("client says : " + str);
			
		}
		
		
		ss.close();
		s.close();
		rc.close();	
	}
}
