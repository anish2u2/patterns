package org.structure.contracts;

/**
 * This interface will allow methods for removing the data from underlying
 * structure.
 * 
 * @author Anish Singh
 *
 */
public interface Removal<T> {

	/**
	 * This method will remove object from the underlying
	 * 
	 * @param object
	 */
	public void remove(T object);

	/**
	 * This method will remove all the objects of underlying structure.
	 */
	public void removeAll();

	/**
	 * This method will remove the object from underlying position and returns the
	 * object.
	 * 
	 * @param position
	 * @return
	 */
	public T remove(int position);

}
