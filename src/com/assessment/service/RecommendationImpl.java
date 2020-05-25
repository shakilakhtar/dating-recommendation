package com.assessment.service;

import com.assessment.domain.User;
import com.assessment.exception.ApplicationException;
import com.assessment.helper.RuleHelper;
import com.assessment.repository.UserRepository;
import com.assessment.repository.UserRepositoryImpl;

import java.util.List;

public class RecommendationImpl implements Recommendation {

    private RuleHelper ruleHelper;
    private UserRepository userRepository;

    public RecommendationImpl() {
        ruleHelper = new RuleHelper();
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public List<User> findMatch(User user, int top) throws ApplicationException {
        // first find closet age from store then apply other rules
        //Taking min age as -1 from user's actual age and max age +2 user's age. this value can be configured
        List<User> filteredUsers = userRepository.findUsersAgeBetween(user.getAge() - 1, user.getAge() + 2);
        return ruleHelper.applyRules(user, filteredUsers, top);

    }


}
