package gameBoy.cpu.opcodes.load.loadImmToReg;

import gameBoy.cpu.Register;
import gameBoy.interfaces.IProcessor;

public class LoadImm8ToD8 extends LoadImm8ToReg8 {

	public LoadImm8ToD8(IProcessor processor) {
		super(processor, Register.D);
	}

}
