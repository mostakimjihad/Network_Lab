import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{
	
	public static void main(String[] args) throws IOException{
		
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("Server is listening at port" + ss.getLocalPort());

		while(true){
			
			Socket s = ss.accept();
			System.out.println("client is connected at port " + s.getPort() + "server communicatio port " + s.getLocalPort());

			Thread th = new ClientHandler(s);
			th.start();

		}

	}
}


class ClientHandler extends Thread{

	private Socket s;

	public ClientHandler(Socket s){

		this.s = s;
	}

	public void run(){

		
		String str = "";
		String str2;

		try{
		while(!str.equals("stop")) {


		DataInputStream rc = new DataInputStream(s.getInputStream());
		DataOutputStream send = new DataOutputStream(s.getOutputStream());
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
			
			str = rc.readUTF();
			System.out.println("client says : " + str);

			System.out.println("Enter what you want to send to client : ");
			str2 = read.readLine();
			send.writeUTF(str2);
		}
		}catch(IOException ex){

			Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);

		}

		try{

			s.close();

		}catch(IOException ex){

			Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);

		}

	}

}


		


import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{
	
	public static void main(String[] args) throws IOException{
		
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("Server is listening at port" + ss.getLocalPort());

		while(true){
			
			Socket s = ss.accept();
			System.out.println("client is connected at port " + s.getPort() + "server communicatio port " + s.getLocalPort());

			Thread th = new ClientHandler(s);
			th.start();

		}

	}
}


class ClientHandler extends Thread{

	private Socket s;

	public ClientHandler(Socket s){

		this.s = s;
	}

	public void run(){

		
		String str = "";
		String str2;

		try{
		while(!str.equals("stop")) {


		DataInputStream rc = new DataInputStream(s.getInputStream());
		DataOutputStream send = new DataOutputStream(s.getOutputStream());
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
			
			str = rc.readUTF();
			System.out.println("client says : " + str);

			System.out.println("Enter what you want to send to client : ");
			str2 = read.readLine();
			send.writeUTF(str2);
		}
		}catch(IOException ex){

			Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);

		}

		try{

			s.close();

		}catch(IOException ex){

			Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);

		}

	}

}


		


