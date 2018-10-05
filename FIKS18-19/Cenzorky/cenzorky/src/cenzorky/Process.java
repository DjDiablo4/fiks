package cenzorky;

import java.io.File; 
import java.util.Scanner;

public class Process {
	private String path;
	private String read;
	
	public Process(String path) {
	this.path = path;
	
    File file = 
    	      new File("C:\\Users\\pankaj\\Desktop\\test.txt"); 
    	    Scanner sc = new Scanner(file); 
    	  
    	    while (sc.hasNextLine()) 
    	      System.out.println(sc.nextLine()); 
  }
	
	private void readInput(String path) throws Exception{
		File file = 
			      new File(path); 
			    Scanner sc = new Scanner(file); 
			  
			    while (sc.hasNextLine()) 
			      System.out.println(sc.nextLine()); 
	}
} 
