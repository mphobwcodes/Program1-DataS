package linkedlistone;
public class Table {
	
	/** Current node */
	private Node mark;
	
	/** First node in the list */
	private Node first;
	
	public boolean insert(String key, String value) {
		
	    if (first == null) {
	    	first =new Node(null, null);
	    }
	    if(lookUp(key)!=null)
	    	return false;
	   //create a new node and insert
	    Node curr = new Node(key, value);
	    
	    //insert into a node by putting into curr.next
	    curr.setNext(first.getNext());
	    first.setNext(curr);
	    return true;
	}
	public String lookUp(String key) {
		//setting a new node
		Node abb= first;
		while( abb != null)
		{
			if (key.equals(abb.getKey()) ) {
				return abb.getValue();
			}
			abb = abb.getNext();
			
		}
		return null;
	}
	public boolean delete(String key) {
		Node abb= first;
		//To check if key will be in the list
		while( abb != null && abb.getNext()!=null)
		{
			if (key.equals(abb.getNext().getKey())) {
				abb.setNext(null);
				return true;
			}

			abb = abb.getNext();
		}
		return false;
	}
	public boolean update(String key, String newValue) {
		Node abb= first;
		while( abb != null)
		{
			if (key.equals(abb.getKey())) {
				abb.setValue(newValue);
				return true;
			}

			abb = abb.getNext();
		}
		return false;
	}
	public boolean markToStart() {
		if (first == null) {
			return false;
		}
		mark =first.getNext();
		return true;
	}
	public boolean advanceMark() {
		if (mark.getNext() ==null) {
			return false;
		}
		mark.setNext(mark.getNext());
		return true;
	}
	public String keyAtMark() {
		if (mark ==null) {
			return null;
		}
		return mark.getKey();
	}
	public String valueAtMark() {
		if (mark ==null) {
			return null;
		}
		return mark.getValue();
	}
	public int displayAll() {
		if(first==null)
			return 0;
		Node abb= first.getNext();
		int N;
		N=0;
		while( abb != null)
		{
			System.out.println(abb.toString());
			N++;
			abb = abb.getNext();
			
		}
		return N;
		
	}
	

}
