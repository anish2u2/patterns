package org.structure.contracts;

/**
 * This interface allows method for Iterating over Structure.
 * 
 * @author Anish Singh
 *
 * @param <T>
 */
public interface Iterator<T> extends PreIterator<T>, NextIterator<T> {

	/**
	 * This method will return Iterator object for the passed Structure.
	 * 
	 * @param structure
	 * @return
	 */
	public Iterator<T> getIterator(Collection<T> structure);

}
