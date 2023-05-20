package com.examenes.examenesbackend.repositories;

import com.examenes.examenesbackend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRole extends JpaRepository<Role, Long> {
}
