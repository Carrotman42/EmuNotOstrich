package gameBoy.cpu.opcodes.load;

import gameBoy.cpu.Register;
import gameBoy.interfaces.IOpcode;
import gameBoy.interfaces.IProcessor;

public class LoadImmToReg16 implements IOpcode {
	private static int cycles = 8;
	private IProcessor processor;
	private Register register;
	private short immediate;
	
	public LoadImmToReg16( IProcessor processor , Register register, short immediate ) {
		this.processor = processor;
		this.register = register;
		this.immediate = immediate;
	}
	
	public void execute() {
		this.processor.getRegisters().setRegister( register, immediate ); 
	}
	
	public int getCycles() {
		return cycles;
	}
}
