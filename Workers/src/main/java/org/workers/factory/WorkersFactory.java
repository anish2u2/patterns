package org.workers.factory;

import java.util.LinkedList;
import java.util.List;

import org.workers.contracts.Task;
import org.workers.contracts.Worker;
import org.workers.worker.WorkersGroup;

public class WorkersFactory implements org.workers.contracts.WorkersFactory {

	private List<Worker> workersPool = new LinkedList<Worker>();

	private static WorkersFactory factory;

	private WorkersFactory() {

	}

	public static org.workers.contracts.WorkersFactory getInstance() {
		if (factory == null) {
			factory = new WorkersFactory();
		}
		return factory;
	}

	public Worker getWorker(Task task, WorkersGroup workersGroup) {
		Worker worker = new org.workers.worker.Worker();
		worker.assignGroup(workersGroup);
		worker.assignTask(task);
		this.workersPool.add(worker);
		return worker;
	}

	public void retireWorker(Worker worker) {
		this.workersPool.remove(worker);
	}

}
