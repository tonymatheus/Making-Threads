package paralelo;

public class BufferCircular implements IBuffer {

	private int buffer [] = {0, 0, 0};
	
	private int cheio;
	
	private int e, l;
	
	@Override
	public synchronized void escrever(int valor) throws InterruptedException {
		
		while(cheio == buffer.length) {
			System.out.println("Buffer cheio");
			wait();
		}
		
		buffer[e] = valor;
		
		cheio++;
		
		e = e + 1;
		
		if(buffer.length == e) {
			e = 0;
		}
		
		notify();		
	}

	@Override
	public synchronized int ler() throws InterruptedException {
		int b;
		
		while(cheio == 0) {
			System.out.println("Buffer vazio");
			wait();
		}
		
		b = buffer[l];
		
		cheio--;
		
		l = l + 1;

		if(buffer.length == l) {
			l = 0;
		}
		
		notify();
		
		return b;
	}

}
