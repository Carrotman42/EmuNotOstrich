package gameBoy.cpu.opcodes.load.loadRegToReg;

import gameBoy.cpu.Register;
import gameBoy.interfaces.IProcessor;

public class LoadHToB8 extends LoadRegToReg8 {

	public LoadHToB8(IProcessor processor) {
		super(processor, Register.B, Register.H);
	}

}
