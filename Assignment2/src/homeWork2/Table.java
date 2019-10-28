 package homeWork2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class implements a binary search tree of key/value pairs of strings *
 */
public class Table {
	/** Root node in the tree */
	private Node root;
	int count = 0;

	/**
	 * Inserts a new Node into the table. If the provided key already exists, no
	 * entry will be created. Otherwise, the new entry is added to the table. Serves
	 * as a wrapper for insertNode()
	 * 
	 * @param key
	 * @param value
	 * @return True if the new node was inserted successfully. False if the provided
	 *         key already exists in the table.
	 */
	public boolean insert(String key, String value) {
		if (this.lookUp(key) == null) {
			Node newNode = new Node(key, value); 
			root = this.insertNode(root, newNode);
			return true;
		}
		return false;
	}

	/**
	 * Inserts a new node into a binary search tree. If the new node key is not
	 * unique, the new node will not be added.
	 * 
	 * @param parent  Root node of the tree
	 * @param newNode Node to add
	 * @return Root node of the altered tree
	 */
	private Node insertNode(Node parent, Node newNode) {
		/* If the tree is empty, return a new node */
		if (parent == null) {
			parent = newNode;
			return parent;
		}

		/* Otherwise, recur down the tree */
		if (parent.compareTo(newNode) > 0) {
			Node l = insertNode(parent.getLeft(), newNode);
			parent.setLeft(l);
		} else if (parent.compareTo(newNode) < 0) {
			Node r = insertNode(parent.getRight(), newNode);
			parent.setRight(r);

		}
		/* return the (unchanged) node pointer */
		return parent;
	}

	/**
	 * Looks up the table entry with the provided key.
	 * 
	 * @param key
	 * @return The value of the entry with the provided key. Null if no entry with
	 *         the key can be found.
	 */
	public String lookUp(String key) {
		Node node = this.lookUpNode(root, key);
		if (node == null)
			return null;
		else
			return node.getValue();
	}

	/**
	 * Looks up the node in the binary search tree.
	 * 
	 * @param parent Root node of the tree
	 * @param key    Key of the node to search for
	 * @return The Node with the provided key. Null if no entry with the key can be
	 *         found.
	 */
	private Node lookUpNode(Node parent, String key) {
		// Base Cases: root is null or key is present at root
		if (parent == null || parent.getKey().equals(key))
			return parent;

		// val is greater than root's key
		if (parent.getKey().compareTo(key) > 0)
			return lookUpNode(parent.getLeft(), key);

		// val is less than root's key
		return lookUpNode(parent.getRight(), key);
	}

	/**
	 * Deletes the table entry with the given key.
	 * 
	 * @param key
	 * @return True if the entry was successfully deleted. False if no entry with
	 *         the given key was found.
	 */
	public boolean delete(String key) {
		Node node = this.lookUpNode(root, key);
		if (node == null)
			return false;
		root = deleteNode(root, key);
		return true;
	}

	/**
	 * Deletes the node with the provided key from the given tree
	 * 
	 * @param parent The root of the tree containing the node to delete
	 * @param key    The key of the node to delete
	 * @return The root node of the altered tree.
	 */
	private Node deleteNode(Node parent, String key) {
		/* Base Case: If the tree is empty */
		if (parent == null)
			return parent;

		/* Otherwise, recur down the tree */

		if (key.compareTo(parent.getKey()) < 0) {
			Node left = deleteNode(parent.getLeft(), key);
			parent.setLeft(left);
		} else if (key.compareTo(parent.getKey()) > 0) {
			Node right = deleteNode(parent.getRight(), key);
			parent.setRight(right);
		}

		// if key is same as parent's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (parent.getLeft() == null)
				return parent.getRight();
			else if (parent.getRight() == null)
				return parent.getLeft();

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			String key1 = findSmallestNode(parent.getRight()).getKey();
			String value1 = findSmallestNode(parent.getRight()).getValue();
			parent.setKey(key1);
			parent.setValue(value1);

			// Delete the inorder successor
			Node right = deleteNode(parent.getRight(), key1);
			
			parent.setRight(right);
		}

		return parent;
	}


	/**
	 * Finds the smallest node of the provided tree
	 * 
	 * @param parent The root of the tree
	 * @return The smallest node in the provided tree
	 */
	private Node findSmallestNode(Node parent) {
		Node maxv = parent;
		while (parent.getLeft() != null) {
			maxv = parent.getLeft();
			parent = parent.getLeft();
		}
		return maxv;
	}

	/**
	 * Saves the table to a text file
	 * 
	 * @param filename Name of the file to contain the table
	 * @throws IOException 
	 */
	public void save(String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		writeNode(fw, root);
		fw.close();
	}

	/**
	 * Writes a tree to a file using pre-order traversal (parent, left, right)
	 * 
	 * @param writer Writer to the file
	 * @param node   Root node of the tree to write
	 * @throws IOException
	 */
	private void writeNode(FileWriter fw, Node node) throws IOException {
		if (node != null) {
			writeNode(fw, node.getLeft());
			fw.write(node.getKey());
			fw.write("\r\n");
			fw.write(node.getValue());
			fw.write("\r\n");
			fw.write("");
			fw.write("\r\n");
			writeNode(fw, node.getRight());
		}
	}

	/**
	 * Displays all nodes in the table.
	 * 
	 * @return The number of nodes in the table.
	 */
	public int displayAll() {
		count =0;
		return displayNode(root);
	}

	/**
	 * Displays all nodes in a (sub)tree using in-order traversal (left, parent,
	 * right)
	 * 
	 * @param node The root node of the tree to display
	 * @return The number of nodes in the tree
	 */
	private int displayNode(Node node) {
		if (node != null) {
			displayNode(node.getLeft());
			System.out.println(node.getKey() + " " + node.getValue());
			count++;
			displayNode(node.getRight());
		}

		return count;
	}

	public void update(String key, String value) {
		Node node = this.lookUpNode(root, key);
		if (node != null)
			node.setValue(value);
	}
}