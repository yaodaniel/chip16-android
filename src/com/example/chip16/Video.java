package com.example.chip16;

/** The screen is 320x240 resolution, 4 bit indexed. */
public class Video {
	private byte bg; 
	private byte spritew;
	private byte spriteh;
	private boolean hflip;
	private boolean vflip;
	
	private short[] screen = new short[320*240];
	
	// Set background color to index n (0 is black)
	public void setBackground(byte n) {
		//TODO
	}
	
	// Set sprite width (LL) and height (HH)
	public void setSprite(short hhll) {
		//TODO
	}
	
	// Draw sprite at address HHLL at (RX, RY)
	public void drawSpriteAddr(short rx, short ry, short hhll) {
		//TODO
	}
	
	// Draw sprite from [rz] at (rx, ry)
	public void drawSpriteReg(short rx, short ry, short rz) {
		//TODO
	}
	
	// Set hflip and vflip
	public void flip(short hflip, short vflip) {
		//TODO
	}
}
