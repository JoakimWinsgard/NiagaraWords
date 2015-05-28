

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;




//import se.mah.k3.Word;




import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;


public class WordFiles {
	public static ArrayList<Word> words=new ArrayList <Word>();
	public static String fileName[]={"regularWords","StarWarsTheme"};
	//public ArrayList<String> list= new ArrayList<String>();
	public Firebase myFirebaseRef ;
	public static String[][] word = new String[fileName.length][];
	

	 WordFiles (){
		//Firebase myFirebaseRef, regularWordsRef, themedWordsRef;
		myFirebaseRef = new Firebase("https://scorching-fire-1846.firebaseio.com/Joakim Words"); // Root
		//regularWordsRef = new Firebase("https://scorching-fire-1846.firebaseio.com/regularWords");
		//themedWordsRef = new Firebase("https://scorching-fire-1846.firebaseio.com/themedWords");
		//myFirebaseRef.removeValue(); // Cleans out everything
		//Firebase word = myFirebaseRef.child("Joakim Words");
		
		myFirebaseRef.child("Themed Wierd Size").setValue(1);
		for(int i=0; i<fileName.length;i++){
			Scanner input[]={null,null};
			try {
				input[i] = new Scanner(new File("Resources/"+fileName[i]+".txt"));
				word[i] = input[i].nextLine().toLowerCase().split(" ");
				System.out.println("loadar in words from "+ fileName[i]+".txt");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}
public void preview(){
	for(String s:word[0]){
		 TableColumn c = new TableColumn();
        c.setHeaderValue(s);
        Monitor.table.getColumnModel().addColumn(c);
	}
	
/*	 DefaultTableModel model = (DefaultTableModel) Monitor.table.getModel();
	 Vector<String> row = new Vector<String>();
	 row.add("text");
	 model.addRow(row);*/
}
	public void firebase(String s,int index){
		
		System.out.println(s + "  index:" + index);
		
		int count = 0;
		for (int i = 0; i < word[0].length; i++) {
			myFirebaseRef.child("word" + i + "/text").setValue(word[0][i]);
			myFirebaseRef.child("word" + i + "/Active").setValue(false);
			myFirebaseRef.child("word" + i + "/Owner").setValue("");
			//int x=r.nextInt(Constants.screenWidth + 1); // skalad x pos
			//int y=r.nextInt(Constants.screenHeight + 1); // skalad y pos
			words.add(new Word(word[0][i],"hej"));
			count++;
		}
		
		myFirebaseRef.child(fileName[0]+"  "+word[0].length+"Words Size").setValue(count);
		System.out.println(fileName[0]+" is on firebase now!!");
		
		
	switch(s){
			
			case "Star Wars":
				
				count = 0;
	
				System.out.println("Star Wars theme is on firebase now!!");
				System.out.println(word[1].length);
				for (int i = 0; i < word[1].length; i++) {
			
					myFirebaseRef.child("word" + i + "/text").setValue(word[1][i]);
					myFirebaseRef.child("word" + i + "/Active").setValue(false);
					myFirebaseRef.child("word" + i + "/Owner").setValue("");
					//int x=r.nextInt(Constants.screenWidth + 1); // skalad x pos
					//int y=r.nextInt(Constants.screenHeight + 1); // skalad y pos
					words.add(new Word(word[1][i],"hej"));
					count++;
				}
				myFirebaseRef.child("second Size").setValue(count);
				
				
			break;
			
			case "used":
			
			break;
	
	}
	
	
	
	}
	
	
	
	
}
