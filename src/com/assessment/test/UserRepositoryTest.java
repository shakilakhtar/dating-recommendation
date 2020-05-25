package com.assessment.test;

import com.assessment.domain.User;
import com.assessment.repository.UserRepository;
import com.assessment.repository.UserRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserRepositoryTest {
    private UserRepository userRepository;

    @Before
    public void init() {
        userRepository = new UserRepositoryImpl();
    }

    @Test
    public void getUsers() throws Exception {
        List<User> list = userRepository.getUsers();
        Assert.assertEquals(5, list.size());
    }

    @Test
    public void getUserById() throws Exception {
        User u = userRepository.getUserById(1);
        Assert.assertEquals("UserA", u.getName());
    }

    @Test
    public void findUsersAgeBetween() throws Exception {
        List<User> list = userRepository.findUsersAgeBetween(24, 26);
        Assert.assertEquals(3, list.size());
    }
}
