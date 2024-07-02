package edu.frecc.csc1061j.MyTreeMap;

import java.util.Scanner;

public class TreeMapTest {

	public static void main(String[] args) 
	{
		MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
		map.put(8, 8);
		map.put(12, 12);
		map.put(4, 4);
		map.put(14, 14);
		map.put(10, 10);
		map.put(6, 6);
		map.put(2, 2);
		map.put(1, 1);
		map.put(3, 3);
		map.put(7, 7);
		map.put(5, 5);
		map.put(11, 11);
		map.put(9, 9);
		map.put(13, 13);
		map.put(15, 15);

		
		printInOrder(map); //prints out original 15 key map
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a number to remove");
		int userNum;  //select key to remove
		userNum = sc.nextInt();
		int removeKey = map.remove(userNum);
		System.out.println("\nRemoved Key: " + (removeKey));
		printInOrder(map); //prints out new key map with removed node

	}
	
	private static void printInOrder(MyTreeMap<Integer, Integer> map)
	{
		for (Integer value: map)
		{
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
