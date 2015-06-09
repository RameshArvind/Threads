package org.threads.pool;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPool implements ThreadPoolInterface{
	private Runnable task = new Thread();
	private int freeThreads;
	private int inUseThreads;
	private Queue<Runnable> taskQueue;
	private int size;
	@Override
	public void runTask(Runnable newTask) {
		// TODO Auto-generated method stub
		taskQueue.add(newTask);
		synchronized (taskQueue) {
//			while (true) {
				while (taskQueue.size()==size) {
					try {
						System.out.println("Queue is Full Currently");
						taskQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
//				System.out.println("Added Task");
				System.out.println("Passing Task   "+newTask);
				taskQueue.notify();
//			}

		}

	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		this.size=size;
	}

	@Override
	public void start() {
		freeThreads = size;
		inUseThreads = 0;
		taskQueue = new LinkedList<Runnable>();
		PoolThread t1;
		for(int i=0;i<size;i++)
		{
			t1 = new PoolThread();
			t1.setPool(taskQueue);
			t1.start();
		}
		// TODO Auto-generated method stub
	}

}
