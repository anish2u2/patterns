package org.structure.contracts;

/**
 * 
 * This interface allows method for creating node and node factory.
 * 
 * @author Anish Singh
 *
 */
public interface NodeFactory<T extends Object > {

	/**
	 * This enum will represent type of Node.
	 * 
	 * @author Anish Singh
	 *
	 */
	enum NodeType {
		SINGLY, DOUBLY
	}

	/**
	 * This method will return node for a particular type.
	 * 
	 * @param nodeType
	 * @return
	 */
	public Node<T> createNode(NodeType nodeType);

}
