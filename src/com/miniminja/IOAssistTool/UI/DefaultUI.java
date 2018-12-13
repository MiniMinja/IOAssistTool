package com.miniminja.IOAssistTool.UI;

public class DefaultUI extends UIObject{

	public DefaultUI(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void whenHover() {
		System.out.println("I'm hovering!");
	}

	public void whenClicked() {
		System.out.println("I've been clicked!");
	}

}
