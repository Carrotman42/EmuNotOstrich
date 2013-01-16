package gameBoy.cpu.opcodes;

import gameBoy.interfaces.IOpcode;


public abstract class OneByteOpcode implements IOpcode {
	private static byte opcodeLength = 1;
	
	@Override
	public byte getOpcodeLength() {
		return opcodeLength;
	}
}
