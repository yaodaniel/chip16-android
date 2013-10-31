package com.example.chip16;

public class Cpu {
	// Registers
	private short pc; // Program counter
	private short sp; // Stack pointer
	private short[] reg = new short[16]; // Data registers
	private byte flags; // Flag registers

	// Opcodes [HEADER 00] [XY REG] [LL low byte] [HH high byte]
	private byte[] opcode = new byte[4]; // 4 byte opcodes

	// Other devices
	private Memory memory;

	public void initCPU() {
		//TODO
	}

	public void fetchOpcode() {
		for (int i = 0; i < 4; i++) {
			opcode[i] = memory.getByte(pc + i);
		}
	}

	public void runInstruction() {
		switch (opcode[0] >> 4) {
		//MISC
		case 0x0:
			switch (opcode[0] & 0xf) {
			case 0x0:
				// NOP
				break;
			case 0x1:
				// CLS
				break;
			case 0x2:
				// VBLANK
				break;
			case 0x3:
				// BGC N
				break;
			case 0x4:
				// SPR HHLL
				break;
			case 0x5:
				// DRAW RX, RY, HHLL
				break;
			case 0x6:
				// DRAW RX, RY, RZ
				break;
			case 0x7:
				// RANDOM RX, HHLL
				break;
			case 0x8:
				// FLIP N, N
				break;
			case 0x9:
				// SND0
				break;
			case 0xa:
				// SDN1 HHLL
				break;
			case 0xb:
				// SND2 HHLL
				break;
			case 0xc:
				// SND3
				break;
			case 0xd:
				// SNP RX, HHL
				break;
			case 0xe:
				// SNG AD, VTSR
				break;
			}
		//Jumps and branches
		case 0x1:
			switch (opcode[0] & 0xf) {
			case 0x0:
				// JMP HHLL
				break;
			case 0x2:
				// Jx HHLL
				break;
			case 0x3:
				// JME RX, RY, HHLL
				break;
			case 0x4:
				// CALL HHLL
				break;
			case 0x5:
				// RET
				break;
			case 0x6:
				// JMP RX
				break;
			case 0x7:
				// Cx HHLL
				break;
			case 0x8:
				// CALL RX
				break;
			}
		//Loads
		case 0x2:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//LDI RX, HHLL
				break;
			case 0x1:
				//LDI SP, HHLL
				break;
			case 0x2:
				//LDM RX, HHLL
				break;
			case 0x3:
				//LDM RX, RY
				break;
			case 0x4:
				//MOV RX, RY
				break;
			}
		//Stores
		case 0x3:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//STM RX, HHLL
				break;
			case 0x1:
				//STM RX, HLL
				break;
			}
		// Addition
		case 0x4:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//ADDI RX, HHLL
				break;
			case 0x1:
				// ADD RX, RY
				break;
			case 0x2:
				//ADD RX, RY, RZ
				break;
			}
		//Subtraction
		case 0x5:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//SUBI RX, HHLL
				break;
			case 0x1:
				//SUB RX, RY
				break;
			case 0x2:
				//SUB RX, RY, RZ
				break;
			case 0x3:
				//CMPI RX, HHLL
				break;
			case 0x4:
				//CMP RX, RY
				break;
		}
		//bitwise AND
		case 0x6:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//ANDI RX, HHLL
				break;
			case 0x1:
				//AND RX, RY
				break;
			case 0x2:
				//AND RX, RY, RZ
				break;
			case 0x3:
				//TSTI RX, HHLL
				break;
			case 0x4:
				//TST RX, RY
				break;
		}
		//bitwise OR
		case 0x7:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//ORI RX, HHLL
				break;
			case 0x1:
				//OR RX, RY
				break;
			case 0x2:
				//OR RX, RY, RZ
				break;
			}
		//bitwise XOR
		case 0x8:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//XORI RX, HHLL
				break;
			case 0x1:
				//XOR RX, RY
				break;
			case 0x2:
				//XOR RX, RY, RZ
				break;
		}
		//Multiplication
		case 0x9:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//MULI RX, HHLL
				break;
			case 0x1:
				//MUL RX, RY
				break;
			case 0x2:
				//MUL RX, RY, RZ
				break;
		}
		//Division
		case 0xa:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//DIVI RX, HHLL
				break;
			case 0x1:
				//DIV RX, RY
				break;
			case 0x2:
				//DIV RX, RY, RZ
				break;
		}
		//Logical/Arithmetic shifts
		case 0xb:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//SHL RX, N
				break;
			case 0x1:
				//SHR RX, N
				break;
			case 0x2:
				//SAR RX, N
				break;
			case 0x3:
				//SHL RX, RY
				break;
			case 0x4:
				//SHR RX, RY
				break;
			case 0x5:
				//SAR RX, RY
				break;
		}
		//Push/Pop
		case 0xc:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//PUSH RX
				break;
			case 0x1:
				//POP RX
				break;
			case 0x2:
				//PUSHALL
				break;
			case 0x3:
				//POPALL
				break;
			case 0x4:
				//PUSHF
				break;
			case 0x5:
				//POPF
				break;
		}
		//Palette
		case 0xd:
			switch(opcode[0] & 0xf) {
			case 0x0:
				//PAL HHLL
				break;
			case 0x1:
				//PAL RX
				break;
			}
		}
	}
}
