package com.gmail.at.sichyuriyy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {

	public static void main(String[] args) throws IOException {

		int mode;
		String inputFile = null;
		String outputFile = null;
		String exampleOfNumber;
		Scanner in = new Scanner(System.in);
		BufferedReader inputStream;
		PrintWriter outputStream;
		if (args.length == 0) {
			System.out
					.println("choose mode\n1)Inputs from console\n2)Inputs from file");
			mode = in.nextInt();
		} else if (args.length == 1) {
			mode = Integer.parseInt(args[0]);
		} else if (args.length == 2) {
			mode = Integer.parseInt(args[0]);
			inputFile = args[1];
		} else {
			mode = Integer.parseInt(args[0]);
			inputFile = args[1];
			outputFile = args[2];
		}

		if (mode == 1) {

			System.out.println("Enter an example of the telephone number");
		
			exampleOfNumber = in.next();
			exampleOfNumber = exampleOfNumber + in.nextLine();
			System.out.println(testNumber(exampleOfNumber));

		} else {

			if (inputFile == null) {
				System.out.println("Enter path to the input file");
				inputFile = in.next();
			}
			if (outputFile == null) {
				System.out.println("Enter path to the output file");
				outputFile = in.next();
			}
			inputStream = new BufferedReader(new FileReader(inputFile));
			outputStream = new PrintWriter(new FileWriter(outputFile));
			exampleOfNumber =inputStream.readLine();
			outputStream.println(testNumber(exampleOfNumber.toString()));
			inputStream.close();
			outputStream.close();
		}
		in.close();

	}

	public static boolean testNumber(String number) {
		Pattern p = Pattern
				.compile("((\\+?\\d)(\\s|-))?(((\\(\\d{3,4}\\))|(\\d{3,4}))(\\s|-))?((\\d{2,3}(\\s|-)){2}\\d{2,3})");
		Matcher m = p.matcher(number);
		return m.matches();
	}

}
