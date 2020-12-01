package paralelo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedPrincipalTeste {
	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		IBuffer shared = new BufferCircular();
		
		Produtor p1 = new Produtor(shared);
		Produtor p2 = new Produtor(shared);

		Consumidor c1 = new Consumidor(shared);
		Consumidor c2 = new Consumidor(shared);

		pool.execute(p1);
		pool.execute(p2);

		pool.execute(c1);
		pool.execute(c2);

		pool.shutdown();
	}
}
