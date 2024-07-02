package edu.frcc.csc1061j.ArrayAndLinkedList;
import java.util.Arrays;
import java.util.List;


public class TestList1 {

	public static void main(String[] args) 
	{
		List<Integer> ml = new MyDoubleLinkedList<Integer>();
		ml.add(1);
		ml.add(2);
		ml.add(3);
		ml.add(4);
		ml.add(5);
		ml.add(6);
		
		System.out.println(Arrays.toString(ml.toArray()) + "size = " + ml.size());
		
		ml.remove(2);
		System.out.println(Arrays.toString(ml.toArray()) + "size = " + ml.size());
		
		ml.remove(3);
		System.out.println(Arrays.toString(ml.toArray()) + "size = " + ml.size());
		
	}

}
