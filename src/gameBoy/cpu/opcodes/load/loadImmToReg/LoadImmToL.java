package gameBoy.cpu.opcodes.load.loadImmToReg;

import gameBoy.cpu.Register;
import gameBoy.interfaces.IProcessor;

public class LoadImmToL extends LoadImmToReg8 {

	public LoadImmToL(IProcessor processor, byte immediate) {
		super(processor, Register.L, immediate);
	}

}