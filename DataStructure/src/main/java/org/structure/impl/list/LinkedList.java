package org.structure.impl.list;

import org.structure.abstracts.collection.AbstractCollection;
import org.structure.contracts.List;
import org.structure.contracts.Node;
import org.structure.factory.NodeFactory;

public class LinkedList<T> extends AbstractCollection<T> implements List<T> {

	private Node<T> node;

	@SuppressWarnings("unchecked")
	public LinkedList() {
		node = (Node<T>) NodeFactory.getNodeFactoryInstance()
				.createNode(org.structure.contracts.NodeFactory.NodeType.SINGLY);
	}

	@Override
	public T get(T object) {

		return null;
	}

	@Override
	public T get(int position) {

		return null;
	}

	@Override
	public void remove(T object) {

	}

	@Override
	public T remove(int position) {

		return null;
	}

	@Override
	protected void clearData() {
		
	}

	@Override
	public void add(T data) {
		if (size() == 0) {
			node.setData(data);
		} else {
			Node<T> temp = node;
			for (int counter = 0; counter < size(); counter++) {
				temp = temp.getNextNode();
			}
			temp.setNextData(data);
		}
		increamentSize();
	}

	@Override
	public void add(T data, int position) {

	}

}
