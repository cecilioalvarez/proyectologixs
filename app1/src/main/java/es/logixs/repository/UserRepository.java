package es.logixs.repository;

import es.logixs.domain.User;

import java.util.List;

public interface UserRepository {
    User insert(User user);

    void delete(User user);

    User findOne(String objectid);

    List<User> findAll();
}
