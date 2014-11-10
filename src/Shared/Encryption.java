package Shared;

import javax.xml.bind.ParseConversionEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import JsonClasses.*;
import Logic.Logic;

public class encryption {
//	Decryption path
	public String decrypt(byte[] b)
	{
		
//		Defines the decryption value of the byte
		//The 4 lines below needs to work later on, but for now, it will be hardcode
		String crypKey = "3.1370";
		double gladKo = Double.parseDouble(crypKey);
		byte ff = (byte) gladKo;
//		Generates for loop containing decryption value
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
//		Generates new String without any white spaces following or leading
		String encrypted = new String(b).trim();
//		Returns decrypted String
		return encrypted;
	}
	public String encrypt() throws UnknownHostException, IOException{
		
		Gson gson = new GsonBuilder().create();
		CreateCalender CC = new CreateCalender();
		Login L = new Login();
		String gsonString = gson.toJson(L);
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
		
		clientSocket.close();
		return gsonString;
		
	}
	
}
