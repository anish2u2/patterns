package org.structure.contracts;

/**
 * This interface will allow methods for iterating previous.
 * 
 * @author Anish Singh
 *
 * @param <T>
 */
public interface PreIterator<T> {

	/**
	 * This method will return true if previous element is present.
	 * 
	 * @return
	 */
	public boolean hasPrevious();

	/**
	 * This method will return previous element and point to previous element.
	 * 
	 * @return
	 */
	public T previous();

}
