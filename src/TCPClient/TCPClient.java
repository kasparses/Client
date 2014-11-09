package TCPClient;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import JsonClasses.*;
import Logic.Logic;

public class TCPClient {
//	public static void main(String[] args) throws Exception {
		public static void main(String []args) throws Exception {
			
			
			
		String modifiedSentence;
		Gson gson = new GsonBuilder().create();
		CreateCalender CC = new CreateCalender();
		Login L = new Login();

		String gsonString = gson.toJson(L);
		System.out.println("hej");
		System.out.println("CC: "+CC);
		System.out.println("gsonString: "+gsonString);

		Socket clientSocket = new Socket("localhost", 8888);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		byte[] input = gsonString.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);
		
		outToServer.write(encrypted);
		outToServer.flush();
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		System.out.println(inFromServer);
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER: " + modifiedSentence);
		Logic LG = new Logic();
		LG.hej(modifiedSentence);
		clientSocket.close();
	}
	
}