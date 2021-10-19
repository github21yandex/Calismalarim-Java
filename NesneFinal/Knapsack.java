package NesneFinal;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * 08 July 2020
 * 
 * @author Onur ŞAHİN
 * @param <E>
 */
public class Knapsack<E> {

	public double capacity;

	public ArrayList<Item<E>> knapsack;

	public Knapsack(double capacity) {

		this.capacity = capacity;
		knapsack = new ArrayList<Item<E>>();
	}

	public double getCapacity() {

		return this.capacity;
	}

	public ArrayList<Item<E>> getItems() {

		return this.knapsack;
	}

	public void setCapacity(double capacity) {

		this.capacity = capacity;
	}

	public void setItems(ArrayList<Item<E>> items) {

		Iterator<Item<E>> iterator = items.iterator();

		while (iterator.hasNext()) {

			if (this.spaceCapasity() >= iterator.next().getWeight()) {
				pushItem(iterator.next());
			}
		}

	}

	public double currentWeight() {

		double sum = 0;

		for (Item<E> item : knapsack) {
			sum += item.getWeight();
		}

		return sum;

	}

	public double currentValue() {

		double sum = 0;

		for (Item<E> item : knapsack) {
			sum += item.getValue();
		}
		return sum;
	}

	public boolean pushItem(Item<E> item) {

		if (item.weight <= this.spaceCapasity()) {

			knapsack.add(item);
			return true;
		}

		return false;
	}

	public double getMaximumValue(ArrayList<Item<E>> newItems) {

		getMaximalItemSet(newItems);
		
		return currentValue();
		
	}

	public void addSetToSet(ArrayList<Item<E>> targetSet, ArrayList<Item<E>> sourceSet) {

		if (sourceSet != null) {

			for (int i = 0; i < sourceSet.size(); i++) {
				targetSet.add(sourceSet.get(i));
			}
		}

	}

	public void addSetToSet(ArrayList<Item<E>> targetSet, Item<E> item) {
		if (item != null) {
			targetSet.add(item);
		}
	}

	public double spaceCapasity() { // O anda knapsack ArrayList in boş kapasitesini döndürür

		return this.getCapacity() - this.currentWeight();
	}

	public ArrayList<Item<E>> getMaximalItemSet(ArrayList<Item<E>> newItems) {

		int row = newItems.size() + 1;
		int column = (int) this.spaceCapasity() + 1;

		double[][] F = new double[row][column];                                 // toplam value değerleri içerir

		@SuppressWarnings("unchecked")
		ArrayList <Item<E>>[][] set = new ArrayList [row][column] ;                        // F[i][j] nin içermiş olduğu value değerini oluşturan tüm Itemleri içeren ArrayListleri tutar. 
 

		for (int i = 1; i < row; i++) {

			Item<E> item_i = newItems.get(i - 1);                                   // for döngüsünde i inci satırdaki elemanı tutar
			int value_i = (int) newItems.get(i - 1).getValue();                  // for döngüsünde i inci satırdaki elemanının değerini tutar
			int weight_i = (int) newItems.get(i - 1).getWeight();                // for döngüsünde i inci satırdaki elemanın ağırlığını tutar

			for (int j = 1; j < column; j++) {

				set[i][j] = new ArrayList<Item<E>>();                                // set[i][j] ninci boş ArrayList kümesi oluşturulur.

				if (j >= weight_i) {

					if (value_i + F[i - 1][j - weight_i] > F[i - 1][j]) {

						F[i][j] = value_i + F[i - 1][j - weight_i];

						addSetToSet(set[i][j], item_i);
						addSetToSet(set[i][j], set[i - 1][j - weight_i]);

					} else {

						F[i][j] = F[i - 1][j];
						addSetToSet(set[i][j], set[i - 1][j]);
					}


				} else {

					F[i][j] = F[i - 1][j];
					addSetToSet(set[i][j], set[i - 1][j]);
				}

			} // iç for sonu
		} //dış for sonu
        
        addSetToSet(knapsack, set[row - 1][column - 1]);

		return knapsack;
	}

}