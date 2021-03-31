package domain.Classes;

public class CloseContact extends Contact {

    private String birthday;
    private String familyConnection;

    public CloseContact(String firstName, String lastName, String address, String birthday, String familyConnection) {
        super(firstName, lastName, address);
        this.birthday = birthday;
        this.familyConnection = familyConnection;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getFamilyConnection(){
        return familyConnection;
    }

    public void setFamilyConnection(String familyConnection){
        this.familyConnection = familyConnection;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", birthday: " + birthday +
                ", family connection: " + familyConnection;
    }
}
