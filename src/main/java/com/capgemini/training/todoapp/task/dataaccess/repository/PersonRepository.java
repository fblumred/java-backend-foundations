package com.capgemini.training.todoapp.task.dataaccess.repository;

import com.capgemini.training.todoapp.task.dataaccess.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    
    Optional<PersonEntity> findByEmail(String email);
}
