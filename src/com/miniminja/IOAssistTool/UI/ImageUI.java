package com.miniminja.IOAssistTool.UI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;

public class ImageUI extends UIObject{
	
	public static BufferedImage getImage(String filePath) {
		try {
			BufferedImage image = ImageIO.read(new File(filePath));
			return image;
		}catch(IOException e) {
			System.out.println("Cannot find file");
			return null;
		}
	}
	
	private BufferedImage image;

	public ImageUI(BufferedImage image, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.image = image;
	}
	
	public void render(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
		if(hovering) {
			Color original = g.getColor();
			g.setColor(new Color(0, 0, 0, 125));
			g.fillRect(x, y, width, height);
			g.setColor(original);
		}
	}

	public void whenHover() {
		
	}

	public void whenClicked() {
		
	}

}
