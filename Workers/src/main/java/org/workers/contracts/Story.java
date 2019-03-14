package org.workers.contracts;

/**
 * This interface is a representation of a story having multiple task which will
 * be going to divide among multiple workers.
 * 
 * @author Anish Singh
 *
 */
public interface Story {

	/**
	 * This will represents the story id.
	 * 
	 * @return
	 */
	public Long getStoryId();

	/**
	 * This method will return story name.
	 * 
	 * @return
	 */
	public String getStoryName();

	/**
	 * This method will return a task object and if there is any dependency between
	 * the task then the implementation should be taking care and the asking thread
	 * wait for getting the next dependent task.
	 * 
	 * @return
	 */
	public Task getTask();

	/**
	 * This method will return the progress report on the story range between 1-10;
	 * 
	 * @return
	 */
	public int progressReport();

	/**
	 * This method will closes the story that means the story is finished or stopped
	 * forcefully.
	 */
	public void closeStory();

	/**
	 * This method will return priority of the story in between 1-10.
	 * 
	 * @return
	 */
	public int getPriority();

}
