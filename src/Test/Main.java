package Test;

import domain.*;



public class Main {

    
    public static void main(String[] args) {
        Students Armen = new Students(1, "Armen", "Mahmad", 34, "Military");
        System.out.println(Armen.toString());
        Order MyOrder = new Order(1, "Vlad", "Dima");
        System.out.println(MyOrder.toString());
        Contact Vlad = new Contact("Vlad", "Milka", "Poltava");
        System.out.println(Vlad.toString());
        CloseContact Brother = new CloseContact("Bogdan", "Milka", "Poltava", "03.12.2000", "brother");
        System.out.println(Brother.toString());
    }
    
}
