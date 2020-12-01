package paralelo;

public class BufferSincronizado implements IBuffer{

	private int buffer;
	
	private boolean cheio;
	
	@Override
	public synchronized void escrever(int valor) throws InterruptedException {
		
		while(cheio) {
			System.out.println("Buffer cheio.");
			wait();
		}
		
		this.buffer = valor;

		cheio = true;
	
		notify();
	}

	@Override
	public synchronized int ler() throws InterruptedException {
		int b;
		
		while(!cheio) {
			System.out.println("Buffer vazio.");
			wait();
		}
		
		b = this.buffer;
		
		cheio = false;
		
		notify();
		
		return b;
	}
}

