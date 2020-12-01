package paralelo;

import java.util.Random;

public class PrintTask implements Runnable {

	private String nome;

	public PrintTask(String nome) {
		this.nome = nome;
	}

	@Override
	public void run() {
		try {
			Random r = new Random();

			int time = r.nextInt(5000);

			System.out.println("Thread " + nome + "vai dormir por " + time + " milisegundos");

			Thread.sleep(time);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread " + nome + "acordou e finalizou.");
	}
}
