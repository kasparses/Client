package TCPClient;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

import Shared.encryption;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Shared.GiantSwitch;
import JsonClasses.*;
import Logic.Logic;

public class TCPClient {
	private GiantSwitch GS = new GiantSwitch();
	private String ny = "";
	private encryption cryp = new encryption();
//public TCPClient() {
//		// TODO Auto-generated constructor stub
//	}
		//	public static void main(String[] args) throws Exception {
		public String bla(Object o) throws UnknownHostException, IOException, SQLException{
			
		String modifiedSentence;
		Gson gson = new GsonBuilder().create();

		String gsonString = gson.toJson(o);
		System.out.println("hej");

		System.out.println("gsonString: "+gsonString);

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
		System.out.println("krypteret: "+b);
		String ny = cryp.decrypt(b);
		System.out.println("infromserver: "+ny);
//		String returnSvar = GS.GiantSwitchMethod(ny);
//		new().GS.GiantSwitchMethod(ny);
//		new GiantSwitch().GiantSwitchMethod(ny);

		System.out.println("infromserver: "+ny);
//		new Logic().hej(ny);
		
//		LoginAnswer AU = (LoginAnswer)gson.fromJson(jsonString, LoginAnswer.class);
		
//		modifiedSentence = inFromServer.readLine();
//		System.out.println("FROM SERVER: " + modifiedSentence);
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
	
