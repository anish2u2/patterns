package org.workers.manager;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.logging.Logger;

import org.workers.abstracts.manager.AbstractManager;
import org.workers.contracts.Story;
import org.workers.contracts.Task;
import org.workers.contracts.Worker;
import org.workers.worker.WorkersGroup;

public class Manager extends AbstractManager {

	Logger logger = Logger.getLogger(this.getClass().getName());

	private static int DEFAULT_QUEUE_SIZE = 4;

	private Worker schedulerWorker;

	@Override
	public void stopWorkingOnStory(Story story) {
		WorkersGroup group = getWorkersGroup(story);
		if (group == null) {
			logger.info("Story " + story.getStoryName() + " id " + story.getStoryId()
					+ " is not yet scheduled by scheduler.");
		} else {
			unscheduleStory(story);
			logger.info(
					"Story " + story.getStoryName() + " id " + story.getStoryId() + " is unscheduled from request.");
		}
	}

	public void initiateScheduler() {
		schedulerWorker = getWorkersFactory().getWorker(new Task() {
			Logger logger = Logger.getLogger("Work-watcher-thread");

			@Override
			public String getTaskName() {

				return "Scheduler";
			}

			@Override
			public void executeTask() {
				try {
					while (true) {
						// logger.info("Scheduling works.");
						schedule();
						// logger.info("Works has been scheduled.");
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, new WorkersGroup(this.getClass().getName()));
		schedulerWorker.doWork();
	}

	@Override
	public void assignStory(Story story) {
		logger.info("Assigning story " + story.getStoryName());
		addToStoryRequests(story);
		sortStoryRequest();
	}

	/**
	 * This method will schedule the story.
	 */
	public void schedule() {
		removeFinishWork();
		if (getWorkersQueue().size() < DEFAULT_QUEUE_SIZE) {
			Story story = getReadyStory();
			if (story == null)
				return;
			// logger.info("Scheduling..");
			WorkersGroup group = new WorkersGroup(story.getStoryName());
			Worker worker = getWorkersFactory().getWorker(story.getTask(), group);
			getWorkersQueue().add(group);
			worker.doWork();
		}
	}

	/**
	 * This method will try to find finished work workers and remove from the queue.
	 */
	public void removeFinishWork() {
		ListIterator<WorkersGroup> groups = ((LinkedList<WorkersGroup>) getWorkersQueue()).listIterator();
		while (groups.hasNext()) {
			WorkersGroup group = groups.next();
			if (group.activeCount() < 1) {
				logger.info("Removing workers group " + group.getName());
				groups.remove();
			}
		}
	}

	@Override
	public void destroy() {
		schedulerWorker.terminateWork();
		schedulerWorker = null;
		super.destroy();
	}

	@Override
	protected void finalize() throws Throwable {
		schedulerWorker.terminateWork();
		schedulerWorker = null;
		super.finalize();
	}

	@Override
	public void startManging() {
		initiateScheduler();

	}

}
