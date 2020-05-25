package com.assessment.repository;

import com.assessment.domain.User;
import com.assessment.exception.ApplicationException;

import java.util.List;

public interface UserRepository {

    List<User> getUsers() throws ApplicationException;

    User getUserById(int userId) throws ApplicationException;

    List<User> findUsersAgeBetween(int minAge, int maxAge) throws ApplicationException;
}
