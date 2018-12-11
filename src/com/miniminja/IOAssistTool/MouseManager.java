package com.miniminja.IOAssistTool;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class MouseManager implements MouseInputListener{
	
	private static int[] mouseLoc;
	private static boolean[] clicked;
	
	private static MouseManager sole_object;
	
	private MouseManager() {
		mouseLoc = new int[2];
		clicked = new boolean[2];
	}

	public static MouseManager getInstance(){
		if(sole_object == null) sole_object = new MouseManager();
		return sole_object;
	}
	
	public static int getXLoc() {
		return mouseLoc[0];
	}
	public static int getYLoc() {
		return mouseLoc[1];
	}
	public static boolean clicked1() {
		return clicked[0];
	}
	public static boolean clicked2(){
		return clicked[1];
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent e) {
		switch(e.getButton()) {
		
			case MouseEvent.BUTTON1:
				clicked[0] = true;
				break;
			case MouseEvent.BUTTON3:
				clicked[1] = true;
				break;
		
		}
	}

	public void mouseReleased(MouseEvent e) {
		switch(e.getButton()) {
		
			case MouseEvent.BUTTON1:
				clicked[0] = false;
				break;
			case MouseEvent.BUTTON3:
				clicked[1] = false;
				break;
		
		}
	}

	public void mouseDragged(MouseEvent arg0) {
		
	}

	public void mouseMoved(MouseEvent e) {
		mouseLoc[0] = e.getXOnScreen();
		mouseLoc[1] = e.getYOnScreen();
	}

}
