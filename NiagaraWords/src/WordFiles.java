

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;


public class WordFiles {
	public static ArrayList<Word> words=new ArrayList <Word>();
	public static Firebase myFirebaseRef = new Firebase("https://scorching-fire-1846.firebaseio.com/Joakim Words"); // Root
	//regularWordsRef = new Firebase("https://scorching-fire-1846.firebaseio.com/regularWords");
	//themedWordsRef = new Firebase("https://scorching-fire-1846.firebaseio.com/themedWords");
	//myFirebaseRef.removeValue(); // Cleans out everything
	
	//Firebase word = myFirebaseRef.child("Joakim Words");
	
		WordFiles(){
		
		myFirebaseRef.setValue("test");
		myFirebaseRef.removeValue();
		Scanner input = null;
		try {
			input = new Scanner(new File("Resources/regularWords.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rWords = input.nextLine();
		rWords = rWords.toLowerCase();
		String word1[] = rWords.split(" ");
		System.out.println(rWords);
		System.out.println(word1.length);
		//Firebase wordList = myFirebaseRef.child("Joakim Words");
		int count = 0;
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
		
 }
}
