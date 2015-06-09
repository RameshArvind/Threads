package org.threads.pool;

public class SimpleThread extends Thread {
private int i;
	public SimpleThread(int i) {
	super();
	this.i = i;
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"  "+i+" is executing.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
