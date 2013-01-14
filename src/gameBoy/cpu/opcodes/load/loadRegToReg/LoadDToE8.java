package gameBoy.cpu.opcodes.load.loadRegToReg;

import gameBoy.cpu.Register;
import gameBoy.interfaces.IProcessor;

public class LoadDToE8 extends LoadRegToReg8 {

	public LoadDToE8(IProcessor processor) {
		super(processor, Register.E, Register.D);
	}

}
