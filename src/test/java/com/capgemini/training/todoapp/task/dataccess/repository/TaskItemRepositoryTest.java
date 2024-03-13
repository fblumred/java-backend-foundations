package com.capgemini.training.todoapp.task.dataccess.repository;

import com.capgemini.training.todoapp.task.dataaccess.entity.TaskItemEntity;
import com.capgemini.training.todoapp.task.dataaccess.repository.TaskItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TaskItemRepositoryTest {

    @Autowired
    private TaskItemRepository taskItemRepository;
    
    @Test
    void testFindByCompletionFalseAndDeadlineExceeded() {
        //given
        Date date = Date.valueOf("2024-06-01");
         
        // when
        List<TaskItemEntity> result = taskItemRepository.findByCompletedFalseAndDeadlineLessThan(date);
        
        //then
        assertThat(result)
                .isNotEmpty()
                .hasSize(2);
    }

    @Test
    void testFindByDeadlineInGivenRange() {
        //given
        Date earlierDate = Date.valueOf("2024-01-01");
        Date laterDate = Date.valueOf("2024-06-01");

        // when
        List<TaskItemEntity> result = taskItemRepository.findByDeadlineInGivenRange(earlierDate, laterDate);

        //then
        assertThat(result)
                .isNotEmpty()
                .hasSize(2);
    }
}
