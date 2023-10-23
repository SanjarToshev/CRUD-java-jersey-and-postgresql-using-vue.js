package uz.pdp.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import uz.pdp.data.Users;
import uz.pdp.util.HibernateUtil;
import java.util.List;

public class UserRepository {


    public List<Users> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Users", Users.class).list();
        }
    }

    public Users getUser(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Users.class, id);
        }
    }

    public void saveStudent(Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUsers(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Users WHERE userId = " + id).executeUpdate();
            transaction.commit();
        }catch (Exception e) {
            System.out.println(e);
        }

    }

    public void updateUser(Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
