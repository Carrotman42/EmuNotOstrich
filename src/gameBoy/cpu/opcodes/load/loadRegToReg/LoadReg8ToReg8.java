package gameBoy.cpu.opcodes.load.loadRegToReg;

import gameBoy.cpu.Register;
import gameBoy.interfaces.IOpcode2;
import gameBoy.interfaces.IProcessor;

public enum LoadReg8ToReg8 implements IOpcode2 {
	AtoA(Register.A, Register.A), AtoB(Register.A, Register.B), AtoC(Register.A, Register.C), AtoD(Register.A, Register.D), AtoE(Register.A, Register.E), AtoH(Register.A, Register.H), AtoL(Register.A, Register.L), //
	BtoA(Register.B, Register.A), BtoB(Register.B, Register.B), BtoC(Register.B, Register.C), BtoD(Register.B, Register.D), BtoE(Register.B, Register.E), BtoH(Register.B, Register.H), BtoL(Register.B, Register.L), //
	CtoA(Register.C, Register.A), CtoB(Register.C, Register.B), CtoC(Register.C, Register.C), CtoD(Register.C, Register.D), CtoE(Register.C, Register.E), CtoH(Register.C, Register.H), CtoL(Register.C, Register.L), //
	DtoA(Register.D, Register.A), DtoB(Register.D, Register.B), DtoC(Register.D, Register.C), DtoD(Register.D, Register.D), DtoE(Register.D, Register.E), DtoH(Register.D, Register.H), DtoL(Register.D, Register.L), //
	EtoA(Register.E, Register.A), EtoB(Register.E, Register.B), EtoC(Register.E, Register.C), EtoD(Register.E, Register.D), EtoE(Register.E, Register.E), EtoH(Register.E, Register.H), EtoL(Register.E, Register.L), //
	HtoA(Register.H, Register.A), HtoB(Register.H, Register.B), HtoC(Register.H, Register.C), HtoD(Register.H, Register.D), HtoE(Register.H, Register.E), HtoH(Register.H, Register.H), HtoL(Register.H, Register.L), //
	LtoA(Register.L, Register.A), LtoB(Register.L, Register.B), LtoC(Register.L, Register.C), LtoD(Register.L, Register.D), LtoE(Register.L, Register.E), LtoH(Register.L, Register.H), LtoL(Register.L, Register.L);
	private final static int CYCLES = 4;
	private final Register to;
	private final Register from;
	
	private LoadReg8ToReg8(Register from, Register to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public void execute(IProcessor proc) {
		proc.getRegisters().setRegister(to, proc.getRegisters().getRegister(from));
	}
	
	@Override
	public int getCycles() {
		return CYCLES;
	}
	
	@Override
	public byte getOpcodeLength() {
		return 1;
	}
	
}
