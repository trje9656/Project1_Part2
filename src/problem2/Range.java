package problem2;

import java.util.*;
import java.io.*;
/* NOTE:
YOU MUST TERMINATE THE PROGRAM BY ENTERING 0,0 TO MAKE EVERYTHING WRITE TO RESULTS2.TXT!!
 */
public class Range {

	String userInput;
	int range1;
	int range2;
	FileWriter out = new FileWriter("Results2.txt");

	public Range() throws IOException {
	}

	public void Close() throws IOException{
		out.close();
	}

	public void read() throws IOException {
		//reads input
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your number range, seperated by a comma.");
		userInput = input.next();

		//seperates input by comma, stores into two ints
		String[] ranges = userInput.split(",");
		range1 = Integer.parseInt(ranges[0]);
		range2 = Integer.parseInt(ranges[1]);


		//if termination condition
		if (range1 == 0 && range2 == 0) {
			Close();
			System.exit(0);
		}

		//if range is backwards or negative
		if ((range2 <= range1) || (range2 < 0) || (range1 < 0)) {
			System.out.println("Your range is incompatible. Please try again.");
		}

		//normally i'd call this through the main and use range.arraystuff but for the sake of the eternal loop i do it here
		arrayStuff();
	}

	public void arrayStuff() throws IOException {
		//new array list woohoo dynamic shiz
		ArrayList<Integer> arrayOfRange = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) { // 100 times
			for (int j = 0; j < 10; j++) { //increments of 10
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

	public void printStuff(ArrayList<Integer> ranges)throws IOException {
		 //opens writer
		System.out.print("\n");//formatting
		out.write("\n");

		System.out.print("Values:");
		out.write("Values:");

		for (int i = 0; i < ranges.size(); i++) {
			System.out.print(" " + ranges.get(i)); //basic array iteration
			out.write(" " + ranges.get(i));
		}
		System.out.println("");
		out.write("\n");

		double counter = 0, mean = 0;
		for (int i = 0; i < ranges.size(); i++) {
			counter += ranges.get(i); //adds every value to a counter
		}
		mean = (counter / (double) (ranges.size())); //divides sum by size, formatted into double

		System.out.println("Mean: " + mean);
		out.write("Mean: " + mean + "\n");

		counter = 0;
		//calculate standard deviation
		for (int i = 0; i < ranges.size(); i++) {
			counter += Math.pow((ranges.get(i) - mean), 2);
		}
		mean = counter / (ranges.size() - 1);
		double deviation = Math.sqrt(mean);
		System.out.println("SD :" + deviation);
		out.write("SD: " + deviation + "\n");

	}
}