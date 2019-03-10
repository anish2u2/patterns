package org.pattern.design.contracts.decorator;

/**
 * This interface allows method to retrieve information about the Components.
 * 
 * @author Anish Singh
 *
 */
public interface Component<T> {

	/**
	 * retrieve information.
	 * 
	 * @return
	 */
	public T get();

}
