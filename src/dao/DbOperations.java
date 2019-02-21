package dao;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Query;
//import javax.persistence.Query; //deprecated
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import pojosGenerados.Student;
 
public class DbOperations {
 
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
 
   
 
    // This Method Is Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure();
 
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
       // ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
 
        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory();
        return sessionFactoryObj;
    }
 
    // Method 1: This Method Used To Create A New Student Record In The Database Table
    public static void insertarStudent(Student s) {        
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
            sessionObj.save(s);
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            System.out.println("\nSuccessfully Created  Records In The Database!\n");
        } catch (PersistenceException pe) {
        	System.out.println("Capturada excepción PersistenceException");
        	pe.printStackTrace();
        	System.out.println(pe.getCause().getCause());
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
 
    // Method 2: This Method Is Used To Display The Records From The Database Table
  //  @SuppressWarnings("unchecked")
    public static List<Student> devuelveTodosStudent() {
        List<Student> studentsList = new ArrayList<Student>();        
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
 
            studentsList = sessionObj.createQuery("FROM Student").list();
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
        return studentsList;
    }
 
    // Method 3: This Method Is Used To Update A Record In The Database Table   
    public static void modificaStudent(Student s) {       
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
 
            // Creating Transaction Entity
            Student stuObj = (Student) sessionObj.get(Student.class, s.getId());
            stuObj = s;
 
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            System.out.println("\nStudent With Id?= " + s.getId() + " Is Successfully Updated In The Database!\n");
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
 
    // Method 4(a): This Method Is Used To Delete A Particular Record From The Database Table
    public static void eliminaStudent(int student_id) {
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
 
            Student studObj = devuelveStudentPorId(student_id);
            sessionObj.delete(studObj);
 
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            System.out.println("\nStudent With Id?= " + student_id + " Is Successfully Deleted From The Database!\n");
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
 
    // Method 4(b): This Method To Find Particular Record In The Database Table
    public static Student devuelveStudentPorId(int find_student_id) {
        Student findStudentObj = null;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
 
            findStudentObj = (Student) sessionObj.load(Student.class, find_student_id);
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
               System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } 
        return findStudentObj;
    }
 
    // Method 5: This Method Is Used To Delete All Records From The Database Table
    public static void borrarTodosStudents() {
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
 
            Query queryObj = sessionObj.createQuery("DELETE FROM Student");
            queryObj.executeUpdate();
 
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
          System.out.println("\nSuccessfully Deleted All Records From The Database Table!\n");
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}