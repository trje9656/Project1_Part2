package prob3;

import java.util.*;
import java.io.*;

public class Decoder {

    String asciiInput;
    int stringlength;
    int decimalArray[] = new int[200]; // no more than 200 ascii codes in one go


    public void read(){
        Scanner input = new Scanner(System.in); //creates scanner
        System.out.println("Enter the ASCII codes you'd like to process"); //prompts user
        asciiInput = input.next(); //takes input
    }

    public void parse(){
        String[] codes = asciiInput.split(","); //parses string by commas
        stringlength = codes.length; //gets length to use in output() function
        for(int i = 0; i < codes.length; i++){
            decimalArray[i] = Integer.parseInt(codes[i]); //turns string ascii values into int values
        }


    }

    public void output()throws IOException{
        FileWriter out = new FileWriter("Results3.txt"); //opens writer
        for(int i = 0; i < stringlength; i++){
            String type = ""; //blank to assign in if statements
            char asciichar = (char) decimalArray[i]; //turning decimal into char
            //i used an ascii chart to determine which values are which
            if((decimalArray[i] >= 0 && decimalArray[i] <= 32) || decimalArray[i] == 127){ //from 0 to 32 or 127 are white spaces
                type = "White Space";
            }
            //from 33 to 47(! to /), 58 to 64(: to @), 91 to 96([ to `), and 123 to 126({ to ~) are special characters
            else if((decimalArray[i] >= 33 && decimalArray[i] <= 47) || (decimalArray[i] >= 58 && decimalArray[i] <= 64) || (decimalArray[i] >= 91 && decimalArray[i] <= 96) || (decimalArray[i] >= 123 && decimalArray[i] <= 126)){
                type = "Special Character";
            }
            else if(decimalArray[i] >= 48 && decimalArray[i] <= 57){ //48 to 57 are digits (0-9)
                type = "Digit";
            }
            else if(decimalArray[i] >= 65 && decimalArray[i] <= 90){ //65 to 90 are upper cases, (A-Z)
                type = "Upper Case";
            }
            else if(decimalArray[i] >=97 && decimalArray[i] <= 122){ //97 to 122 are lower cases, (a-z)
                type = "Lower Case";
            }
            else{
                System.out.println("Error: Invalid ASCII code at position " + i); //if an invalid ascii character
            }

            System.out.println("Code: " + decimalArray[i] + "    Type: " + type + "    ASCII Char: " + asciichar); //prints in terminal
            out.write("Code: " + decimalArray[i] + "    Type: " + type + "    ASCII Char: " + asciichar +"\n"); //prints to results3.txt
        }
        out.close();
    }



}
