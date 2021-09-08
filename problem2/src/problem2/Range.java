package problem2;

import java.util.*;
import java.io.*;

public class Range {

	String userInput;
	int range1;
	int range2;

	public void read(){
		//reads input
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your number range, seperated by a comma.");
		userInput = input.next();

		//seperates input by comma, stores into two ints
		String[] ranges = userInput.split(",");
		range1 = Integer.parseInt(ranges[0]);
		range2 = Integer.parseInt(ranges[1]);

		//if range is backwards or negative
		if((range2 <= range1) || (range2 < 0) || (range1 < 0)){
			System.out.println("Your range is incompatible. Please try again.");
		}
		//if termination condition
		if(range1 == 0 && range2 == 0) {
			System.exit(0);
		}
		//normally i'd call this through the main and use range.arraystuff but for the sake of the eternal loop i do it here
		arrayStuff();
	}

	public void arrayStuff(){
		//new array list woohoo dynamic shiz
		ArrayList<Integer> arrayOfRange = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){ // 100 times
			for(int j = 0; j < 10; j++){ //increments of 10
				Random r = new Random(); //random number
				int num = r.nextInt((range2 - range1) + 1) + range1; //within the two ranges
				arrayOfRange.add(num); //adds random number within ranges to array
			}
			printStuff(arrayOfRange); //beings printing
		}
		//clearing out all the old stuff to make room for new ranges with the eternal loop
		range1 = 0;
		range2 = 0;
		arrayOfRange.clear();
		read();

	}

	public void printStuff(ArrayList<Integer> ranges){
		System.out.println("");//formatting
		System.out.print("Values:");
		for(int i = 0; i < ranges.size(); i++){
			System.out.print(" " + ranges.get(i)); //basic array iteration
		}
		System.out.println("");

		double counter, mean = 0;
		for(int i = 0; i < ranges.size(); i++){
			counter += ranges.get(i); //adds every value to a counter
		}
		mean = (counter / (double)(ranges.size())); //divides sum by size, formatted into double
		System.out.println("Mean: " + mean); 
		counter = 0;
		//calculate standard deviation
		for(int i = 0; i < ranges.size(); i++){
			counter += Math.pow((ranges.get(i)-mean),2);
		}
		mean=counter/(ranges.size() - 1);
		double deviation = Math.sqrt(mean);
		System.out.println("SD :"+deviation);
		
	}