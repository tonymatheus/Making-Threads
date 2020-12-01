package paralelo;

public class BufferNaoSincronizado implements IBuffer{

	private int buffer;
	
	@Override
	public void escrever(int valor) {
		this.buffer = valor;
	}

	@Override
	public int ler() {
		return this.buffer;
	}
}
