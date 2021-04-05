package domain.Classes;

import domain.Interfaces.PrintObject;
import java.io.Serializable;

public class Contact implements PrintObject, Serializable {
    
    private long id;
    private String firstName;
    private String lastName;
    private String address;

    public Contact(String firstName, String lastName, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        setId();
    }

    public long getId(){
        return id;
    }

    private void setId(){
        this.id = System.currentTimeMillis();
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    @Override
    public String toString(){
        return "Contacts id: " + id +
        ", firstName: " + firstName +
        ", lastName: " + lastName +
        ", address " + address;
    }
}
