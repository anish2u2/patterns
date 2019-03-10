package org.structure.contracts;

/**
 * This interface allows method for accessing data from collection.
 * 
 * @author Anish Singh
 *
 */
public interface Accessor<T extends Object> {

	/**
	 * This method will find the object passed as parameter from the structure and
	 * will return .
	 * 
	 * @return
	 */
	public T get(T object);

	/**
	 * This method will will fetch the position element and return the element.
	 * 
	 * @param position
	 * @return
	 */
	public T get(int position);

}
