import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.*;

public class Main {

    public static void main(String[] args) {

      EntityManagerFactory factory= Persistence.createEntityManagerFactory("xxx");
        EntityManager manager = factory.createEntityManager();

            // uncomment it step by step!!

        // four rows below are used to create rows in the table
        // each run of the program adds next one object

//        manager.getTransaction().begin();
//        User user = new User("abricos");
//        System.out.println(user);
//        manager.persist(user);
//        System.out.println(user);
//        manager.getTransaction().commit();

      // two rows below allow to find a particular user
      // it is not obligatory to get a new transaction

//        User user= manager.find(User.class, 1);
//        System.out.println(user);

      // selecting List of users
//
//        TypedQuery<User> query=
//                manager.createQuery("select u from User u", User.class); // User is our table
//        List<User> resultList = query.getResultList();
//      System.out.println("resultList: "+resultList);
//
//      TypedQuery<User> query1=
//              manager.createQuery("select u from User u where u.id=2", User.class); // User is our table
//      List<User> resultList1 = query1.getResultList();
//      System.out.println("resultList1: "+resultList1);
//
//      TypedQuery<User> query2=
//              manager.createQuery("select u from User u where u.id=:id", User.class); // User is our table
//              query2.setParameter("id", 3); // customized request
//      List<User> resultList2 = query2.getResultList();
//      System.out.println("resultList2: "+resultList2);

      // deleting

      manager.getTransaction().begin();  // to delete getTransaction() is MUST
      User user = manager.find(User.class, 1);
      manager.remove(user);
      manager.getTransaction().commit();

      TypedQuery<User> query3=
                manager.createQuery("select u from User u", User.class); // User is our table
        List<User> resultList3 = query3.getResultList();
      System.out.println("resultList3: "+resultList3);

        manager.close();
        factory.close();
    }

}
}
