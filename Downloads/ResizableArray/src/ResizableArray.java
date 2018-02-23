import java.util.Arrays;
import java.util.Iterator;

public class ResizableArray<A> implements Iterable<A> {
	
	public static final int START_POSSIBLE_VALS = 10;
	private A[] data;
	private int size;

	public Iterator<A> iterator() {
	       return new MyIterator<A>(this);
	}
	
	public ResizableArray(){
		data= (A[])new Object[START_POSSIBLE_VALS];
		size=0;
	}
	
	public ResizableArray(A[] values){
		data=(A[]) new Object[values.length];
		size=values.length;
		for(int i=0; i<values.length; i++)
			data[i]=values[i];
	}
	
	public ResizableArray(ResizableArray<A> other){
		data=(A[])new Object[other.size()];
		size=other.size();
		for(int i=0; i<size; i++)
			data[i]=other.get(i);
	}
	
	private void resize(){
		A[] temp=(A[])new Object[data.length*2];
		for(int i=0; i<data.length; i++)
			temp[i]=data[i];
		data=temp;
	}
	
	//first wave
	public void add(A x){
		if(data.length<=size)
			resize();
		data[size]=x;
		size++;
	}
	public A remove(int i){
		if(i>=size || i<0){
			throw new IllegalArgumentException("Bad index: " + i); 
		}
		else{
			A value=data[i];
			for(int y=i; y<size-1; y++){
				data[y]=data[y+1];
			}
			size--;
			return value;
		}
	}
	public int size(){
		return size;
	}
	public String toString(){
		String x="";
		for(int i=0; i<size; i++){
			x+=data[i]+" ";
		}
		return x;
	}
	

	//second wave
	public void insert(int i, A x){
		if(data.length<=size)
			resize();
		if(i>size || i<0){
			throw new IllegalArgumentException("Bad index: " + i); 
		}
		else{
			size++;
			for(int y=size-1; y>i; y--){
				data[y]=data[y-1];
			}
			data[i]=x;
		}
	}
	public A get(int i){
		if(i>=size || i<0){
			throw new IllegalArgumentException("Bad index: " + i); 
		}
		else{
			return data[i];
		}
	}
	public void set(int i, A x){
		if(i>size || i<0){
			throw new IllegalArgumentException("Bad index: " + i); 
		}
		else{
			data[i]=x;
		}
	}
	public void sort(){
		Arrays.sort(data, 0, size);
	}
	public int indexOf(A x){
		int ans=-1;
		for(int i=0; i<size; i++){
			if(data[i].equals(x))
				return i;
		}
		return ans;
	}
	public boolean equals(ResizableArray<A> other){
		if(size!=other.size())
			return false;
		for(int i=0; i<size; i++){
			if(!data[i].equals(other.get(i)))
				return false;
		}
		return true;
	}
	public A[] toArray(){
		A[] ans=(A[])new Object[size];
		for(int i=0; i<size; i++)
			ans[i]=data[i];
		return ans;
	}
	
	//third wave
	public void add(A[] values){
		for(int i=0; i<values.length; i++)
			add(values[i]);
	}
	public void removeAll(A x){
		for(int i=0; i<size; i++){
			if(data[i].equals(x))
				remove(i);
		}
	}
	public void replaceAll(A x, A with){
		for(int i=0; i<size; i++){
			if(data[i].equals(x))
				set(i, with);
		}
	}
	//works like substring: start is the index of the start (index included), end is the index of the end (not included)
	public ResizableArray<A> subArray(int start, int end){
		ResizableArray<A> ans = new ResizableArray<A>();
		for(int i=start; i<end; i++){
			ans.add(data[i]);
		}
		return ans;
	}
	public int lastIndexOf(A x){
		int ans=-1;
		for(int i=size-1; i>=0; i--){
			if(data[i].equals(x))
				return i;
		}
		return ans;
	}
	
	public static void main(String[] args){
		ResizableArray<Integer> y = new ResizableArray<Integer>();
		int[] values={3,2,1,4,5,6,7,4,7, 8, 9, 10};
		y.add(6);
		y.add(7);
		y.add(3);
		y.add(5);
		y.remove(1);
		y.insert(2, -100);
		System.out.println(y);
		System.out.println(y.size());
		System.out.println(y.get(2));
		y.set(3, 12);
		System.out.println(y);
		y.sort();
		System.out.println(y);
		System.out.println(y.indexOf(3));
		System.out.println(y.indexOf(7));
		ResizableArray<String> x = new ResizableArray<String>();
		x.add("a");
		x.add("b");
		x.add("C");
		System.out.println(x);
		System.out.println(x.size());
		System.out.println(x.get(2));
		x.sort();
		System.out.println(x);
		x.set(1, "hi");
		System.out.println(x);
		System.out.println(x.indexOf("b"));
		System.out.println(x.indexOf("seven"));
		
		for(String w: x)
			System.out.print(w+" ");
		for(Integer w: y)
			System.out.print(w+" ");
	}
	
	
}


