package gameBoy.cpu.opcodes.load.loadRegToAddrReg;

import gameBoy.cpu.Register;
import gameBoy.interfaces.IProcessor;

public class LoadLToAddrHL8 extends LoadReg8ToAddrReg16 {
	public LoadLToAddrHL8( IProcessor processor ) {
		super( processor, Register.L, Register.HL );
	}
}
