package com.miniminja.IOAssistTool.UI;

import java.io.*;

import java.util.ArrayList;

import java.awt.Graphics;

public class UIManager {
	private ArrayList<UIObject> map;
	
	public UIManager(String filePath) {
		map = new ArrayList<UIObject>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			int amount = Integer.parseInt(br.readLine());
			for(int i = 0;i<amount;i++) {
				String type = br.readLine();
				String[] paramsStr = br.readLine().split(",");
				if(type.startsWith("Default")) {
					int[] params = new int[paramsStr.length];
					for(int j = 0;j<params.length;j++) {
						params[j] = Integer.parseInt(paramsStr[j]);
					}
					map.add(new DefaultUI(params[0], params[1], params[2], params[3]));
				}
				else {
					System.out.println(type+" is undefined on "+i+". Not created");
				}
			}
		}catch(IOException e) {
			System.out.println("Could not find UIMap files!");
		}
	}
	
	public void render(Graphics g) {
		for(UIObject o: map) o.render(g);
	}
	
	public void tick() {
		for(UIObject o: map) o.tick();
	}
}
