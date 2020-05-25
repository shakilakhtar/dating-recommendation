package com.assessment.helper;

import com.assessment.domain.User;
import com.assessment.exception.ApplicationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RuleHelper {

    /**
     * Gender Rule: Opposite gender is given a preference.
     * Age rule: Closest match in terms of age is given a preference. ( Age rule is taken fro store)
     * Interest rule: Closest match in terms of interests is given a preference.
     *
     * @param u
     * @param filteredUsers
     * @param top
     * @return
     * @throws ApplicationException
     */
    public List<User> applyRules(User u, List<User> filteredUsers, int top) throws ApplicationException {
        //check if filtered users are more then apply other rules to filter
        List<User> finalResults = new ArrayList<>();
        if (!filteredUsers.isEmpty() && filteredUsers.size() > top) {
            List<User> genderFilter = applyGenderRule(u, filteredUsers);
            if (genderFilter.size() > top) {
                finalResults.addAll(applyInterestsRule(u, genderFilter, top));
            } else {
                finalResults.addAll(genderFilter);
            }

        } else {
            finalResults.addAll(filteredUsers);
        }
        return finalResults;
    }

    public List<User> applyGenderRule(User u, List<User> users) {
        return users.stream().filter(gender -> !gender.getGender().equalsIgnoreCase(u.getGender()))
                .collect(Collectors.toList());
    }

    public List<User> applyInterestsRule(User u, List<User> users, int top) {
        //first check all matching interests
        List<User> results = new ArrayList<>();
        //check all matching interests
        List<User> firstFilter = users.stream().filter(fu -> fu.getInterests().stream()
                .allMatch(i -> u.getInterests().contains(i)))
                .collect(Collectors.toList());

        if (firstFilter.size() > top) {
            //check any matching interests
            List<User> secondFilter = users.stream().filter(fu -> fu.getInterests().stream()
                    .anyMatch(i -> u.getInterests().contains(i)))
                    .collect(Collectors.toList());
            results.addAll(secondFilter);
        } else {

            results.addAll(firstFilter);
        }

        return results;
    }
}
