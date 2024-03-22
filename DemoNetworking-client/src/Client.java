import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		final String IP_OF_SERVER = "localhost";
		final int portOfServer = 8080;
		
		//client is responsible for initiating communication with server
		//Account this is Entity class 
		//
		try (Socket s = new Socket(IP_OF_SERVER, portOfServer)) 
		{
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
