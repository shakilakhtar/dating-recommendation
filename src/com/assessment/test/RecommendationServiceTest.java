package com.assessment.test;

import com.assessment.domain.User;
import com.assessment.service.RecommendationService;
import com.assessment.service.RecommendationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecommendationServiceTest {

    private RecommendationService recommendationService;

    @Before
    public void init() {
        recommendationService = new RecommendationServiceImpl();
    }

    @Test
    public void findMatch() throws Exception {
        User user = new User();
        user.setUserId(2);
        user.setName("UserB");
        user.setGender("Male");
        user.setAge(27);
        List<String> u2i = new ArrayList<>();
        u2i.addAll(Arrays.asList(new String[]{"Cricket", "Football", "Movies"}));
        user.setInterests(u2i);
        List<User> matches = recommendationService.findMatch(user, 2);
        Assert.assertEquals(2, matches.size());
    }
}
