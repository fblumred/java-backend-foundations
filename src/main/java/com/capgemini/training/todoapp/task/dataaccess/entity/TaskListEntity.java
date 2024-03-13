package com.capgemini.training.todoapp.task.dataaccess.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@NamedQuery(name = "TaskListEntity.findWithoutAnyTaskItem",
            query = "SELECT task FROM TaskListEntity task WHERE task.taskItems IS EMPTY ")
@Entity
@Table(name = "TASK_LIST")
@Getter
@Setter
public class TaskListEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Version
    private Long version;
    
    @Column
    private String name;
    
    @OneToMany(mappedBy = "taskList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TaskItemEntity> taskItems;
}
