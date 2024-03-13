package com.capgemini.training.todoapp.task.dataaccess.repository;

import com.capgemini.training.todoapp.task.dataaccess.entity.QTaskListEntity;
import com.capgemini.training.todoapp.task.dataaccess.entity.TaskListEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskListRepository extends JpaRepository<TaskListEntity, Long> {
    
    List<TaskListEntity> findByNameIgnoreCaseContaining(String name);
    
    Optional<TaskListEntity> findWithoutAnyTaskItem();
    
    default List<TaskListEntity> findWithMoreThanOneTaskItem(EntityManager entityManager) {

        QTaskListEntity taskList = QTaskListEntity.taskListEntity;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);

        return jpaQueryFactory
                .select(taskList)
                .from(taskList)
                .where(taskList.taskItems.size().gt(1))
                .fetch();
    }
}
