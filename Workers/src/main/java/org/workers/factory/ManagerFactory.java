package org.workers.factory;

import java.util.Comparator;

import org.workers.contracts.Manager;
import org.workers.contracts.Story;

/**
 * This interface allows method for creating managers.
 * 
 * @author Anish Singh
 *
 */
public class ManagerFactory {

	private static Manager manager;

	private ManagerFactory() {

	}

	/**
	 * This method will return instance of the manger which will be alive all
	 * through the application scope.
	 * 
	 * @return
	 */
	public static Manager getManager() {
		if (manager == null) {
			manager = new org.workers.manager.Manager();
			manager.setWorkersFactory(WorkersFactory.getInstance());
			manager.setSortingMechanism(new Comparator<Story>() {

				@Override
				public int compare(Story o1, Story o2) {
					return o1.getPriority() == o2.getPriority() ? 0 : (o1.getPriority() < o2.getPriority() ? -1 : 1);
				}
			});
			manager.startManging();
		}
		return manager;
	}

}
