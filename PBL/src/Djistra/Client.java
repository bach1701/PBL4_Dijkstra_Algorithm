package Djistra;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import Djistra.View;

public class Client {
	
	//public static Socket client;
	//private static View MainFrame;
	public static void main(String[] args) {
		connectToServer();
	}
	public static void connectToServer(){
		View MainFrame = new View();
		MainFrame.setVisible(true);
	}
	public static void pullTextbox() throws Exception {
		
		View view = new View();
		int nguon = View.MainFrame._algoWorkers;
		int dich = View.MainFrame._algoWorkert;
		int port = 7004;
		Scanner kb = new Scanner(System.in);
		/*
			Socket client = new Socket("localhost",port);
			System.out.println("Kết nối đến server thành công");
			DataInputStream din = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			dos.writeInt(nguon);
			dos.flush();
		*/
		try {
			Socket client = new Socket("localhost",port);
			System.out.println("11111111111111111111111111111111111111111111111111111111111111111111");
			System.out.println("11111111111111111111111111111111111111111111111111111111111111111111");
			DataInputStream din = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			dos.writeInt(nguon);
			dos.writeInt(dich);
			dos.writeUTF("Đỉnh nguồn : "+nguon);
			dos.flush();
			//String st = din.readUTF();
			//System.out.println(st);
			String Out1 = din.readUTF();
			String Out2 = din.readUTF();
			System.out.println(Out1);
			//view._updateResults(Out1);
		}
		catch(Exception e){
			
		}
	}
}
