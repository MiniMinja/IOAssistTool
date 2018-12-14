package com.miniminja.IOAssistTool.UI;

import java.io.*;

import java.util.ArrayList;

import java.awt.Graphics;

public abstract class UIManager {
	protected ArrayList<UIObject> map;
	protected boolean initialized;
	
	public UIManager() {
		map = new ArrayList<UIObject>();
		initialized = false;
	}
	
	public void init(String uimapPath) {
		initialized = true;
	}
	
	public void render(Graphics g) {
		if(!initialized) {
			System.out.println("Run init() after defining the location varaible!");
			return;
		}
		for(UIObject o: map) o.render(g);
	}
	
	public void tick() {
		if(!initialized) {
			System.out.println("Run init() after defining the location varaible!");
			return;
		}
		for(UIObject o: map) o.tick();
	}
}
