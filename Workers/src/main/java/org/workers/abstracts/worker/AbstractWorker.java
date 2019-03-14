package org.workers.abstracts.worker;

import org.workers.contracts.Task;
import org.workers.contracts.Worker;
import org.workers.worker.WorkersGroup;

public abstract class AbstractWorker implements Worker {

	private Task task;

	private WorkersGroup group;

	@Override
	public void assignTask(Task task) {
		this.task = task;
	}

	@Override
	public void releaseWorker() {
		task = null;
	}

	/**
	 * This method will return the task.
	 * 
	 * @return
	 */
	protected Task getTask() {
		return task;
	}

	@Override
	public void assignGroup(WorkersGroup group) {
		this.group = group;
	}

	protected WorkersGroup getWorkersGroup() {
		return group;
	}

	protected void releaseResources() {
		task = null;
		group = null;
	}

}
