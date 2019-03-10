package org.structure.abstracts.collection;

import org.structure.contracts.Collection;

public abstract class AbstractCollection<T> implements Collection<T> {

	private int size;

	@Override
	public int size() {

		return size;
	}

	/**
	 * This method will increase the size of the structure by 1.
	 */
	protected void increamentSize() {
		size++;
	}

	/**
	 * This method will decrease the size of the structure by 1;
	 */
	protected void decreamentSize() {
		size--;
	}

	@Override
	public void removeAll() {
		clearData();
	}

	/**
	 * Removes all the data .
	 */
	protected abstract void clearData();

}
