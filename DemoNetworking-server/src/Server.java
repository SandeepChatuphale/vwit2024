import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try 
		{
			ServerSocket ss = new ServerSocket(8080);
			System.out.println("Server running waiting for client request");
			//1 - job of server
			//2 - keep running and wait for request from client and accept it
			//3 - Server MUST run before client
			Socket s = ss.accept();
			//send Account details to client
			System.out.println("Request from Client accepted");
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
