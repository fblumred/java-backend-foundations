package com.capgemini.training.todoapp.task.dataaccess.repository;

import com.capgemini.training.todoapp.task.dataaccess.entity.TaskItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TaskItemRepository extends JpaRepository<TaskItemEntity, Long> {

    List<TaskItemEntity> findByCompletedFalseAndDeadlineLessThan(Date deadline);
    
    @Query("SELECT item FROM TaskItemEntity item WHERE item.deadline BETWEEN :earlierDate AND :laterDate")
    List<TaskItemEntity> findByDeadlineInGivenRange(@Param("earlierDate") Date earlierDate,
                                                    @Param("laterDate") Date laterDate);
}
