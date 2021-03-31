package domain.Collections;

import domain.Classes.CloseContact;
import domain.Classes.Contact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ContactCollection {
    private ArrayList<Contact> collection = new ArrayList<Contact>();

    public void addOrder(Contact contact){
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
}
