package org.pattern.design.contracts.decorator;

/**
 * This interface introduces method for decorator.
 * 
 * Decorator pattern follows rule open extension but close modification. i.e try
 * to focus on more composition the behavior instead of using
 * inheritance.Decorate objects and wrap if needed to add specific behavior.
 * 
 * @author Anish Singh
 *
 */
public interface Decorator<T> {

	/**
	 * This method will add decorator to existing decorator.
	 * 
	 * @param component
	 */
	public void add(Decorator<T> component);

	/**
	 * This method will return the value.
	 * 
	 * @return
	 */
	public T get();

}
