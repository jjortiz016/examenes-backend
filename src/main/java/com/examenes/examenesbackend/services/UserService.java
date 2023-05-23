package com.examenes.examenesbackend.services;

import com.examenes.examenesbackend.entities.User;
import com.examenes.examenesbackend.entities.UserRole;
import com.examenes.examenesbackend.repositories.RepositoryRole;
import com.examenes.examenesbackend.repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService  implements IUserService{
    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private RepositoryRole repositoryRole;

    @Override
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception {
        User userLocal= repositoryUser.findByUsername(user.getUsername());
        if(userLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente!!");
        }else{
            for(UserRole userrole:userRoles){
                repositoryRole.save(userrole.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            userLocal = repositoryUser.save(user);
        }
        return userLocal;
    }
}
