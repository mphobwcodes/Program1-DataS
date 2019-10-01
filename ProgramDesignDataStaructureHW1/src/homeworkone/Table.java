package homeworkone;

/**This class implements a linked list of key/value pairs of strings**/

public class Table {

	//Current Node
	private Node mark;
	
	private Node first;   //refers to first node in list
	private Node last;    //referes to last node in list

	
	
	public Table()    //constructor
		//Initially we have no items on the list
		{
			first =null;  
			last = null;  
		}
		 
	
	public boolean insert(String key, String value) {
		
		Node current =first; //strat at beginning
		while(current.mark ! = key) //until match is found
		{
		current= current.next;   //ove to next Node
		if (current ==null)
			return false;    //didnt find it
		}
		Node newNode = new Node(value)  //make new node
			
			if(current ==last) //if last Node,
			{
				newNode.next =null;
				current.next = newNode;
				return true;    //found it, and inserted
			}
	}

	public String lookUp(String key) {
		Node mark;
		for ( mark = head; mark != null; mark = mark.next )
		 {
			if ( mark.key.equals( key ) )
				return( mark.value );
			}
		return(null);
	}

	
	public boolean update(String key, String newValue) {
		
	}
	public boolean markToStart() {
		
	}
	public boolean advanceMark() {
		
	}
	public String keyMark() {
		
	}
	public String valueAtMark() {
		
	}
	
	public int displayAll() {
		
	}
}
