package org.threads.pool;

public class ThreadPoolMain{

	public static void main(String[] args) {
		ThreadPool p = new ThreadPool();
		p.setSize(2);
		p.start();
		for(int i =0; i<2;i++)
			p.runTask(new SimpleThread(i));
		// TODO Auto-generated method stub

	}


}
