package domain.Collections;

import domain.Classes.CloseContact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CloseContactCollection {
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

    public void sortByFamilyConection(){
        Collections.sort(collection, Comparator.comparing(CloseContact::getFamilyConnection));
    }
}
