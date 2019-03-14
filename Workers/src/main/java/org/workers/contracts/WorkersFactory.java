package org.workers.contracts;

import org.workers.worker.WorkersGroup;

/**
 * This interface allows method to hire workers.
 * 
 * @author Anish Singh
 *
 */
public interface WorkersFactory {

	/**
	 * This method will assign the task to a worker from pool if available or will
	 * hire a new worker and assign that worker to the group.
	 * 
	 * @param task
	 * @param workersGroup
	 * @return
	 */
	public Worker getWorker(Task task, WorkersGroup workersGroup);

	/**
	 * This method will retire the worker from pool.
	 * 
	 * @param worker
	 */
	public void retireWorker(Worker worker);

}
