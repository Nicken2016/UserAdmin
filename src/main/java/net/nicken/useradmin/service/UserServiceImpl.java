package net.nicken.useradmin.service;

import net.nicken.useradmin.dao.UserDao;
import net.nicken.useradmin.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nicken on 13.11.2016.
 */
@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUser(Integer page) {
        return this.userDao.listUser(page);
    }

    @Override
    @Transactional
    public Integer size() {
        return this.userDao.size();
    }

    @Override
    @Transactional
    public List<User> searchUser(String name) {
        return this.userDao.searchUser(name);
    }
}
