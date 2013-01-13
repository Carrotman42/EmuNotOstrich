package gameBoy.cpu.opcodes.decrement;

import gameBoy.cpu.Register;
import gameBoy.interfaces.IProcessor;

public class DecD extends Decrement8 {

	public DecD(IProcessor processor) {
		super(processor, Register.D);
	}

}
