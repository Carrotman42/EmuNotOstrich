package gameBoy.cpu.opcodes.load.LoadImmToReg;

import gameBoy.cpu.Register;
import gameBoy.interfaces.IProcessor;

public class LoadImmToD extends LoadImmToReg8 {

	public LoadImmToD(IProcessor processor, byte immediate) {
		super(processor, Register.D, immediate);
	}

}
