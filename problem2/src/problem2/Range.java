package problem2;

import java.util.*;
import java.io.*;
import java.util.Scanner;  
import java.util.stream.IntStream;

public class Range {
	public static int[] extend(int n, int arr[], int num1, int num2) {
		int i;
		int newarr[] = new int[n + 10];
		for (i = 0; i < n; i++)
            newarr[i] = arr[i];
		newarr = IntStream.rangeClosed(num1, num2).toArray();
		return newarr;
	}
	public static void calculate(int Array[],) {
		System.out.print("Values :");
		double sum, mean = 0;
		for(int i = 0; i < Array.length; i++){
			System.out.println(Array[i]);
			sum += Array[i];
		}
		mean = sum/Array.length;
		System.out.println("Mean :"+mean);
		sum = 0;
		for(int i = 0; i < Array.length; i++){
			sum += Math.pow((Array[i]-mean),2);
		}
		mean=sum/(Array.length-1);
		double deviation = Math.sqrt(mean);
		System.out.println("SD :"+deviation);
	}
	int [] Array = {};
	while(Array.length < 100) 
	{
		Scanner in_num1 = new Scanner(System.in);
		System.out.println("Enter Positive interger range value 1:");
		int num1 = in_num1.nextInt();
		Scanner in_num2 = new Scanner(System.in);
		ystem.out.println("Enter Positive interger range value 2:");
		int num2 = in_num2.nextInt();
		if(num2 >= num1 | num1 < 0 | num2 < 0) 
		{
			System.out.println("INPUT INVALID");
		}
		else if(num1 == 0 & num2 == 0) 
		{
			break;
		}
		else 
		{
			Array = extend(Array.length, Array, num1, num2);
			calculate(Array);
		}
	}
}
