package com.miniminja.IOAssistTool.UI;

import java.awt.Color;
import java.awt.Graphics;

import com.miniminja.IOAssistTool.MouseManager;
/**
 * all possible UIObjects
 * 	Image
 * 	Blank
 *	Default
 * @author minyo
 *
 */

public abstract class UIObject {
	
	protected int x, y, width, height;
	protected boolean hovering, clicked;
	
	public UIObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		hovering = false;
		clicked = false;
	}
	
	public void render(Graphics g) {
		Color original = g.getColor();
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		g.setColor(original);
	}
	
	public void tick() {
		if(isRange(x, y, x+width, y+height,MouseManager.getXLoc(), MouseManager.getYLoc())) {
			hovering = true;
			if(MouseManager.clicked1()) {
				clicked = true;
			}
			else {
				clicked = false;
			}
		}
		else {
			hovering = false;
			clicked = false;
		}
		if(hovering) whenHover();
		if(clicked) whenClicked();
	}
	
	public abstract void whenHover();
	public abstract void whenClicked();
	
	public static boolean isRange(int x1, int y1, int x2, int y2, int x, int y) {
		return x >= x1 && x <= x2 && y >= y1 && y <= y2;
	}
}
