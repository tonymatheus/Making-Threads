package paralelo;

import java.util.Random;

public class Consumidor implements Runnable {

	private IBuffer shared;

	public Consumidor(IBuffer shared) {
		this.shared = shared;
	}

	@Override
	public void run() {

		try {
			Random r = new Random();

			for (int i = 1; i <= 10; i++) {
				System.out.println("Consumidor leu o valor: " + shared.ler());

				Thread.sleep(r.nextInt(3000));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
