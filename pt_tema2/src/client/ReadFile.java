package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;



public class ReadFile {
	public static ArrayList<Client> clients = new ArrayList<Client>();
	public static int nrQueues;
	public static int maxSimulationTime;
	public static int nrClienti;
	public static int ind=-1;
	public ReadFile() {

	}

	public static void readFile() {
		ArrayList<String> lista = new ArrayList<String>();
		try {
			File myObj = new File("f1");
			Scanner myScanner = new Scanner(myObj);
			while (myScanner.hasNextLine()) {
				String data = myScanner.nextLine();
				lista.add(data);
			}
			myScanner.close();
			Random rand = new Random();
			nrClienti = Integer.parseInt(lista.get(0));
			nrQueues = Integer.parseInt(lista.get(1));
			maxSimulationTime = Integer.parseInt(lista.get(2));
			String[] s1 = lista.get(3).split(",", 2);
			int minArrivalTime = Integer.parseInt(s1[0]);
			int maxArrivalTime = Integer.parseInt(s1[1]);
			String[] s2 = lista.get(4).split(",", 2);
			int minServiceTime = Integer.parseInt(s2[0]);
			int maxServiceTime = Integer.parseInt(s2[1]);
			for (int i = 0; i < nrClienti; i++) {
				int index = i + 1;
				int arrivalTime = minArrivalTime + rand.nextInt(maxArrivalTime - minArrivalTime + 1);
				int serviceTime = minServiceTime + rand.nextInt(maxServiceTime - minServiceTime + 1);
				Client client = new Client(index, arrivalTime, serviceTime);
				clients.add(client);
			}
			Collections.sort(clients, Client.ComparatorClient);
		} catch (FileNotFoundException e) {
			System.out.println("Error!");
		}
	}
	
	public static Client getClient() {
		
		ind++;
		return clients.get(ind);
		
	}
	
	public static int getSim() {
		
		return maxSimulationTime;
	}
}