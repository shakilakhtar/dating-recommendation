package com.assessment.service;

import com.assessment.domain.User;
import com.assessment.exception.ApplicationException;

import java.util.List;

public interface Recommendation {

    List<User> findMatch(User user,int top) throws ApplicationException;
}
