package domain.Collections;

import domain.Classes.CloseContact;
import domain.Classes.Contact;
import domain.Interfaces.PrintObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CloseContactCollection implements PrintObject, Serializable {
    private ArrayList<CloseContact> collection = new ArrayList<CloseContact>();

    public void addContact(CloseContact closeContact){
        collection.add(closeContact);
    }

    public ArrayList<CloseContact> returnCollection(){
        return this.collection;
    }

    public void sortById(){
        Collections.sort(collection, Comparator.comparing(CloseContact::getId));
    }

    public void sortByFirstName(){
        Collections.sort(collection, Comparator.comparing(CloseContact::getFirstName));
    }

    public void sortByLastName(){
        Collections.sort(collection, Comparator.comparing(CloseContact::getLastName));
    }

    public void sortByFamilyConnection(){
        Collections.sort(collection, Comparator.comparing(CloseContact::getFamilyConnection));
    }

    @Override
    public String toString() {
        String string = new String("Collection of close contacts :\n");
        for(Contact contact : collection){
            string += contact.toString() + "\n";
        }
        return string;
    }
}
