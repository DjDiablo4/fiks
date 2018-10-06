package cenzorky;

import java.io.*;
import java.util.Arrays;

public class Process{
	public Process(String path) throws Exception { 
		  File file = 
			      new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
	  int pocetSad = Integer.parseInt(br.readLine());
	  	for(int sada = 0; sada < pocetSad; sada++) { 					// Rozdeleni Inputu v Jednotlive sady
	  		int cenzorkyOtazky[] = str2Int(br.readLine()); 				// Prevedeni line s otazkami a poctem Ohryzku na intArr
	  		int IDs[] = str2Int(br.readLine());							// Prevedeni line s IDs na intArr
	  		for(int otazka = 0; otazka < cenzorkyOtazky[1]; otazka++) { // Read vsech radek s intervaly
	  		int interval[] = str2Int(br.readLine());					// Prevedeni line s Intervalem na intArr
	  			System.out.println(xor(interval[0], interval[1], IDs) + " XOR IDs");
	  			System.out.println(Arrays.toString(interval) + " Interval pro otázky");
	  			System.out.println(Arrays.toString(IDs) + " IDs ohryzku");
	  		}
	  		System.out.println(" ");
	  		
	  		//System.out.println(Arrays.toString(cenzorkyOtazky));
	  		//while ((st = br.readLine()) != null) {
	  	//}
  		}
	}
	  private int[] str2Int(String line) {
			String [] strArr = line.split(" ");
			int size = strArr.length;
			int [] intArr = new int [size];
		  	for(int i = 0; i<size; i++) {
		  		intArr[i] = Integer.parseInt(strArr[i]);
		  	}
		  	return intArr;
		  }
		  
		  private int minID(int min, int max, int IDs[]) {
			  int smallest = IDs[min];
			  for(int index = min; index <= max; index++) {
				  if (IDs[index] < smallest) smallest = IDs[index];
			  }
			  return smallest;
		  }
		  
		  private int indexOfMax(int min, int max, int IDs[]) {
			  int largest = -1;
			  int result = 0;
			  for(int index = min; index <= max; index++) {
				  if (IDs[index] > largest) {
					  largest = IDs[index];
					  result = index;
				  }
			  }
			  return result;
		  }

		  private int xor(int min, int max, int IDs[]) {
			  if (max - min == 0) return 0;
			  for(; min < max; min++) {
				  int end = max;
				  for(; min < end; end--) {
					  System.out.println("    " + IDs[min] + "       " + IDs[end]);
					  if (IDs[min] == IDs[end]) {
						  return 0;
					  }
				  }
			  }
			  return 1;
		  }
}
