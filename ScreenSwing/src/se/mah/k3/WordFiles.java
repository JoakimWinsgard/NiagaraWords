package se.mah.k3;

import java.io.*;
import java.util.Scanner;

public class WordFiles {
	
	public static void main (String[] args) throws IOException
	{
		
		
		Scanner input = new Scanner(new File("Resources/regularWords.txt"));
		String rWords = input.nextLine();
		rWords = rWords.toLowerCase();
		String word[] = rWords.split(" ");
		System.out.println(rWords);
		System.out.println(word.length);
		
}
}
