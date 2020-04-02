package tema2;



import client.Client;
import client.ReadFile;

public class Simulate implements Runnable {
	
	public  int nrOfQueues;
	private int maxSimulationTime;
	Queue[] queue = new Queue[nrOfQueues];
	Thread[] thread = new Thread[(nrOfQueues+1)];
	
	public Simulate(){
		
		ReadFile.readFile();
		maxSimulationTime=ReadFile.maxSimulationTime;
		nrOfQueues=ReadFile.nrQueues;
		queue = new Queue[nrOfQueues];
		thread = new Thread[(nrOfQueues+1)];
		for(int i=0;i<nrOfQueues;i++){
			queue[i] = new Queue(i);
			thread[i] = new Thread(queue[i]);
			thread[i].start();
		}
	}
	
	public int leastPopulatedQueue(){
		float min=999;
		int index=0;
		int[] a=new int[nrOfQueues];
		for(int i=0;i<nrOfQueues;i++){
			a[i]=queue[i].getQueueSize();
		}
		for(int i=0;i<nrOfQueues;i++){
			if(min>a[i]){
				min=a[i];
				index=i;
			}
		}
		return index;
		
	}
	
	
	
	
	@Override
	public void run() {
		int currentTime = 0;
		while(currentTime<maxSimulationTime){
			Client c = ReadFile.getClient();
			queue[leastPopulatedQueue()].addClient(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Error!");
			}
			currentTime++;
		}

		System.exit(0);
	}

}
