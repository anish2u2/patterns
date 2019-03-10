package org.structure.factory;

import java.util.logging.Logger;

import org.structure.abstracts.list.node.SingleLinkedNode;
import org.structure.contracts.Node;

/**
 * This class will be used to create nodes for different types.
 * 
 * @author Anish Singh
 *
 */
public class NodeFactory<T> implements org.structure.contracts.NodeFactory<T> {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	private static org.structure.contracts.NodeFactory<Object> nodeFactory;

	@Override
	public Node<T> createNode(NodeType nodeType) {
		logger.info("CHoosing type of node:" + nodeType);
		if (NodeType.SINGLY.equals(nodeType)) {
			return new SingleLinkedNode<T>();
		} else if (NodeType.DOUBLY.equals(nodeType)) {
			//
		}
		return null;
	}

	private NodeFactory() {
		logger.info("Creating node factory.");
	}

	/**
	 * This method will return factory instance to create node.
	 * 
	 * @return
	 */
	public static org.structure.contracts.NodeFactory<Object> getNodeFactoryInstance() {
		if (nodeFactory == null) {
			nodeFactory = new NodeFactory<Object>();
		}
		return nodeFactory;
	}

}
