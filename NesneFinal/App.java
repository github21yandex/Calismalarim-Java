package NesneFinal;

import java.util.ArrayList;

public class App {
	public static <E> void main(String[] args) {

		ArrayList<Item<E>> items = new ArrayList<Item<E>>();

		

		//ArrayList<E> list = new ArrayList<E>();

		Knapsack<E> bag = new Knapsack<E>(5);
		

		items.add(new Item<E>(12, 2)); // items.add( new Item<>(42, 7) );
		items.add(new Item<E>(10, 1));
		items.add(new Item<E>(20, 3));
		items.add(new Item<E>(15, 2));

		//bag.pushItem(new Item(5, 2));

		
		

		//System.out.println(bag.getMaximumValue(items));
		
		System.out.println(bag.getMaximalItemSet(items));

		for (Item<E> item : bag.knapsack) {
			System.out.println(item);
		}
		
		//ArrayList<Item> itemsTemp = bag.getMaximalItemSet(items);

		// for (Item item : itemsTemp) {
		// 	System.out.println(item);
		// }

		

	

		//System.out.println(bag.getMaximumValue(items));

		

		

		//for (Item item : knapsack) {
		//	System.out.println(item);
		//}



	}
}