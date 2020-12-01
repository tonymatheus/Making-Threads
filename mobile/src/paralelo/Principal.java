package paralelo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {
	
	public static void main(String[] args) {
	
		System.out.println("Thread principal começou...");
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		PrintTask p1 = new PrintTask("1");
		PrintTask p2 = new PrintTask("2");
		PrintTask p3 = new PrintTask("3");
		
		pool.execute(p1);
		pool.execute(p2);
		pool.execute(p3);
		
		pool.shutdown();
		
		System.out.println("Thread principal terminou...");
	}
}
