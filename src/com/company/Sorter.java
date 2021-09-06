package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Sorter {

    String userInput;
    String sorted;

    public void read() {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Student Names");

        userInput = input.next();  // Read user input
        if(Objects.equals(userInput, ""))
        {
            System.out.println("Null string submitted");
            System.exit(0);
        }

        System.out.println("Student names are: " + userInput);  // Output user input

    }

    public void sort() {

        char temp[] = userInput.toCharArray();
        Arrays.sort(temp);
        sorted = new String(temp);

    }

    public void write()throws IOException {
        System.out.println("Sorted names are " + sorted);
        FileWriter out = new FileWriter("Results1.txt");
        out.write(sorted);
        out.close();

    }


}
