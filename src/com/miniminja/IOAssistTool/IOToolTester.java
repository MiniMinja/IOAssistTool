package com.miniminja.IOAssistTool;

import java.awt.Graphics;

import com.miniminja.IOAssistTool.UI.UIManager;

import Mindow.*;

public class IOToolTester {
	public static class UIDrawer extends Drawer{
		private UIManager manager;
		
		public UIDrawer(UIManager manager) {
			this.manager = manager;
		}

		public void draw(Graphics g) {
			manager.render(g);
		}

		public void tick() {
			manager.tick();
		}
		
	}
	
	public static void main(String[] args) {
		IOAssistTool tool = new IOAssistTool();
		tool.initKeyManager();
		tool.initMouseManager();
		Mindow window = Mindow.getDefault();
		window.addKeyListener(tool.getKeyManager());
		window.addMouseInputListener(tool.getMouseManager());
		UIManager uimanager = new UIManager("UIMap/battle.uim");
		UIDrawer uidrawer = new UIDrawer(uimanager);
		Drawer.setDrawer(uidrawer);
		Thread job = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(33);
						window.render();
						uidrawer.tick();
						if(KeyManager.isPressed("w")) System.out.println("W Pressed!");
						if(KeyManager.isPressed("a")) System.out.println("A Pressed!");
						if(KeyManager.isPressed("s")) System.out.println("S Pressed!");
						if(KeyManager.isPressed("d")) System.out.println("D Pressed!");
						
						//System.out.println(MouseManager.getXLoc() + "," + MouseManager.getYLoc());
						//System.out.println("Clicked 1: "+MouseManager.clicked1());
						//System.out.println("Clicked 2: "+MouseManager.clicked2());
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		job.start();
	}
}
