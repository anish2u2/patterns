package org.workers.contracts;

/**
 * This interface represents a small unit of work.
 * 
 * @author Anish Singh
 *
 */

public interface Task {

	/**
	 * This method represents the execution of task.
	 */
	public void executeTask();

	/**
	 * This method will return story id associated with the task.
	 * 
	 * @return
	 */
	//public Long getStoryId();

	/**
	 * This method will return the name of the task.
	 * 
	 * @return
	 */
	public String getTaskName();

}
