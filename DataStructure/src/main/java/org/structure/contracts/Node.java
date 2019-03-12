package org.structure.contracts;

/**
 * This interface represents a node and will introduces method for accessing
 * data.
 * 
 * @author Anish Singh
 *
 */
public interface Node<T> {

	public T getData();

	public void setData(T data);

	public void setNextData(T data);

	public void setNextNode(Node<T> node);

	public Node<T> getNextNode();

	public Node<T> getPrevNode();
	
	public void cleanUp();

}
