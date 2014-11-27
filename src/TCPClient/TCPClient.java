package TCPClient;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

import Shared.Encryption;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class TCPClient {
	private String ny = "";
	private Encryption cryp = new Encryption();

		public String bla(Object o) throws UnknownHostException, IOException, SQLException{
			
		String modifiedSentence;
		Gson gson = new GsonBuilder().create();

		String gsonString = gson.toJson(o);
	

		Socket clientSocket = new Socket("localhost", 8888);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		byte[] input = gsonString.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);
		
		outToServer.write(encrypted);
		outToServer.flush();
		
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		byte[] b = new byte[500000];
		int count = clientSocket.getInputStream().read(b);
	
		String ny = cryp.decrypt(b);

		clientSocket.close();
		return ny;
	}
		public String getNy() {
			return ny;
		}
		public void setNy(String ny) {
			this.ny = ny;
		}
		
		
}
	
