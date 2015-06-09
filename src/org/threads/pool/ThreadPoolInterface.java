package org.threads.pool;

public interface ThreadPoolInterface {
	public void runTask(Runnable task);
	public void setSize(int size);
	public void start();
}
