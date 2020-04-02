package Main;

import tema2.Simulate;

public class Main {

	public static void main(String[] args) {
		

		Simulate simulate = new Simulate();
		Thread thread = new Thread(simulate);
		thread.start();
		
	}

}
