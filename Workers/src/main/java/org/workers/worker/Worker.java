package org.workers.worker;

import org.workers.abstracts.worker.AbstractWorker;

public class Worker extends AbstractWorker {

	private Thread thread;

	public Worker() {

	}

	@Override
	public void doWork() {
		thread = new Thread(getWorkersGroup(), new Runnable() {

			@Override
			public void run() {
				getTask().executeTask();
			}
		}, getTask().getTaskName());
		thread.start();
	}

	@Override
	public boolean isWorkFinished() {

		return thread == null ? true : thread.isAlive();
	}

	@Override
	public void terminateWork() {
		if (thread.isAlive()) {
			thread.interrupt();
		}
		thread = null;

	}

}
