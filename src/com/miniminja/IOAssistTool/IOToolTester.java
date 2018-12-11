package com.miniminja.IOAssistTool;

import javax.swing.JFrame;

public class IOToolTester {
	public static void main(String[] args) {
		IOAssistTool tool = new IOAssistTool();
		tool.initKeyManager();
		tool.initMouseManager();
		JFrame window = createJFrame();
		window.addKeyListener(tool.getKeyManager());
		window.addMouseListener(tool.getMouseManager());
		window.addMouseMotionListener(tool.getMouseManager());
		Thread job = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(33);
						if(KeyManager.isPressed("w")) System.out.println("W Pressed!");
						if(KeyManager.isPressed("a")) System.out.println("A Pressed!");
						if(KeyManager.isPressed("s")) System.out.println("S Pressed!");
						if(KeyManager.isPressed("d")) System.out.println("D Pressed!");
						
						System.out.println(MouseManager.getXLoc() + "," + MouseManager.getYLoc());
						System.out.println("Clicked 1: "+MouseManager.clicked1());
						System.out.println("Clicked 2: "+MouseManager.clicked2());
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		job.start();
	}
	
	public static JFrame createJFrame() {
		JFrame ret = new JFrame();
		ret.setLocationRelativeTo(null);
		ret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ret.setVisible(true);
		return ret;
	}
}
