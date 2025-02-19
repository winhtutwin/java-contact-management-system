public class Contact {
    private String name;
    private String type; // Personal or Business
    private String phoneNumber;

    // Constructor
    public Contact(String name, String type, String phoneNumber) {
        this.name = name;
        this.type = type;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods for each field

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + type + ", Phone: " + phoneNumber;
    }
}
