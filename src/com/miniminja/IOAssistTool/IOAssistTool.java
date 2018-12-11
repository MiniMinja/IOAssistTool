package com.miniminja.IOAssistTool;

/**
 * This project is to help with input management to combine with Mindows
 * Basically, Mindows will import this project to make input grabbing easier
 */
public class IOAssistTool {
	private KeyManager key_manager;
	private MouseManager mouse_manager;
	
	public void initKeyManager() {
		key_manager = KeyManager.getInstance();
	}
	
	public KeyManager getKeyManager() {
		return key_manager;
	}
	
	public void initMouseManager() {
		mouse_manager = MouseManager.getInstance();
	}
	
	public MouseManager getMouseManager() {
		return mouse_manager;
	}
}
