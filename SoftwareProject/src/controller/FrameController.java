package controller;

import java.awt.Dimension;

import view.*;

public class FrameController {

	static SystemFrame frame = null;
	
	public static SystemFrame getFrame() {
		if (frame == null) {
			frame = new SystemFrame();
		}
		return frame;
	}
	
	public static void changeSize(int width, int height) {
		frame.getContentpane().setPreferredSize(new Dimension(width, height));
		frame.setContentPane(frame.getContentpane());
		frame.pack();
	}
	
	public static void changeSize() {
		frame.getContentpane().setPreferredSize(new Dimension(450, 300));
		//frame.setContentPane(frame.getContentpane());
		frame.pack();
	}
}
