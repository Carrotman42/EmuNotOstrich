package gameBoy.cpu.opcodes.or;

import gameBoy.cpu.Flag;
import gameBoy.cpu.Register;
import gameBoy.interfaces.IOpcode2;
import gameBoy.interfaces.IProcessor;
import gameBoy.interfaces.IRegister;

public enum Or implements IOpcode2 {
    // These names exclude the Or name because enums should be fully qualified anyway
    A(Register.A), B(Register.B), C(Register.C),
    D(Register.D), E(Register.E), H(Register.H), L(Register.L),
    AddrHL(null) {
        protected int getValForOp(IProcessor proc) {
            int addr = proc.getRegisters().getRegister( Register.HL );
            return proc.getMemory().get8BitValue( addr );
        }
        
        public int getCycles() {
            return 8;
        }
    },
    ImmToA(null) {
        protected int getValForOp(IProcessor proc) {
            int addr = proc.getRegisters().getRegister( Register.PC ) + 1;
            return proc.getMemory().get8BitValue( addr );
        }
        
        public int getCycles() {
            return 8;
        }
    };
    
	private final static int CYCLES = 4;
	private final Register register;
	
	private Or(Register register ) {
		this.register = register;
	}
	
	protected int getValForOp(IProcessor proc) {
	    return proc.getRegisters().getRegister( register );
	}
	
	@Override
	public void execute(IProcessor proc) {
	    IRegister regs = proc.getRegisters();
		// Or register with A, store in A ( A <- A | r )
		int A = regs.getRegister( Register.A );
		int n = getValForOp(proc);
		
		int result = A | n;
		
		this.doFlagCheck(regs, result );
		
		regs.setRegister( Register.A, result );
	}

	protected void doFlagCheck(IRegister regs, int result ) {
		if( result == 0 ) {
		    regs.setFlagTo( Flag.Z, true );
		} else {
		    regs.setFlagTo( Flag.Z, false );
		}
		
		regs.setFlagTo( Flag.N, false );
		regs.setFlagTo( Flag.H, false );
		regs.setFlagTo( Flag.C, false );
	}
	
	@Override
	public int getCycles() {
		return CYCLES;
	}
	
	// I wish I could inherit this from a base class, but enums can't have parents (other than Enum) :(
	@Override
	public byte getOpcodeLength() {
	    return 1;
	}
}
