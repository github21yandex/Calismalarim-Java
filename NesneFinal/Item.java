package NesneFinal;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.List;


public class Item<E> implements Comparable<Item<E>> {
    
	public double weight;
	public double value;

	public Item(double value, double weight) {

        this.value = value;
        this.weight = weight;  
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setWeight(double weight) {
    	this.weight = weight;
    }

    public double getValue() {
    	return this.value;
    }

    public double getWeight() {
    	return this.weight;
    }
    
    
    public ArrayList<Item<E>> sort(ArrayList<Item<E>>  itemL){
    
        Collections.sort(itemL);
        return itemL;
    }
    

    @Override
    public int compareTo( Item<E> obj) {
        Item<E> item = (Item<E>) obj;
        if( this.getValue() == item.getValue() ){

            if( this.getWeight() == item.getWeight() ){

                return 0;
            }
            else if( this.getWeight() > item.getWeight() ){

                return 1;
            }
            else{

                return -1;
            }

        }
        else if ( this.getValue() > item.getValue() ){

            return 1;
        }
        else {

            return -1;
        }
        
    }

    @Override
    public String toString() {
        return "Item [value=" + value + ", weight=" + weight + "]";
    }



    
} //class Item<E> sonu
