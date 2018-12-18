package com.miniminja.IOAssistTool;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyManager implements KeyListener{
	private static HashMap<String, Boolean> keys_pressed;
	
	public static boolean isPressed(String cha) {
		if(keys_pressed == null) {
			System.out.println("Key Manager not initialized. Run getInstance()!");
			return false;
		}
		return keys_pressed.get(cha);
	}
	
	private static KeyManager sole_object;
	
	private KeyManager() {
		keys_pressed = new HashMap<String, Boolean>();
		
		for(char i = 'a';i<='z';i++) {
			keys_pressed.put(""+i, false);
		}
		keys_pressed.put(".", false);
		keys_pressed.put(",", false);
	}
	
	public static KeyManager getInstance() {
		if(sole_object == null) sole_object = new KeyManager();
		return sole_object;
	}
	
	public void keyPressed(KeyEvent e) {
		if(keys_pressed == null) {
			System.out.println("Key Manager not initialized. Run getInstance()!");
			return;
		}
		keys_pressed.put(""+e.getKeyChar(), true);
	}

	public void keyReleased(KeyEvent e) {
		if(keys_pressed == null) {
			System.out.println("Key Manager not initialized. Run getInstance()!");
			return;
		}
		keys_pressed.put(""+e.getKeyChar(), false);
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
}
