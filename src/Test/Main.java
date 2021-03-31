package Test;

import domain.Classes.*;
import domain.Collections.*;


import java.util.Scanner;



public class Main {

    
    public static void main(String[] args) {
        OrderCollection orderCollection = new OrderCollection();

        orderCollection.addOrder(new Order(4, "FFF", "Aaa"));
        orderCollection.addOrder(new Order(1, "GGG", "ZZZ"));
        orderCollection.addOrder(new Order(3, "CCC", "YYY"));
        orderCollection.addOrder(new Order(2, "JJJ", "BBB"));

        orderCollection.sortById();
        System.out.println(orderCollection.toString());
        orderCollection.sortByName();
        System.out.println(orderCollection.toString());
        orderCollection.sortByCourier();
        System.out.println(orderCollection.toString());

    }
    
}
