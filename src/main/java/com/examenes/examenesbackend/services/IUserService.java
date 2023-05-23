package com.examenes.examenesbackend.services;

import com.examenes.examenesbackend.entities.User;
import com.examenes.examenesbackend.entities.UserRole;

import java.util.Set;

public interface IUserService {
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception;

}
