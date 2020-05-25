package com.assessment.repository;

import com.assessment.domain.User;
import com.assessment.exception.ApplicationException;

import java.util.*;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {

    //Keeping data map of users but this should be fetched from database
    Map<Integer, User> store = new HashMap<>();

    public UserRepositoryImpl() {
        if (store.isEmpty()) {
            loadTestData();
        }
    }


    @Override
    public List<User> getUsers() throws ApplicationException {
        return new ArrayList<>(store.values());
    }

    @Override
    public User getUserById(int userId) throws ApplicationException {
        if (!store.containsKey(userId)) {
            throw new ApplicationException("User not found");
        }
        return store.get(userId);
    }

    @Override
    public List<User> findUsersAgeBetween(int minAge, int maxAge) throws ApplicationException {
        List<User> list = store.values().stream().filter(u -> u.getAge() <= maxAge ||
                u.getAge() >= minAge).collect(Collectors.toList());

        return list;
    }


    public void loadTestData() {

        User u1 = new User();
        u1.setUserId(1);
        u1.setName("UserA");
        u1.setGender("Female");
        u1.setAge(25);
        List<String> u1i = new ArrayList<>();
        u1i.addAll(Arrays.asList(new String[]{"Cricket"}));
        u1.setInterests(u1i);

        store.put(u1.getUserId(), u1);

        User u2 = new User();
        u2.setUserId(2);
        u2.setName("UserB");
        u2.setGender("Male");
        u2.setAge(27);
        List<String> u2i = new ArrayList<>();
        u2i.addAll(Arrays.asList(new String[]{"Cricket", "Football", "Movies"}));
        u2.setInterests(u2i);

        store.put(u2.getUserId(), u2);

        User u3 = new User();
        u3.setUserId(3);
        u3.setName("UserC");
        u3.setGender("Male");
        u3.setAge(26);
        List<String> u3i = new ArrayList<>();
        u3i.addAll(Arrays.asList(new String[]{"Movies", "Tennis", "Football", "Cricket"}));
        u3.setInterests(u3i);
        store.put(u3.getUserId(), u3);

        User u4 = new User();
        u4.setUserId(4);
        u4.setName("UserD");
        u4.setGender("Female");
        u4.setAge(24);
        List<String> u4i = new ArrayList<>();
        u4i.addAll(Arrays.asList(new String[]{"Tennis", "Football", "Badminton"}));
        u4.setInterests(u4i);
        store.put(u4.getUserId(), u4);


        User u5 = new User();
        u5.setUserId(5);
        u5.setName("UserE");
        u5.setGender("Female");
        u5.setAge(32);
        List<String> u5i = new ArrayList<>();
        u5i.addAll(Arrays.asList(new String[]{"Cricket", "Football", "Movies", "Badminton"}));
        u5.setInterests(u5i);
        store.put(u5.getUserId(), u5);


        //test data to be populated
//        UserA     Female 25     Cricket
//        UserB     Male 27     Cricket, Football, Movies
//
//        UserC     Male 26     Movies, Tennis, Football, Cricket
//        UserD     Female 24     Tennis, Football, Badminton
//        UserE     Female 32    Cricket, Football, Movies, Badminton

    }

}
