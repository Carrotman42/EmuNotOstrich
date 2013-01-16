package gameBoy.interfaces;

public interface IOpcode2 {
	public void execute(IProcessor proc);
	public int getCycles();
	public byte getOpcodeLength();
}
