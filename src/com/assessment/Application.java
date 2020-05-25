package com.assessment;

import com.assessment.domain.User;
import com.assessment.exception.ApplicationException;
import com.assessment.service.RecommendationService;
import com.assessment.service.RecommendationServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

public class Application {


    public static void main(String[] args) throws ApplicationException {
        User user = new User();
        user.setUserId(2);
        user.setName("UserB");
        user.setGender("Male");
        user.setAge(27);
        List<String> u2i = new ArrayList<>();
        u2i.addAll(Arrays.asList(new String[]{"Cricket", "Football", "Movies"}));
        user.setInterests(u2i);

        RecommendationService rs = new RecommendationServiceImpl();
        List<User> matches = rs.findMatch(user, 2);
        matches.forEach(u -> System.out.println(u.getName()));
    }

}