package com.to_do_list.dytechnology.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Long idTask;
    private String name;
    private String description;
    private boolean done;
    private  int priority;

    public TaskDone(Task dataTask){
        this.idTask =dataTask.getId();
        this.name = dataTask.getName();
        this.description = dataTask.getDescription();
        this.priority = dataTask.getPriority();
        if(dataTask.isDone()){
            this.done = true;
        }

    }
}


