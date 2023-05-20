package com.examenes.examenesbackend.repositories;

import com.examenes.examenesbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long> {
}
