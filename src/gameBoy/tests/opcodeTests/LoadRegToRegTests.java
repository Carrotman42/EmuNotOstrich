package gameBoy.tests.opcodeTests;

import gameBoy.cpu.GameBoyProcessor;
import gameBoy.cpu.Register;
import gameBoy.cpu.opcodes.load.loadRegToReg.LoadReg8ToReg8;
import gameBoy.interfaces.IOpcode2;
import gameBoy.interfaces.IProcessor;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class LoadRegToRegTests {
	private IProcessor processor;
	
	@Before
	public void setUp() throws Exception {
		this.processor = new GameBoyProcessor();
	}
	
	@Test
	public void testLoadReg8ToReg8() {
		doTest(LoadReg8ToReg8.AtoA, Register.A, Register.A);
		doTest(LoadReg8ToReg8.AtoB, Register.A, Register.B);
		doTest(LoadReg8ToReg8.AtoC, Register.A, Register.C);
		doTest(LoadReg8ToReg8.AtoD, Register.A, Register.D);
		doTest(LoadReg8ToReg8.AtoE, Register.A, Register.E);
		doTest(LoadReg8ToReg8.AtoH, Register.A, Register.H);
		doTest(LoadReg8ToReg8.AtoL, Register.A, Register.L);
		doTest(LoadReg8ToReg8.BtoA, Register.B, Register.A);
		doTest(LoadReg8ToReg8.BtoB, Register.B, Register.B);
		doTest(LoadReg8ToReg8.BtoC, Register.B, Register.C);
		doTest(LoadReg8ToReg8.BtoD, Register.B, Register.D);
		doTest(LoadReg8ToReg8.BtoE, Register.B, Register.E);
		doTest(LoadReg8ToReg8.BtoH, Register.B, Register.H);
		doTest(LoadReg8ToReg8.BtoL, Register.B, Register.L);
		doTest(LoadReg8ToReg8.CtoA, Register.C, Register.A);
		doTest(LoadReg8ToReg8.CtoB, Register.C, Register.B);
		doTest(LoadReg8ToReg8.CtoC, Register.C, Register.C);
		doTest(LoadReg8ToReg8.CtoD, Register.C, Register.D);
		doTest(LoadReg8ToReg8.CtoE, Register.C, Register.E);
		doTest(LoadReg8ToReg8.CtoH, Register.C, Register.H);
		doTest(LoadReg8ToReg8.CtoL, Register.C, Register.L);
		doTest(LoadReg8ToReg8.DtoA, Register.D, Register.A);
		doTest(LoadReg8ToReg8.DtoB, Register.D, Register.B);
		doTest(LoadReg8ToReg8.DtoC, Register.D, Register.C);
		doTest(LoadReg8ToReg8.DtoD, Register.D, Register.D);
		doTest(LoadReg8ToReg8.DtoE, Register.D, Register.E);
		doTest(LoadReg8ToReg8.DtoH, Register.D, Register.H);
		doTest(LoadReg8ToReg8.DtoL, Register.D, Register.L);
		doTest(LoadReg8ToReg8.EtoA, Register.E, Register.A);
		doTest(LoadReg8ToReg8.EtoB, Register.E, Register.B);
		doTest(LoadReg8ToReg8.EtoC, Register.E, Register.C);
		doTest(LoadReg8ToReg8.EtoD, Register.E, Register.D);
		doTest(LoadReg8ToReg8.EtoE, Register.E, Register.E);
		doTest(LoadReg8ToReg8.EtoH, Register.E, Register.H);
		doTest(LoadReg8ToReg8.EtoL, Register.E, Register.L);
		doTest(LoadReg8ToReg8.HtoA, Register.H, Register.A);
		doTest(LoadReg8ToReg8.HtoB, Register.H, Register.B);
		doTest(LoadReg8ToReg8.HtoC, Register.H, Register.C);
		doTest(LoadReg8ToReg8.HtoD, Register.H, Register.D);
		doTest(LoadReg8ToReg8.HtoE, Register.H, Register.E);
		doTest(LoadReg8ToReg8.HtoH, Register.H, Register.H);
		doTest(LoadReg8ToReg8.HtoL, Register.H, Register.L);
		doTest(LoadReg8ToReg8.LtoA, Register.L, Register.A);
		doTest(LoadReg8ToReg8.LtoB, Register.L, Register.B);
		doTest(LoadReg8ToReg8.LtoC, Register.L, Register.C);
		doTest(LoadReg8ToReg8.LtoD, Register.L, Register.D);
		doTest(LoadReg8ToReg8.LtoE, Register.L, Register.E);
		doTest(LoadReg8ToReg8.LtoH, Register.L, Register.H);
		doTest(LoadReg8ToReg8.LtoL, Register.L, Register.L);
	}
	
	private void doTest(IOpcode2 opcode, Register r1, Register r2) {
		int data = 20;
		processor.getRegisters().setRegister(r2, (short) data);
		
		opcode.execute(processor);
		
		Assert.assertEquals(data, this.processor.getRegisters().getRegister(r1));
	}
}
