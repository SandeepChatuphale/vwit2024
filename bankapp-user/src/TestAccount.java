// Modify the application in such a way that application should be able to maintain the record of

//Multiple bank account

//and perform the operation(deposit and withdraw) based on user choice

//application must also show appropriate result(output) to end user

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestAccount {

	private static ServerSocket server;

	private static void connect() throws IOException {
		server = new ServerSocket(8080);
	}

	public static void main(String[] args) throws IOException {

		connect();
		Socket socket = server.accept();
		InputStream inputStream = socket.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(inputStream);
		int accountNumber = ois.readInt();
		System.out.println(accountNumber);
		ois.close();
	}
}