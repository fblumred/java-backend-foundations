package com.capgemini.training.todoapp.task.dataccess.repository;

import com.capgemini.training.todoapp.task.dataaccess.entity.TaskListEntity;
import com.capgemini.training.todoapp.task.dataaccess.repository.TaskListRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TaskListRepositoryTest {

    @Autowired
    private TaskListRepository taskListRepository;
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Test
    void testFindAll() {
        //given-when
        List<TaskListEntity> result = taskListRepository.findAll();
        
        //then
        assertThat(result)
                .isNotEmpty()
                .hasSize(4);
    }

    @Test
    void testFindByNameLikeIgnoreCase() {
        //given-when
        List<TaskListEntity> result = taskListRepository.findByNameIgnoreCaseContaining("developer");

        //then
        assertThat(result)
                .isNotEmpty()
                .hasSize(1);
    }

    @Test
    void testFindWithoutAnyTaskItem() {
        //given-when
        Optional<TaskListEntity> result = taskListRepository.findWithoutAnyTaskItem();

        //then
        assertThat(result)
                .isNotEmpty()
                .get()
                .hasFieldOrPropertyWithValue("name", "Empty Tasks");
    }

    @Test
    void testFindWithMoreThanOneTask() {
        //given-when
        List<TaskListEntity> result = taskListRepository.findWithMoreThanOneTaskItem(entityManager);

        //then
        assertThat(result)
                .isNotEmpty()
                .hasSize(1)
                .anyMatch(taskList -> taskList.getName().equals("Business Analysis Tasks"));
    }
}
