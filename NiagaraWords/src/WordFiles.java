import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.firebase.client.Firebase;

public class WordFiles {
	public static ArrayList<Word> words=new ArrayList <Word>();
	public static String fileName[]={"wordListNew","regularWords","StarWarsTheme"};
	public static String fileStructure[]={""};
	public Firebase myFirebaseRef,FireBaseRoot ;
	public static String[][] word = new String[fileName.length][];

	WordFiles (){
		//Firebase myFirebaseRef, regularWordsRef, themedWordsRef;
		FireBaseRoot = new Firebase("https://scorching-fire-1846.firebaseio.com"); // Root

		myFirebaseRef = new Firebase("https://scorching-fire-1846.firebaseio.com"); // Root
		//regularWordsRef = new Firebase("https://scorching-fire-1846.firebaseio.com/regularWords");
		//themedWordsRef = new Firebase("https://scorching-fire-1846.firebaseio.com/themedWords");
		//myFirebaseRef.removeValue(); // Cleans out everything
		//Firebase word = myFirebaseRef.child("Joakim Words");

		myFirebaseRef.child("ScreenNbr").setValue(145); // Has to be same as on the app. So place specific can't you see the screen you don't know the number
		myFirebaseRef.child("ScreenWidth").setValue(1080); // Has to be same as on the app. So place specific can't you see the screen you don't know the number
		myFirebaseRef.child("ScreenHeight").setValue(888); // Has to be same as on the app. So place specific can't you see the screen you don't know the number
		for(int i=0; i<fileName.length;i++){
			Scanner input[]={null,null,null};
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
		/*DefaultTableModel model = (DefaultTableModel) Monitor.table.getModel();
		ArrayList<String> rows = new ArrayList<String>(){

			private static final long serialVersionUID = 1L;};
		for(String s:word[0]){
			TableColumn c = new TableColumn();
			c.setHeaderValue(s);
			rows.add(s);
			model.addRow(new Object[] {s});
		}*/

		/*	 DefaultTableModel model = (DefaultTableModel) Monitor.table.getModel();
	 Vector<String> row = new Vector<String>();
	 row.add("text");
	 model.addRow(row);*/
	}

	public void firebase(String s,int index){
		myFirebaseRef = new Firebase("https://scorching-fire-1846.firebaseio.com/Regular Words"); // Root
		System.out.println(s + "  index:" + index);

		int count = 0;
		for (int i = 0; i < word[0].length; i++) {
			myFirebaseRef.child("word" + i + "/text").setValue(word[0][i]);
			//myFirebaseRef.child("word" + i + "/active").setValue(false);
			myFirebaseRef.child("word" + i + "/occupied").setValue(false);
			//myFirebaseRef.child("word" + i + "/owner").setValue("");
			words.add(new Word(word[0][i],"hej"));
			count++;
		}

		FireBaseRoot.child("Regular Words Size").setValue(count);
		System.out.println(fileName[0]+" is on firebase now!!");		

		switch(s){

		case "Star Wars":

			count = 0;

			System.out.println("Star Wars theme is on firebase now!!");
			System.out.println(word[2].length);
			for (int i = 0; i < word[2].length; i++) {

				myFirebaseRef.child("word" + i + "/text").setValue(word[1][i]);
				myFirebaseRef.child("word" + i + "/active").setValue(false);
				myFirebaseRef.child("word" + i + "/occupied").setValue(false);
				myFirebaseRef.child("word" + i + "/owner").setValue("");
				words.add(new Word(word[2][i],"hej"));
				count++;
			}
			FireBaseRoot.child("Themed Words Size").setValue(count);


			break;

		case "used":
			myFirebaseRef = new Firebase("https://scorching-fire-1846.firebaseio.com/Used Words"); // Root
			count = 0;
			for (int i = 0; i < word[1].length; i++) {
				myFirebaseRef.child("word" + i + "/attributes/text").setValue(word[0][i]);
				myFirebaseRef.child("word" + i + "/attributes/active").setValue(false);
				myFirebaseRef.child("word" + i + "/attributes/occupied").setValue(false);
				myFirebaseRef.child("word" + i + "/attributes/owner").setValue("");
				myFirebaseRef.child("word" + i + "/attributes/xRel").setValue(0.5);
				myFirebaseRef.child("word" + i + "/attributes/yRel").setValue(0.5);
				words.add(new Word(word[1][i],"hej"));
				count++;
			}

			myFirebaseRef.child(fileName[1]+"  "+word[0].length+"Used Word Size").setValue(count);
			System.out.println(fileName[1]+" is on Used firebase now!!");

			break;
			
		case "New":
			myFirebaseRef = new Firebase("https://scorching-fire-1846.firebaseio.com/New"); // Root
			count = 0;
			for (int i = 0; i < word[0].length; i++) {
				myFirebaseRef.child("word" + i + "/attributes/text").setValue(word[0][i]);
				myFirebaseRef.child("word" + i + "/attributes/active").setValue(false);
				myFirebaseRef.child("word" + i + "/attributes/occupied").setValue(false);
				myFirebaseRef.child("word" + i + "/attributes/owner").setValue("");
				myFirebaseRef.child("word" + i + "/attributes/xRel").setValue(0.5);
				myFirebaseRef.child("word" + i + "/attributes/yRel").setValue(0.5);
				words.add(new Word(word[0][i],"hej"));
				count++;
			}

			myFirebaseRef.child(fileName[0]+"  "+word[0].length+"Used Word Size").setValue(count);
			System.out.println(fileName[0]+" is on Used firebase now!!");

			break;
		}
	}	
}