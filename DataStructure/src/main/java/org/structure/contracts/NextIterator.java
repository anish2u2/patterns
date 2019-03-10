package org.structure.contracts;

/**
 * This interface will allow methods for accessing next object.
 * 
 * @author Anish Singh
 *
 * @param <T>
 */
public interface NextIterator<T> {

	/**
	 * Returns the next object and point to next object.
	 * 
	 * @return
	 */
	public T next();

	/**
	 * This method will return true if the structure have next element.
	 * 
	 * @return
	 */
	public boolean hasNext();

}
