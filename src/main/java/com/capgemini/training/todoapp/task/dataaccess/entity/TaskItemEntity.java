package com.capgemini.training.todoapp.task.dataaccess.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "TASK_ITEM")
@Getter
@Setter
public class TaskItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Version
    private Long version;
    
    @Column
    private String name;
    
    @Column
    private Boolean completed;
    
    @Column
    private Instant deadline;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private TaskListEntity taskList;
}
