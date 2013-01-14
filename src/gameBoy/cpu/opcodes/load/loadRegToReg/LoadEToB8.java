package gameBoy.cpu.opcodes.load.loadRegToReg;

import gameBoy.cpu.Register;
import gameBoy.interfaces.IProcessor;

public class LoadEToB8 extends LoadRegToReg8 {

	public LoadEToB8(IProcessor processor) {
		super(processor, Register.B, Register.E);
	}

}