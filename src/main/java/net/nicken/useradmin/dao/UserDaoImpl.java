package net.nicken.useradmin.dao;

import net.nicken.useradmin.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);

    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if(user != null){
            session.delete(user);
        }

    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Integer(id));
        return user;
    }

    private static final int limitResultsPerPage = 3;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUser(Integer page) {
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createQuery(
                "from User");
        page--;
        q.setFirstResult(page*limitResultsPerPage);
        q.setMaxResults(limitResultsPerPage);
        return (List<User>) q.list();
    }

    @Override
    public Integer size() {
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createQuery(
                "select count(*) from User");
        return (int) (long) q.uniqueResult();
    }

    @Override
    public List<User> searchUser(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createQuery(
                "from User u where u.name = '"+name+"'");
        return (List<User>) q.list();
    }
}
