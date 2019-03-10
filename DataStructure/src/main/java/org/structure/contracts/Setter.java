package org.structure.contracts;

/**
 * 
 * This interface allows method for adding data into structure.
 * 
 * @author Anish Singh
 *
 */
public interface Setter<T> {

	/**
	 * This method will add data.
	 * 
	 * @param data
	 */
	public void add(T data);

	/**
	 * This method will add data to specific position.
	 * 
	 * @param data
	 * @param position
	 */
	public void add(T data, int position);

}
