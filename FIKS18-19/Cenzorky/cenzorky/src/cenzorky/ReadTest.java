package cenzorky;

import java.io.File; 
import java.util.Scanner; 
public class ReadTest { 
  public static void main(String[] args) throws Exception 
  { 
    // pass the path to the file as a parameter 
    File file = 
      new File("C:\\myFolders\\FIKS\\FIKS18-19\\Cenzorky\\cenzorky\\src\\cenzorky\\input.txt"); 
    Scanner sc = new Scanner(file); 
  
    while (sc.hasNextLine()) 
      System.out.println(sc.nextLine()); 
  } 
} 