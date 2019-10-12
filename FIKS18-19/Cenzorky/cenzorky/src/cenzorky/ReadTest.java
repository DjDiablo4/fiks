package cenzorky;

import java.io.*;
import java.util.Arrays;

public class ReadTest {
	double startTime = System.nanoTime();
  public ReadTest(String path) throws Exception {
  	  File file = 
  		      new File(path);
  	PrintWriter writer = new PrintWriter("C:\\myFolders\\FIKS\\FIKS18-19\\Cenzorky\\cenzorky\\src\\cenzorky\\result.txt", "UTF-8");
  	BufferedReader br = new BufferedReader(new FileReader(file));
  	
    int pocetSad = Integer.parseInt(br.readLine());
    	for(int sada = 0; sada < pocetSad; sada++) { 						// Rozdeleni Inputu v Jednotlive sady
    		int cenzorkyOtazky[] = str2int(br.readLine()); 				// Prevedeni line s otazkami a poctem Ohryzku na intArr
    		int IDs[] = str2int(br.readLine());							// Prevedeni line s IDs na intArr
    		for(int otazka = 0; otazka < cenzorkyOtazky[1]; otazka++) { 	// Read vsech radek s intervaly
    		int interval[] = str2int(br.readLine());						// Prevedeni line s Intervalem na intArr
    			writer.println(minID(interval[0], interval[1], IDs));
    			writer.println(indexOfMax(interval[0], interval[1], IDs));
    			writer.println(xor(interval[0], interval[1], IDs));
    		}
    		
    		//System.out.println(Arrays.toString(cenzorkyOtazky));
    		//while ((st = br.readLine()) != null) {
    	//}
    }
    writer.close();
    double endTime = System.nanoTime();
    System.out.println("Trvalo "+((endTime - startTime) / 1000000000) + " sekund"); 
  }
  
  static int[] str2int(String line) {
	String [] strArr = line.split(" ");
	int size = strArr.length;
	int [] intArr = new int [size];
  	for(int i = 0; i<size; i++) {
  		intArr[i] = Integer.parseInt(strArr[i]);
  	}
  	return intArr;
  }
  
  private int minID(int interval, int interval2, int IDs[]) {
	  int smallest = IDs[(int) interval];
	  for(int index = interval; index <= interval2; index++) {
		  if (IDs[(int) index] < smallest) smallest = IDs[(int) index];
	  }
	  return smallest;
  }
  
  private int indexOfMax(int interval, int interval2, int IDs[]) {
	  int largest = -1;
	  int result = 0;
	  for(int index = interval; index <= interval2; index++) {
		  if (IDs[(int) index] > largest) {
			  largest = IDs[(int) index];
			  result = index;
		  }
	  }
	  return result;
  }

  private int xor(int interval, int interval2, int IDs[]) {
	  int xored = 0;
	  for(int index = interval; index<=interval2; index++) {
		  xored = xored ^ IDs[index];
	  }
	  return xored;
  }
} 