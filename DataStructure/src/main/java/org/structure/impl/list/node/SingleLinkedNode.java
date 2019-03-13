package org.structure.impl.list.node;

import org.structure.contracts.Node;

/**
 * This class represents the Single linked list representation for storing data.
 * 
 * @author Anish Singh
 *
 * @param <T>
 */
public class SingleLinkedNode<T> implements Node<T> {

	private T data;

	private Node<T> nextNode;

	public SingleLinkedNode() {

	}

	public SingleLinkedNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(SingleLinkedNode<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public void setNextData(T data) {
		this.setNextNode(new SingleLinkedNode<T>(data));
	}

	@Override
	public Node<T> getPrevNode() {
		return null;
	}

	@Override
	public void setNextNode(Node<T> node) {
		this.nextNode = node;
	}

	@Override
	public void cleanUp() {
		this.data = null;
		this.nextNode = null;

	}

}
