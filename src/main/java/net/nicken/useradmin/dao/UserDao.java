package net.nicken.useradmin.dao;

import net.nicken.useradmin.model.User;

import java.util.List;

/**
 * Created by Nicken on 13.11.2016.
 */
public interface UserDao {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> listUser(Integer page);

    public Integer size();

    public List<User> searchUser(String name);
}
