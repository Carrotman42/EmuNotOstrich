package gameBoy.tests.opcodeTests;

import static org.junit.Assert.assertEquals;
import gameBoy.cpu.Flag;
import gameBoy.cpu.GameBoyProcessor;
import gameBoy.cpu.Register;
import gameBoy.cpu.opcodes.or.Or;
import gameBoy.interfaces.IOpcode2;
import gameBoy.interfaces.IProcessor;

import org.junit.Before;
import org.junit.Test;

public class OrTests {
	private IProcessor processor;
	
	@Before
	public void setUp() {
		this.processor = new GameBoyProcessor();
	}
	
   @Test
    public void testOrA() {
        // TODO: This one
        //doOrTest( Or.OrA, Register.A );
    }
    
	
	@Test
	public void testOrB() {
		doOrTest( Or.B, Register.B );
	}
	
	@Test
	public void testOrC() {
		doOrTest( Or.C, Register.C );
	}
	
	@Test
	public void testOrD() {
        doOrTest( Or.D, Register.D );
	}
	
	@Test
	public void testOrE() {
        doOrTest( Or.E, Register.E );
	}
	
	@Test
	public void testOrH() {
        doOrTest( Or.H, Register.H );
	}
	
	@Test
	public void testOrL() {
        doOrTest( Or.L, Register.L );
	}
	
	@Test
	public void testOrAddrHl() {
		this.processor.getMemory().set8BitValue( 0x08, 0x08 );
		this.processor.getMemory().set8BitValue( 0x0, 0x0 );
		
		doOrTest( Or.AddrHL, Register.HL );
	}
	
	@Test
	public void testOrImmToA() {
		IOpcode2 or = Or.ImmToA;
		
		this.processor.getRegisters().setRegister( Register.PC, 0x5 );
		this.processor.getMemory().set8BitValue( 0x6, 0x8 );
		this.processor.getRegisters().setRegister( Register.A, 0xF0 );
		
		or.execute(this.processor);
		
		assertEquals( 0xF8, this.processor.getRegisters().getRegister( Register.A ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.Z ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.N ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.H ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.C ) );
		
		this.processor.getRegisters().setRegister( Register.PC, 0xACDB );
		this.processor.getMemory().set8BitValue( 0xACDC, 0x0 );
		this.processor.getRegisters().setRegister( Register.A, 0x0 );
		
		or.execute(this.processor);
		
		assertEquals( 0x0, this.processor.getRegisters().getRegister( Register.A ) );
		assertEquals( 1, this.processor.getRegisters().getFlag( Flag.Z ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.N ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.H ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.C ) );
	}
	
	private void doOrTest( IOpcode2 or, Register register ) {
		this.processor.getRegisters().setRegister( register, 0x08 );
		this.processor.getRegisters().setRegister( Register.A, 0xF0 );
		
		or.execute(this.processor);
		
		assertEquals( 0xF8, this.processor.getRegisters().getRegister( Register.A ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.Z ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.N ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.H ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.C ) );
		
		this.processor.getRegisters().setRegister( register, 0x0 );
		this.processor.getRegisters().setRegister( Register.A, 0x0 );
		
		or.execute(this.processor);
		
		assertEquals( 0x0, this.processor.getRegisters().getRegister( Register.A ) );
		assertEquals( 1, this.processor.getRegisters().getFlag( Flag.Z ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.N ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.H ) );
		assertEquals( 0, this.processor.getRegisters().getFlag( Flag.C ) );
	}
}
