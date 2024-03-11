package com.capgemini.training.todoapp.task.dataaccess.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERSON")
@Getter
@Setter
public class PersonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Version
    private Long version;
    
    @Column
    private String email;
    
    @OneToOne
    @JoinColumn(name = "TASK_LIST_ID", referencedColumnName = "ID")
    private TaskListEntity taskList;
}
