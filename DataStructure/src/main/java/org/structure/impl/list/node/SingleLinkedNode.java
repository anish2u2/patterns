package org.structure.impl.list.node;

import org.structure.contracts.Node;

public class SingleLinkedNode<T> implements Node<T> {

	private T data;

	private SingleLinkedNode<T> nextNode;

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

	public SingleLinkedNode<T> getNextNode() {
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

}
