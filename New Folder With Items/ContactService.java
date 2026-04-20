package Appointment;

import java.util.HashMap;

public class ContactService {

    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId()))
            throw new IllegalArgumentException();

        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String id) {
        if (!contacts.containsKey(id))
            throw new IllegalArgumentException();

        contacts.remove(id);
    }

    public void updateFirstName(String id, String name) {
        Contact c = contacts.get(id);
        if (c == null) throw new IllegalArgumentException();
        c.setFirstName(name);
    }

    public void updateLastName(String id, String name) {
        Contact c = contacts.get(id);
        if (c == null) throw new IllegalArgumentException();
        c.setLastName(name);
    }

    public void updatePhone(String id, String phone) {
        Contact c = contacts.get(id);
        if (c == null) throw new IllegalArgumentException();
        c.setPhone(phone);
    }

    public void updateAddress(String id, String addr) {
        Contact c = contacts.get(id);
        if (c == null) throw new IllegalArgumentException();
        c.setAddress(addr);
    }

    public Contact getContact(String id) {
        return contacts.get(id);
    }
}