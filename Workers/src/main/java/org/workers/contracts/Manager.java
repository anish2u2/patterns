package org.workers.contracts;

import java.util.Comparator;

/**
 * This interface allows method which will control and assign workers.
 * 
 * @author Anish Singh
 *
 */
public interface Manager extends Init, Destroy {

	/**
	 * This method will set the workers factory which will be used by the manager to
	 * manage the workers.
	 * 
	 * @param factory
	 */
	public void setWorkersFactory(WorkersFactory factory);

	/**
	 * This method will assign story to worker with medium priority.
	 * 
	 * @param story
	 */
	public void assignStory(Story story);

	/**
	 * This method will stop the workers to work on story.
	 * 
	 * @param story
	 */
	public void stopWorkingOnStory(Story story);

	/**
	 * This method will assign story to workers with the given priority.
	 * 
	 * @param story
	 * @param priority
	 */
	// public void assignStory(Story story, Priority priority);

	/**
	 * This method will set the Sorting mechanism for sorting the request story.
	 * 
	 * @param comparator
	 */
	public void setSortingMechanism(Comparator<Story> comparator);

	/**
	 * This method will start scheduling the works.It should invoke once.
	 */
	public void startManging();
}
