package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            readPrintFile("src/main/resources/lorem.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readPrintFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(turnTexttoHex(line));
        }
        reader.close();
    }

    public static String turnTexttoHex(String text) {
        String hex = "";
        for (int i = 0; i < text.length(); i++) {
            //add a space after every 2 characters and a line break after ever 10th character block
            if (i % 10 == 0 && i != 0) {
                hex += "\n";
            }
            //turn the character into a hex value and add a space after every second character
            hex += Integer.toHexString(text.charAt(i)) + " ";
        }
        // add --------- at the end of the string
        hex += "\n---------";
        return hex;
    }
}