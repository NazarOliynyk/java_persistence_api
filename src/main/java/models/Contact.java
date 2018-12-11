package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ElementCollection
    private List<String> phoneNumber;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //EAGER gives a user when a contact is called
    private User user;

    public Contact() {
    }

    public Contact(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact(List<String> phoneNumber, User user) {
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (phoneNumber != null ? !phoneNumber.equals(contact.phoneNumber) : contact.phoneNumber != null) return false;
        return user != null ? user.equals(contact.user) : contact.user == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    // do not send user to toString()!
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
