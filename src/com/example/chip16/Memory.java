package com.example.chip16;

import java.io.FileInputStream;

public class Memory {
	// 64kb of memory
	private byte[] memory = new byte[0x10000];
	private String fileDir;
	private String fileName;
	private boolean romLoaded;
	
	/** Creates a new instance of memory */
	public Memory() {
		closeRom(); //clears memory
	}
	
	public byte getByte(int i) {
		if(i >=0 && i < memory.length)
			return memory[i];
		else {
			System.out.println("Out of memory bounds");
			return 0;
		}
	}
	
	public void setByte(int i, byte b) {
		if(i >= 0 && i < memory.length)
			memory[i] = b;
		else
			System.out.println("Out of memory bounds");
	}
	
	//TODO
	public boolean loadRom(String fileDir, String fileName) {
		//Implement this
		// 0x0000 start of rom/ram
		// 0xfdf0 start of the stack (512 bytes)
		// 0xfff0 start of i/o ports (4 bytes)
		return false;
	}
	
	public boolean reloadRom() {
		return loadRom(fileDir, fileName);
	}
	
	public void closeRom() {
		fileDir = "";
		fileName = "";
		romLoaded = false;
	}
	
	public boolean isRomLoaded() {
		return romLoaded;
	}
	
	public String getRomName() {
		return fileName;
	}
}
