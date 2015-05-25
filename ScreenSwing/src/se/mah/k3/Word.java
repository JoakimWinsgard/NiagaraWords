package se.mah.k3;

import java.awt.Color;


//This is the class for the word object. It contains the words that
//the user will have displayed in their mobile app. 
//It also contains a boolean to check if the word is active or not.

public class Word {
	//DrawPanel drawPanel;
	private String type="";
	public boolean active = true, selected;
	public String ownerId = "";

	public enum State {onTray, draging, placed,locked};
	State state=State.onTray;
	public String text = "";
	public int xPos, yPos, width, height, margin = 20;
	public float pxPos, pyPos,txPos,tyPos;
	public Word(String _text, String _ownerId) {
		this.text = _text;
		this.ownerId = _ownerId;
		this.active = false;
	}
	public Word(String _text, String _ownerId,int _x,int _y, int _tx ,int _ty) {
		xPos=_x;
		yPos=_y;
		txPos=_tx;
		tyPos=_ty;
		this.text = _text;
		this.ownerId = _ownerId;
	}

	
}