

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;




//import se.mah.k3.Word;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;


public class WordFiles {
	public static ArrayList<Word> words=new ArrayList <Word>();
	//public ArrayList<String> list= new ArrayList<String>();
	public Firebase myFirebaseRef ;
	public static String word1[],word2[]; 
	
	 WordFiles (){
		
		//Firebase myFirebaseRef, regularWordsRef, themedWordsRef;
		
		myFirebaseRef = new Firebase("https://scorching-fire-1846.firebaseio.com/Joakim Words"); // Root
		//regularWordsRef = new Firebase("https://scorching-fire-1846.firebaseio.com/regularWords");
		//themedWordsRef = new Firebase("https://scorching-fire-1846.firebaseio.com/themedWords");
		//myFirebaseRef.removeValue(); // Cleans out everything
		
		//Firebase word = myFirebaseRef.child("Joakim Words");
		
		myFirebaseRef.child("Themed Wierd Size").setValue(1);
		
		Scanner input = null;
		try {
			input = new Scanner(new File("Resources/regularWords.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner input2 = null;
		try {
			input2 = new Scanner(new File("Resources/StarWarsTheme.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		word1 = input.nextLine().toLowerCase().split(" ");
		word2 = input2.nextLine().toLowerCase().split(" ");

		System.out.println("loadar in words");
		//Firebase wordList = myFirebaseRef.child("Joakim Words");
		
}

	public void firebase(String s){
		
		System.out.println(s + "  stuff" );
		
		
		int count = 0;
		System.out.println(word1.length+"hejsan");
		System.out.println(word1.length);
		for (int i = 0; i < word1.length; i++) {
	
			myFirebaseRef.child("word" + i + "/text").setValue(word1[i]);
			myFirebaseRef.child("word" + i + "/Active").setValue(false);
			myFirebaseRef.child("word" + i + "/Owner").setValue("");
			//int x=r.nextInt(Constants.screenWidth + 1); // skalad x pos
			//int y=r.nextInt(Constants.screenHeight + 1); // skalad y pos
			words.add(new Word(word1[i],"hej"));
			count++;
		}
		
		myFirebaseRef.child("Joakim Words Size").setValue(count);
		System.out.println("regular is on firebase now!!");
		
		
	switch(s){
			
			case "Star Wars":
				
				count = 0;
	
				System.out.println("Star Wars theme is on firebase now!!");
				System.out.println(word2.length);
				for (int i = 0; i < word2.length; i++) {
			
					myFirebaseRef.child("word" + i + "/text").setValue(word2[i]);
					myFirebaseRef.child("word" + i + "/Active").setValue(false);
					myFirebaseRef.child("word" + i + "/Owner").setValue("");
					//int x=r.nextInt(Constants.screenWidth + 1); // skalad x pos
					//int y=r.nextInt(Constants.screenHeight + 1); // skalad y pos
					words.add(new Word(word2[i],"hej"));
					count++;
				}
				myFirebaseRef.child("second Size").setValue(count);
				
				
			break;
			
			case "used":
			
			break;
	
	}
	
	
	
	}
	
	
	
	
}
