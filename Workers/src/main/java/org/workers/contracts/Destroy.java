package org.workers.contracts;

/**
 * This interface will allow method to destroy object.
 * 
 * @author Anish Singh
 *
 */
public interface Destroy {

	/**
	 * This method will be invoke the destroy the object and the object should
	 * release all the resources holding.
	 */
	public void destroy();

}
