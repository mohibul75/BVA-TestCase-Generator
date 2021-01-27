package bva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {
	
	public static Scanner input;
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		System.out.print("Enter the number of parameter: ");
		int n=input.nextInt();
		
		int[] max = new int[n];
		int [] min=new int[n];
		int [] nominal=new int[n];
		int [] lowerThanMax=new int[n];
		int [] lowerThanMin=new int[n];
		int [] UpperThanMax=new int[n];
		int [] UpperThanMin=new int[n];
		
		for(int i=0 ; i<n ; i++) {
			System.out.print("Enter the max and min of parameter no :  "+(i+1)+"   ");
			max[i]=input.nextInt();
			min[i]=input.nextInt();
			nominal[i]=(max[i] + min[i])/2;
			lowerThanMax[i]=max[i]-1;
			lowerThanMin[i]=min[i]-1;
			UpperThanMax[i]=max[i]+1;
			UpperThanMin[i]=min[i]+1;
		}
		
		BVC bvc = new BVC();
		Worst_Case wc = new Worst_Case();
		Robust_Case rc = new Robust_Case();
		
		String strForBvc = bvc.bvcFunction(n,max,min,nominal,lowerThanMax,UpperThanMin);
		String strForWc = wc.Worst_Case_Function(n,max,min,nominal,lowerThanMax,UpperThanMin,UpperThanMax,lowerThanMin);
		String strForRc = rc.Robust_Case_Function(n,max,min,nominal,lowerThanMax,UpperThanMin,UpperThanMax,lowerThanMin);
		
		 CSVWriter(strForBvc,"BVC.csv");
		 CSVWriter(strForRc,"Robust.csv");
		 CSVWriter( strForWc, "WorstCase.csv");
	}
	
	 public static void CSVWriter(String str, String pathname)
	    {
	        try (PrintWriter writer = new PrintWriter(new File(pathname))) {

	            writer.write(str);

	            System.out.println(" *************COMPLETE**********");

	        } catch (FileNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	    }

}
