package org.workers.abstracts.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.workers.contracts.Manager;
import org.workers.contracts.Story;
import org.workers.contracts.WorkersFactory;
import org.workers.worker.WorkersGroup;

public abstract class AbstractManager implements Manager {

	private final Queue<WorkersGroup> processingWork = new LinkedList<WorkersGroup>();

	private List<Story> storyRequests = new ArrayList<Story>(5);

	private WorkersFactory workersFactory;

	private Comparator<Story> comparator;

	@Override
	public void inti() {

	}

	@Override
	public void destroy() {
		processingWork.clear();
		storyRequests.clear();
		workersFactory = null;
	}

	/**
	 * This method will return the WorkersGroup active processing.
	 * 
	 * @param story
	 * @return
	 */
	protected WorkersGroup getWorkersGroup(Story story) {
		for (WorkersGroup group : processingWork) {
			if (group.getName().equals(story.getStoryName())) {
				return group;
			}
		}
		return null;
	}

	protected void unscheduleStory(Story story) {
		this.storyRequests.remove(story);
	}

	/**
	 * This method will initiate the scheduler.
	 */
	protected abstract void initiateScheduler();

	@Override
	public void setWorkersFactory(WorkersFactory factory) {
		this.workersFactory = factory;
	}

	protected WorkersFactory getWorkersFactory() {
		return this.workersFactory;
	}

	protected Queue<WorkersGroup> getWorkersQueue() {
		return this.processingWork;
	}

	protected void addToStoryRequests(Story story) {
		this.storyRequests.add(story);
	}

	protected void sortStoryRequest() {
		Collections.sort(storyRequests, this.comparator);
	}

	public void setSortingMechanism(Comparator<Story> comparator) {
		this.comparator = comparator;
	}

	protected Story getReadyStory() {
		return storyRequests.size() > 0 ? storyRequests.remove(0) : null;
	}
}
