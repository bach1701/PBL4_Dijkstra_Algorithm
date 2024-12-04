package Djistra;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Server {
	public static void main(String[] args) throws Exception {
				ServerSocket ss = new ServerSocket(7004);
				System.out.println("Server started and waiting for client connection...");
				Socket client = ss.accept();
				System.out.println("Client connected!");
				DataInputStream din = new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				int nguon = din.readInt();
				int dich = din.readInt();
				Algorithm algoWorkerServer = new Algorithm();
				algoWorkerServer.s = nguon;
				algoWorkerServer.t = dich;
				algoWorkerServer.runAlgorithm();
				//dos.writeUTF(algoWorkerServer.getPath());
				//dos.writeUTF(algoWorkerServer.getDistance());
				//algoWorkerServer._runAlgorithm(algoWorkerServer.getPath());
				//System.out.println(algoWorkerServer.getDistance());
				//String st = din.readUTF();
				//System.out.println(st);// chuoi nhan duoc tu client hien thi tren server
				/*
				Algorithm aServer = new Algorithm();
				aServer.runAlgorithm();
				aServer.getPath();
				aServer.getDistance();
				*/
				
				
				//ss.close();
	}
}
