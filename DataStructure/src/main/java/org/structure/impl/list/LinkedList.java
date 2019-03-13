package org.structure.impl.list;

import org.structure.abstracts.collection.AbstractCollection;
import org.structure.contracts.List;
import org.structure.contracts.Node;
import org.structure.factory.NodeFactory;

/**
 * This class represents an Linked list and it implements the behavior.
 * 
 * @author Anish Singh
 *
 * @param <T>
 */
public class LinkedList<T> extends AbstractCollection<T> implements List<T> {

	private Node<T> node;

	@SuppressWarnings("unchecked")
	public LinkedList() {
		node = (Node<T>) NodeFactory.getNodeFactoryInstance()
				.createNode(org.structure.contracts.NodeFactory.NodeType.SINGLY);
	}

	@Override
	public T get(T object) {
		Node<T> head = node;
		for (; head != null; head = head.getNextNode()) {
			if (object.equals(head.getData()))
				return object;
		}
		return null;
	}

	@Override
	public T get(int position) {
		if (size() < position - 1) {
			throw new IndexOutOfBoundsException("Position is greater then the limit of the linked list.");
		}
		Node<T> head = node;
		for (int counter = 0; counter < position; counter++) {
			if (counter == position - 1)
				return head.getData();
			head = head.getNextNode();
		}
		return null;
	}

	@Override
	public void remove(T object) {
		Node<T> head = node;
		Node<T> prev = null;
		for (; head != null; head = head.getNextNode()) {
			if (object.equals(head.getData())) {
				if (prev == null) {
					node = head.getNextNode();
				} else {
					prev.setNextNode(head.getNextNode());
					head.setNextNode(null);
				}
				decreamentSize();
			}
			prev = head;
		}
	}

	@Override
	public T remove(int position) {
		if (size() < position - 1) {
			throw new IndexOutOfBoundsException("Position is greater than the size of the Linked list.");
		}
		Node<T> temp = node;
		Node<T> removableNode = null;
		for (int counter = 0; counter < size(); counter++) {
			if (counter + 1 == position - 1) {
				removableNode = temp.getNextNode();
				temp.setNextNode(temp.getNextNode().getNextNode());
				decreamentSize();
			}
			temp = temp.getNextNode();
		}
		return removableNode.getData();
	}

	@Override
	protected void clearData() {
		Node<T> temp = null;
		for (int counter = 0; counter < size(); counter++) {
			temp = node.getNextNode();
			node.cleanUp();
			node = temp;
		}
		node = null;
		resetSize();
	}

	@Override
	public void add(T data) {
		if (size() == 0) {
			node.setData(data);
		} else {
			Node<T> temp = node;
			for (int counter = 0; counter < size() - 1; counter++) {
				temp = temp.getNextNode();
			}

			temp.setNextData(data);
		}
		increamentSize();
	}

	@Override
	public void add(T data, int position) {

		if (position - 1 > size()) {
			throw new IndexOutOfBoundsException("Size of the position is more than the structure size.");
		}
		if (position == 1) {
			node.setNextData(data);
			node.getNextNode().setNextNode(node);
			Node<T> nextNode = node.getNextNode();
			node.setNextNode(null);
			node = nextNode;
			increamentSize();
			return;
		}
		Node<T> temp = node;
		for (int counter = 0; counter < position - 2; counter++) {
			temp = temp.getNextNode();
		}
		Node<T> nextNode = temp.getNextNode();
		temp.setNextData(data);
		temp.getNextNode().setNextNode(nextNode);
		increamentSize();
	}

}
