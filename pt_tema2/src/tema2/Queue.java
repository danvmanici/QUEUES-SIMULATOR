package tema2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import client.Client;

public class Queue implements Runnable {

	private BlockingQueue<Client> queue = new LinkedBlockingQueue<Client>();
	private int queueNr;
	
	public Queue(int queueNr){
		this.queueNr=queueNr;
	}
	
	public void fileWrite(String s){
		try(FileWriter file = new FileWriter("fout3.txt", true);
			    BufferedWriter buffer = new BufferedWriter(file);
			    PrintWriter print = new PrintWriter(buffer))
			{
			    print.println(s);

			} catch (IOException e) {
				System.out.println("Error!");
			}
	}
	
	public void addClient(Client c){
		queue.add(c);
		fileWrite("("+c.getId()+","+c.getArrivalTime()+","+c.getServiceTime()+")"+"added to queue "+queueNr);		
	}
	
	@Override
	public void run(){
		while(true){
			try{
				Client c = queue.take();
				fileWrite("Queue "+queueNr+": is processing client "+c.getId());
				Thread.sleep(c.getServiceTime()*50);
				fileWrite("Client "+c.getId()+" was processed.");
			}catch(Exception e){
				System.out.println("Error!");
			}
		}
	}
	
	
	public int getQueueSize(){
		return queue.size();
	}
	
}