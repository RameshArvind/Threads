package org.threads.pool;

import java.util.Queue;

public class PoolThread extends Thread {
	Queue<Runnable> taskQueue;
	public void setPool(Queue poolThreads)
	{
		this.taskQueue=poolThreads;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		synchronized (taskQueue) {
			while (true) {
				while(taskQueue.isEmpty()){
				try {
					System.out.println("No tasks available");
					taskQueue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				Runnable task = taskQueue.remove();
				taskQueue.notify();
				task.run();
			}
		}
	}

}
