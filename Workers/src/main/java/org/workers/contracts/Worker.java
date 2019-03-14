package org.workers.contracts;

import org.workers.worker.WorkersGroup;

/**
 * This interface represents a worker.
 * 
 * @author Anish Singh
 *
 */
public interface Worker {

	/**
	 * This method will assign task to worker.
	 * 
	 * @param task
	 */
	public void assignTask(Task task);

	/**
	 * This method will execute the task .
	 */
	public void doWork();

	/**
	 * This method will return the status that work is finished or not.
	 * 
	 * @return
	 */
	public boolean isWorkFinished();

	/**
	 * This method will forcefully terminate the worker.
	 */
	public void terminateWork();

	/**
	 * THis method will release/retire the worker.
	 */
	public void releaseWorker();

	/**
	 * This method will assign a worker group.
	 * 
	 * @param group
	 */
	public void assignGroup(WorkersGroup group);
}
