package com.assessment.service;

import com.assessment.domain.User;
import com.assessment.exception.ApplicationException;
import com.assessment.helper.RuleHelper;
import com.assessment.repository.UserRepository;
import com.assessment.repository.UserRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class RecommendationServiceImpl implements RecommendationService {

    private RuleHelper ruleHelper;
    private UserRepository userRepository;

    public RecommendationServiceImpl() {
        ruleHelper = new RuleHelper();
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public List<User> findMatch(User user, int top) throws ApplicationException {
        // first find closet age from store then apply other rules
        //Taking min age as -5 from user's actual age and max age user's age. this value can be configured
        List<User> users = userRepository.findUsersAgeBetween(user.getAge() - 5, user.getAge());
        //remove the asked user's profile
        List<User> filteredUsers = users.stream()
                .filter(u -> u.getUserId() != user.getUserId())
                .collect(Collectors.toList());
        return ruleHelper.applyRules(user, filteredUsers, top);

    }


}
