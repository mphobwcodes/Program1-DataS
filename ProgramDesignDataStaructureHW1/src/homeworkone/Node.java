package homeworkone;

public class Node {
	//Node Key
	private String key;
	
	//Node Value
	private String value;
	
	//Next Node in the List
	public Node next;
	
	public Node mark;
	
	//previous Node in the list
	private Node prev;
	
	//Creates a new Node
	public Node(String k, String v) {
		key =k;
		value =v;
		prev =null;
		next =null;
	}
	//@return the Node Key;
	public String getKey() {
		return key;
	}
	
	//Set the Node Key
	public void setKey(String key) {
		
	}
	
	//@return The next Node in the List
	public void setNext(Node next) {
		
	}
	
	//@retrun the Node Value
	public String getValue(String value){
		return value;
	}
	//Set the Node Value
	public void setVaue(Node next) {
		
	}
	@Override
	public String toString() {
		return "(" + key + "," + value + ")";
	}

}
