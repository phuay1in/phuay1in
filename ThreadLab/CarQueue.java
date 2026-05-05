import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.*;

public class CarQueue {
	private LinkedList<Integer> queue;
	private Random rand;
	
	public CarQueue() {
		queue = new LinkedList();
		rand = new Random();
		
		for (int i = 0; i < 6; i++) {
			queue.add(rand.nextInt(4));
		}
		
		addToQueue();
	}
	
	public void addToQueue() {
		Runnable r = new Runnable() {
		public void run() {
			try {
				while (true) {
					queue.add(rand.nextInt(4));
					Thread.sleep(1000);
				}
			} catch(InterruptedException e) {
			}
			} 
		};
		Thread t = new Thread(r);
		t.start();
	}
	public Integer deleteQueue() {
		if (queue.isEmpty()) {
			return rand.nextInt(4);
		}
		return queue.removeFirst();
	}
}
