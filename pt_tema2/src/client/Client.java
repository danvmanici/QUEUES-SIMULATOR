package client;

import java.util.Comparator;


public class Client {

	private int Id;
	private int arrivalTime;
	private int serviceTime;
	
	public Client(int Id, int arrivalTime, int serviceTime){
		this.Id=Id;
		this.arrivalTime=arrivalTime;
		this.serviceTime=serviceTime;
	}

	public int getId() {
		return Id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}
	
	public String toString() {
	
		return "("+this.Id+","+this.arrivalTime+","+this.serviceTime+")";
	}
	
	public static Comparator<Client> ComparatorClient = new Comparator<Client>() {

		public int compare(Client c1, Client c2) {

			return Integer.valueOf(c1.getArrivalTime()).compareTo(c2.getArrivalTime());
		}
	};

}