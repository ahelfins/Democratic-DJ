import java.util.Iterator;

public class MyIterator<E> implements Iterator<E> {

	private ResizableArray<E> ar;
	private int position;
	
	public MyIterator(ResizableArray<E> values){
		ar=values;
		position=0;
	}
	
	public boolean hasNext(){
		if(position<ar.size())
			return true;
		else
			return false;
	}
	public E next(){
		E val=ar.get(position);
		position++;
		return val;
	}
	
	public void remove(){
		ar.remove(position);
	}
}
