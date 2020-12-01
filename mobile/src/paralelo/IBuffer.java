package paralelo;

public interface IBuffer {

	public void escrever (int valor) throws InterruptedException;
	
	public int ler() throws InterruptedException;	
}
