package domain;

public class Contact {
    static int ID = 1;
    
    private int id;
    private String firstName;
    private String lastName;
    private String address;

    public Contact(String firstName, String lastName, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        setId();
    }

    public int getId(){
        return id;
    }

    private void setId(){
        this.id = ID;
        ID++;
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
