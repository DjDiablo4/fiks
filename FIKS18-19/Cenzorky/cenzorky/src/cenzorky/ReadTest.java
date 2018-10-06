package cenzorky;

import java.io.*;
import java.util.Arrays;

public class ReadTest {
	double startTime = System.nanoTime();
  public ReadTest(String path) throws Exception {
  	  File file = 
  		      new File(path);
  	BufferedReader br = new BufferedReader(new FileReader(file));
  	
    int pocetSad = Integer.parseInt(br.readLine());
    	for(int sada = 0; sada < pocetSad; sada++) { 						// Rozdeleni Inputu v Jednotlive sady
    		long cenzorkyOtazky[] = str2long(br.readLine()); 				// Prevedeni line s otazkami a poctem Ohryzku na intArr
    		long IDs[] = str2long(br.readLine());							// Prevedeni line s IDs na intArr
    		for(int otazka = 0; otazka < cenzorkyOtazky[1]; otazka++) { 	// Read vsech radek s intervaly
    		long interval[] = str2long(br.readLine());						// Prevedeni line s Intervalem na intArr
    			System.out.println(minID(interval[0], interval[1], IDs));
    			System.out.println(indexOfMax(interval[0], interval[1], IDs));
    			System.out.println(xor(interval[0], interval[1], IDs));
    		}
    		
    		//System.out.println(Arrays.toString(cenzorkyOtazky));
    		//while ((st = br.readLine()) != null) {
    	//}
    }
    double endTime = System.nanoTime();
    System.out.println("Trvalo "+((endTime - startTime) / 1000000000) + " sekund"); 
  }
  
  static long[] str2long(String line) {
	String [] strArr = line.split(" ");
	int size = strArr.length;
	long [] intArr = new long [size];
  	for(int i = 0; i<size; i++) {
  		intArr[i] = Integer.parseInt(strArr[i]);
  	}
  	return intArr;
  }
  
  private long minID(long interval, long interval2, long IDs[]) {
	  long smallest = IDs[(int) interval];
	  for(long index = interval; index <= interval2; index++) {
		  if (IDs[(int) index] < smallest) smallest = IDs[(int) index];
	  }
	  return smallest;
  }
  
  private long indexOfMax(long interval, long interval2, long IDs[]) {
	  long largest = -1;
	  long result = 0;
	  for(long index = interval; index <= interval2; index++) {
		  if (IDs[(int) index] > largest) {
			  largest = IDs[(int) index];
			  result = index;
		  }
	  }
	  return result;
  }

  private int xor(long interval, long interval2, long IDs[]) {
	  if (interval2 - interval == 0) return 0;
	  int add = 0;
	  if (interval == 0) add = 1;
	  int [] binary = new int[(int) (interval2 - interval + add)];
	  for(; interval < interval2; interval++) {
		  long end = interval2;
		  int iBinary = 0;
		  for(; interval < end; end--) {
			  String firstB = Long.toBinaryString(IDs[(int) interval]);
			  str2long(firstB);
			  String lastB = Long.toBinaryString(IDs[(int) interval2]);
			  str2long(lastB);
			  if (firstB == firstB) 
				  binary[iBinary] = 0;
			  else binary[iBinary] = 1;
		  }
		  iBinary++;
	  }
	  System.out.println(Arrays.toString(binary).replaceAll("[, ]",""));
	  /*for (int x = 0 ; x < binary.length; x++) {
		  String newResult = new String
		  result + Integer.toString(x);
	  }*/
	  return 1;
  }
} 