package Djistra;

import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Algorithm {
	    private final int MAX = 7;
	    private final int TRUE = 1;
	    private final int FALSE = 0;
	    private final int INF = 10000000;
	    
	    public int n ; // số đỉnh của đồ thị.
	    public int s; // đỉnh đầu.
	    public int t; // đỉnh cuối
	    private int[] way = new int[MAX]; // mảng đánh dấu đường đi.
	    private int[] dis = new int[MAX]; // mảng đánh dấu khoảng cách.
	    private int[][] Matrix = new int[MAX][MAX]; // ma trận trọng số
	    private int[] confirm = new int[MAX]; // mảng đánh dấu đỉnh đã được gán nhãn.
	    private int u, min;
	    
	    public void init() 
	    {
	    	/*
	    	Scanner sc = new Scanner(System.in);
	    	System.out.printf("Nhập số đỉnh n:");
	    	n = sc.nextInt();
	    	System.out.printf("Nhập đỉnh nguồn s:");
	    	s = sc.nextInt();
	    	System.out.printf("Nhập đỉnh đích t:");
	    	t = sc.nextInt();
	    	*/
	    	n = 6;
	    	
	    }
	    
	    
	    public void loadMatrixFromFile(String filename) {
	    	/*
	    	Scanner sc = new Scanner(System.in);
	    	System.out.printf("Nhập đỉnh nguồn s:");
	    	s = sc.nextInt();
	    	System.out.printf("Nhập đỉnh đích t:");
	    	t = sc.nextInt();
	    	 n = MAX;
	    	 */
	        File file = new File(filename);
	        try (Scanner scanner = new Scanner(file)) {
	            int i = 1;
	            while (scanner.hasNextLine()) {
	                String[] line = scanner.nextLine().trim().split(" ");
	                for (int j = 1; j <= line.length; j++) {
	                    Matrix[i][j] = Integer.parseInt(line[j-1]);
	                    if(Matrix[i][j] == 0) Matrix[i][j] = INF;
	                }
	                i++;
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Không tìm thấy file: " + filename);
	        }
	    }
	    
	    public void printMatrix() {
	        for (int i = 1; i < MAX; i++) {
	            for (int j = 1; j < MAX; j++) {
	                System.out.print(Matrix[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	    
	    public void Result() {
	    	
	    	System.out.print("Đường đi ngắn nhất từ " + (char)(s+'A'-1) + " đến " + (char)(t+'A'-1) + " là : ");
	    	System.out.printf(""+(char)(t + 'A' - 1) + "<=");
	    	int i = way[t];
	    	while(i != s) {
	    		System.out.printf(""+(char)(i + 'A' - 1) + "<=");
	    		i = way[i];
	    	}
	    	System.out.println(""+(char)(s + 'A' - 1));
	    	System.out.printf("Độ dài đường đi : " + dis[t]);
	    }
	    
	    public String getPath() 
	    {
	        StringBuilder path = new StringBuilder();
	        
	        path.append("Đường đi ngắn nhất từ " + (char)(s+'A'-1) + " đến " + (char)(t+'A'-1) + " là : ");
	        path.append((char)(t + 'A' - 1) + "<=");
	        int i = way[t];
	        while(i != s) {
	            path.append((char)(i + 'A' - 1) + "<=");
	            i = way[i];
	        }
	        path.append((char)(s + 'A' - 1));
	        
	        return path.toString();
	    }

	    public String getDistance() {
	        return "Độ dài đường đi : " + dis[t];
	    }
	    
	    public void Dijkstra() {
	    	System.out.printf("Dijkstra");
	    	System.out.printf("s = " + s);
	    	System.out.printf("t = " + t);
	    	//System.out.printf("n =" + n + "s=" + s +"t=" + t);
	    	for(int v = 1; v <= n; v++) {
	    		dis[v] = Matrix[s][v];
	    		way[v] = s;
	    		confirm[v] = 0; 
	    	}
	    	way[s] = 0;
	    	dis[s] = 0;
	    	confirm[s] = 1;
	    	
	    	while(confirm[t] != 1) {
	    		min = INF;
	    		for(int v = 1; v <= n; v++ ) {
	    			if((confirm[v] != 1) && (dis[v] < min)) {
	    				u = v;
	    				min = dis[v];
	    			}
	    		}
	    		confirm[u] = 1;
	    		for(int v = 1; v <= n; v++) {
	    			if((confirm[v] != 1) && (dis[u] + Matrix[u][v] < dis[v])) {
	    				dis[v] = dis[u] + Matrix[u][v];
	    				way[v] = u;
	    				}
	    		}
	    	}
	    	for(int i = 1; i <= n; i++) {
	    		System.out.println("" + way[i]);
	    	}
	    	System.out.printf("Dijkstra out");
	    }
	    /*
	    public void runAlgorithm() 
	    {
	    	Algorithm dijkstra = new Algorithm();
	    	dijkstra.init();
	        dijkstra.loadMatrixFromFile("\\\\Mac\\Home\\Downloads\\PBL\\PBL\\src\\Djistra\\matrix.txt");
	        dijkstra.printMatrix();
	        dijkstra.Dijkstra();
	        dijkstra.Result();
	    }
	    */
	    
	    public void setText() {
	    	View view = new View();
	    	view._updateResults(getDistance());
	    	System.out.println("abc");
	    }
	    
	    public void runAlgorithm() 
	    {	 
	    	init();
	        loadMatrixFromFile("\\\\Mac\\Home\\Downloads\\PBL\\PBL\\src\\Djistra\\matrix.txt");
	        printMatrix();
	        Dijkstra();
	        //Result();
	        setText();
	    }
	    public void _runAlgorithm(String a) 
	    {	 
	    	System.out.println("nguồn " + a);
	    }
	    /*
	    public static void main(String[] args) 
	    {
	    	
	    	/*
	    	Algorithm dijkstra = new Algorithm();
	    	dijkstra.init();
	        dijkstra.loadMatrixFromFile("C:\\Users\\Mr Bach\\eclipse-workspace\\PBL\\src\\Djistra\\matrix.txt");
	        dijkstra.printMatrix();
	        dijkstra.Dijkstra();
	        dijkstra.Result();
	       sss
	    	Algorithm _dijkstra = new Algorithm();
	    	_dijkstra.runAlgorithm();
	    }
	    */
}
