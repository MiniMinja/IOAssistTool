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
		
		keys_pressed.put("w", false);
		keys_pressed.put("a", false);
		keys_pressed.put("s", false);
		keys_pressed.put("d", false);
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
		switch(e.getKeyCode()) {
		
			case KeyEvent.VK_W:
				keys_pressed.put("w", true);
				break;
			case KeyEvent.VK_A:
				keys_pressed.put("a", true);
				break;
			case KeyEvent.VK_S:
				keys_pressed.put("s", true);
				break;
			case KeyEvent.VK_D:
				keys_pressed.put("d", true);
				break;
		
		}
	}

	public void keyReleased(KeyEvent e) {
		if(keys_pressed == null) {
			System.out.println("Key Manager not initialized. Run getInstance()!");
			return;
		}
		switch(e.getKeyCode()) {
		
			case KeyEvent.VK_W:
				keys_pressed.put("w", false);
				break;
			case KeyEvent.VK_A:
				keys_pressed.put("a", false);
				break;
			case KeyEvent.VK_S:
				keys_pressed.put("s", false);
				break;
			case KeyEvent.VK_D:
				keys_pressed.put("d", false);
				break;
		
		}
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
}
