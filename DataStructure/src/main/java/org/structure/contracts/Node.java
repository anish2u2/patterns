package org.structure.contracts;

/**
 * This interface represents a node and will introduces method for accessing
 * data.
 * 
 * @author Anish Singh
 *
 */
public interface Node<T> {
	/**
	 * This method will return the data.
	 * 
	 * @return
	 */
	public T getData();

	/**
	 * This method will set the data for the node.
	 * 
	 * @param data
	 */
	public void setData(T data);

	/**
	 * This method will link a node to the current Node with passed data.
	 * 
	 * @param data
	 */
	public void setNextData(T data);

	/**
	 * This method will set the next node.
	 * 
	 * @param node
	 */
	public void setNextNode(Node<T> node);

	/**
	 * This method will return the next node.
	 * 
	 * @return
	 */
	public Node<T> getNextNode();

	/**
	 * This method will return the previous node if any present or else null.
	 * 
	 * @return
	 */
	public Node<T> getPrevNode();

	/**
	 * This method will cleanup all the data for the current node.
	 */
	public void cleanUp();

}
