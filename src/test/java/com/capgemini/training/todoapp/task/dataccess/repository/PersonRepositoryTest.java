package com.capgemini.training.todoapp.task.dataccess.repository;

import com.capgemini.training.todoapp.task.dataaccess.entity.PersonEntity;
import com.capgemini.training.todoapp.task.dataaccess.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    
    @Test
    void testFindByEmail() {
        //given
        String email = "developer@capgemini.com";
         
        // when
        Optional<PersonEntity> result = personRepository.findByEmail(email);
        
        //then
        assertThat(result)
                .isNotNull()
                .get()
                .hasFieldOrPropertyWithValue("id", -2L)
                .hasFieldOrPropertyWithValue("email", email);
    }
}
