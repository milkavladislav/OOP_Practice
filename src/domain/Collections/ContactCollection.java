package domain.Collections;

import domain.Classes.Contact;
import domain.Classes.Order;
import domain.Interfaces.PrintObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ContactCollection implements PrintObject, Serializable {
    private ArrayList<Contact> collection = new ArrayList<Contact>();

    public void addContact(Contact contact){
        collection.add(contact);
    }

    public ArrayList<Contact> returnCollection(){
        return this.collection;
    }

    public void sortById(){
        Collections.sort(collection, Comparator.comparing(Contact::getId));
    }

    public void sortByFirstName(){
        Collections.sort(collection, Comparator.comparing(Contact::getFirstName));
    }

    public void sortByLastName(){
        Collections.sort(collection, Comparator.comparing(Contact::getLastName));
    }

    @Override
    public String toString() {
        String string = new String("Collection of contacts :\n");
        for(Contact contact : collection){
            string += contact.toString() + "\n";
        }
        return string;
    }
}
