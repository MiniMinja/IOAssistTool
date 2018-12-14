package com.miniminja.IOAssistTool;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.miniminja.IOAssistTool.UI.ImageUI;
import com.miniminja.IOAssistTool.UI.UIManager;

import Mindow.*;

public class IOToolTester {
	
	public static class SimpleManager extends UIManager{

		public void init(String uimapPath) {
			super.init(uimapPath);
			try {
				BufferedReader file = new BufferedReader(new FileReader(uimapPath));
				int i = Integer.parseInt(file.readLine());
				for(int x = 0;x<i;x++) {
					file.readLine();
					String[] line = file.readLine().trim().split(",");
					map.add(
							new ImageUI(ImageUI.getImage(line[0]), 
							Integer.parseInt(line[1]), Integer.parseInt(line[2]),
							Integer.parseInt(line[3]),Integer.parseInt(line[4])));
				}
			}catch(IOException e) {
				System.out.println("Cannot find the file");
			}
		}
		
	}
	
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
		SimpleManager sm = new SimpleManager();
		sm.init("UIMap/battle.uim");
		UIDrawer uidrawer = new UIDrawer(sm);
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
