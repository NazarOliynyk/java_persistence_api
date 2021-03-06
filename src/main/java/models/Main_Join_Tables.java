package models;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Main_Join_Tables {
    public static void main(String[] args) {

        EntityManagerFactory factory= Persistence.createEntityManagerFactory("xxx");
        EntityManager manager = factory.createEntityManager();

        // uncomment it step by step!!

        // selecting List of users

//        TypedQuery<User> query=
//                manager.createQuery("select u from User u", User.class); // User is our table
//        List<User> resultList = query.getResultList();
//      System.out.println("resultList: "+resultList);

            // creating a user alex and filling one his contact with 2 numbers:

//      manager.getTransaction().begin();
//      List<Contact> contacts = new ArrayList<>();
//      List<String> numbers= new ArrayList<>();
//      numbers.add("+380676752921");
//      numbers.add("+380322419839");
//      contacts.add(new Contact(numbers));
//      User user = new User("alex", contacts);
//      manager.persist(user);
//      manager.getTransaction().commit();

        // it fills all but does not bind contact id with user_id

             // it binds contact id=1 to user id = 4(alex)
//        manager.getTransaction().begin();
//
//        User user = manager.find(User.class, 4);
//        TypedQuery<Contact> queryContacts=
//                manager.createQuery("from Contact c", Contact.class);
//        List<Contact> contacts = queryContacts.getResultList();
//        for (Contact contact : contacts) {
//            contact.setUser(user);
//        }
//
//        manager.getTransaction().commit();


        // below is the proper way - create a new contact an specify a User inside:
//
//        manager.getTransaction().begin();
//        List<String> numbers2= new ArrayList<>();
//        numbers2.add("+38050511111");
//        numbers2.add("+38097222222");
//        Contact contact2 = new Contact(numbers2, new User("asdqw"));
//        manager.persist(contact2);
//        manager.getTransaction().commit();


        // deleting

        manager.getTransaction().begin();

        User user = manager.find(User.class, 5);
        manager.remove(user);
        manager.getTransaction().commit();


        manager.close();
        factory.close();
    }

}


