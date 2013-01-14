package gameBoy.cpu.opcodes.and;

import gameBoy.cpu.Flag;
import gameBoy.cpu.Register;
import gameBoy.cpu.opcodes.OneByteOpcode;
import gameBoy.interfaces.IProcessor;

public class And extends OneByteOpcode {
	private static int cycles = 4;
	private Register register;
	private IProcessor processor;
	
	protected And( IProcessor processor, Register register ) {
		this.register = register;
		this.processor = processor;
	}
	
	@Override
	public void execute() {
		// And register with A, store in A ( A <- A & r )
		int A = this.processor.getRegisters().getRegister( Register.A );
		int n = this.processor.getRegisters().getRegister( register );
		
		int result = A & n;
		
		this.doFlagCheck( result );
		
		this.processor.getRegisters().setRegister( Register.A, result );
	}

	protected void doFlagCheck( int result ) {
		if( result == 0 ) {
			this.processor.getRegisters().setFlagTo( Flag.Z, true );
		} else {
			this.processor.getRegisters().setFlagTo( Flag.Z, false );
		}
		
		this.processor.getRegisters().setFlagTo( Flag.N, false );
		this.processor.getRegisters().setFlagTo( Flag.H, true );
		this.processor.getRegisters().setFlagTo( Flag.C, false );
	}
	
	@Override
	public int getCycles() {
		return cycles;
	}
}
