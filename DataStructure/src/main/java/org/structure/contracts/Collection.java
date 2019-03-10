package org.structure.contracts;

/**
 * This interface allows common methods which will be common across the
 * collection.
 * 
 * @author Anish Singh
 *
 */
public interface Collection<T> extends Accessor<T>, Removal<T>, Setter<T>{

	/**
	 * This method will return the underlying structure size.
	 * 
	 * @return
	 */
	public int size();

	/**
	 * This method will remove the all data from the data structure.
	 */
	public void removeAll();

}
