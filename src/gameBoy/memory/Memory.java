package gameBoy.memory;

import gameBoy.interfaces.IMemory;

public class Memory implements IMemory {
	public static int MEMORY_SIZE = 8192;
	private byte[] memory;
	
	public Memory() {
		this.memory = new byte[MEMORY_SIZE];
	}
	
	public short get16BitValue( int address ) {
		if( address >= 0 || address < MEMORY_SIZE -1 ) {
			return (short) ( ( this.memory[address] << 8 ) | this.memory[address + 1] );
		} else {
			return 0;
		}
	}
	
	public byte get8BitValue( int address ) {
		if( address >= 0 || address < MEMORY_SIZE ) {
			return this.memory[address];
		} else {
			return 0;
		}
	}
}