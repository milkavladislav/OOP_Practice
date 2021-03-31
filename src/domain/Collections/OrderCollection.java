package domain.Collections;

import domain.Classes.Order;
import domain.Classes.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderCollection {
    private ArrayList<Order> collection = new ArrayList<Order>();

    public void addOrder(Order order){
        collection.add(order);
    }

    public ArrayList<Order> returnCollection(){
        return this.collection;
    }

    public void sortById(){
        Collections.sort(collection, Comparator.comparing(Order::getId));
    }

    public void sortByName(){
        Collections.sort(collection, Comparator.comparing(Order::getName));
    }

    public void sortByCourier(){
        Collections.sort(collection, Comparator.comparing(Order::getCourier));
    }

    @Override
    public String toString() {
        String string = new String("Collection of orders :\n");
        for(Order order : collection){
            string += order.toString() + "\n";
        }
        return string;
    }
}
